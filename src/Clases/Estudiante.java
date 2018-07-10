
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "estudiante")
public class Estudiante extends Usuario {

    @OneToMany(mappedBy = "estudiante")
    private List<CursoAprobado> cursoAprobados;

    @OneToMany(mappedBy = "estudiante")
    private List<CarreraEstudiante> carreraEstudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<InscripcionC> inscripciones;
    private String ci, nombres, apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNac;
    @ManyToMany
    private List<Sede> sedes;
    @OneToMany(mappedBy = "estudiante")
    private List<InscripcionE> examenes;
    @OneToMany
    private List<ResultadoP> notasParciales;
    private boolean enviarMails;

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public void setExamenes(List<InscripcionE> examenes) {
        this.examenes = examenes;
    }

    public String getCi() {
        return ci;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public List<InscripcionC> getInscripciones() {
        return inscripciones;
    }

    public List<Curso> getListaCursosAprobados() {
        List<Curso> cursos = new ArrayList<>();
        if (this.cursoAprobados != null) {
            for (CursoAprobado ca : this.cursoAprobados) {
                cursos.add(ca.getCurso());
            }
        }
        return cursos;
    }

    public List<InscripcionE> getExamenes() {
        return examenes;
    }

    public void setNotasParciales(List<ResultadoP> parciales) {
        this.notasParciales = parciales;
    }

    public List<ResultadoP> getNotasParciales() {
        return notasParciales;
    }

    public void setInscripciones(List<InscripcionC> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public boolean setIncripcionC(CursoSede cs) throws Exception {
        if (estaInscriptoEnCurso(cs.getCurso())) {
            return false;
        } else {
            EntityManager em = Fabrica.getInstance().getEntity();
            em.getTransaction().begin();
            try {
                InscripcionC ins = new InscripcionC();
                ins.setCurso(cs);
                cs.setInscripcion(ins);
                ins.setFecha(new Date());
                ins.setEstudiante(this);
                this.inscripciones.add(ins);
                Fabrica.getInstance().getEntity().persist(ins);
                em.getTransaction().commit();
                return true;
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
        }
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public boolean estaInscriptoEnSede(Sede sede) {
        for (Sede s : this.sedes) {
            if (s.equals(sede)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaInscriptoEnCarrera(Carrera carrera) {
        for (Carrera c : getCarreras()) {
            if (c.equals(carrera) && this.habilitadoCarrera(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaInscriptoEnCurso(Curso curso) {
        for (InscripcionC ic : this.inscripciones) {
            Curso c = ic.getCurso().getCurso();
            if (c.equals(curso)) {
                return true;
            }
        }
        return false;
    }

    public boolean setIncripcionE(Examen examen) throws Exception {
        if (buscarInscripcionExamen(examen)) {
            return false;
        } else {
            EntityManager em = Fabrica.getInstance().getEntity();
            em.getTransaction().begin();
            try {
                InscripcionE ins = new InscripcionE();
                ins.setExamen(examen);
                ins.setFecha(new Date());
                ins.setEstudiante(this);
                this.examenes.add(ins);
                Fabrica.getInstance().getEntity().persist(ins);
                em.getTransaction().commit();
                return true;
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
                return false;
            }
        }
    }

    private boolean buscarInscripcionExamen(Examen examen) {
        for (InscripcionE inscripcion : this.examenes) {
            if (inscripcion.getExamen().equals(examen)) {
                return true;
            }
        }
        return false;
    }

    public List<Carrera> getCarreras() {
        List<Carrera> list = new ArrayList<>();
        if (carreraEstudiante != null) {
            for (CarreraEstudiante c : carreraEstudiante) {
                list.add(c.getCarrera());
            }
        }
        return list;
    }

    public void setCarrera(Carrera c) {
        if (carreraEstudiante == null) {
            carreraEstudiante = new ArrayList<>();
        }
        if (!estaInscriptoEnCarrera(c)) {
            CarreraEstudiante ce = new CarreraEstudiante();
            ce.setEstudiante(this);
            ce.setCarrera(c);
            ce.setCreditos(0);
            ce.setFechaInscripcion(new Date());
            ce.setAprobada(false);
            c.setEstudiante(ce);
            this.carreraEstudiante.add(ce);
            Fabrica.getInstance().getEntity().persist(ce);
        }
    }

    public void setSede(Sede S) {
        if (sedes == null) {
            sedes = new ArrayList<>();
        }
        if (!this.sedes.contains(S)) {
            this.sedes.add(S);
            S.setEstudiante(this);
        }
    }

    public boolean isEnviarMails() {
        return enviarMails;
    }

    public void setEnviarMails(boolean enviarMails) {
        this.enviarMails = enviarMails;
    }

    public void CursoAprobado(CursoAprobado ca, String nota) {
        if (this.cursoAprobados == null) {
            this.cursoAprobados = new ArrayList<>();
        }
        if (!this.cursoAprobados.contains(ca)) {
            this.cursoAprobados.add(ca);
            Fabrica.getInstance().getEntity().persist(ca);
            Fabrica.getInstance().getEntity().merge(this);
            if (ca.isAprobado()) {
                String texto = "Felicitanciones, ha aprobado el curso " + ca.getCurso().getNombre() + " pertenecienta a la carrera " + ca.getCurso().getCarrera().getNombre() + " con nota " + nota;
                Fabrica.getInstance().getContAdmin().enviarNotificacion("Curso aprobado", texto, this);
            } else {
                String texto = "Felicitanciones, ha ganado elderecho a examen del curso " + ca.getCurso().getNombre() + " pertenecienta a la carrera " + ca.getCurso().getCarrera().getNombre() + " con nota " + nota;
                Fabrica.getInstance().getContAdmin().enviarNotificacion("Derecho a examen", texto, this);
            }
        }
    }

    public ResultadoP AprobacionParcial(Parcial parcial) {
        if (this.notasParciales != null) {
            for (ResultadoP rp : this.notasParciales) {
                if (rp.getParcial().getCurso().equals(parcial.getCurso())) {
                    int dias = (int) ((parcial.getFecha().getTime() - rp.getParcial().getFecha().getTime()) / 86400000);
                    if (!rp.getParcial().getInstancia().equals(parcial.getInstancia()) && dias < 120) {
                        return rp;
                    }
                }
            }
        }
        return null;
    }

    public boolean derechoExamen(Curso c) {
        if (this.cursoAprobados != null) {
            for (CursoAprobado ca : this.cursoAprobados) {
                if (ca.getCurso().equals(c) && ca.isAprobado() == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cursoAprobado(Curso c) {
        if (this.cursoAprobados != null) {
            for (CursoAprobado ca : this.cursoAprobados) {
                if (ca.getCurso().equals(c) && ca.isAprobado() == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean previasAprobadas(Curso c) {
        if (c.getPrevias() != null && !c.getPrevias().isEmpty()) {
            for (Previa p : c.getPrevias()) {
                if (p.isExamenAprobado()) {
                    if (!this.cursoAprobado(p.getCurso())) {
                        return false;
                    }
                } else {
                    if (!this.derechoExamen(p.getCurso())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int cantNotifNoVista() {
        int cant = 0;
        for (Notificacion notif : notificaciones) {
            if (notif.isVista() == false) {
                cant += 1;
            }
        }
        return cant;
    }
    
    public Sede enQueSedeAprobo(CursoAprobado cursoAp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        for (InscripcionC inscripcion : this.inscripciones) {
            String[] array1 = dateFormat.format(inscripcion.getFecha()).split("-"); // divide la fecha, 0=dia, 1=mes, 2=año
            String[] array2 = dateFormat.format(cursoAp.getFecha()).split("-");
            
            if(array1[2].equals(array2[2])){
                return inscripcion.getCurso().getSede();
            }
        }
        
        return null;
    }

    public boolean habilitadoCarrera(Carrera c) {
        if (this.carreraEstudiante != null) {
            for (CarreraEstudiante ce : this.carreraEstudiante) {
                if (ce.getCarrera().equals(c) && ce.isHabilitado()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void inhabilitarCarrera(Carrera c) {
        if (this.carreraEstudiante != null) {
            for (CarreraEstudiante ce : this.carreraEstudiante) {
                if (ce.getCarrera().equals(c)) {
                    ce.inhabilitar();
                    break;
                }
            }
        }
    }

}
