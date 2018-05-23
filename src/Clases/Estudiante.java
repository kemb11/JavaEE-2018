/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="estudiante")
public class Estudiante extends Usuario {

    @OneToMany(mappedBy = "estudiante")
    private List<InscripcionC> inscripciones;
    private String ci, nombres, apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNac;
    @ManyToMany
    private List<Sede> sedes;
    @ManyToMany
    private List<Curso> cursosAprobados;
    @ManyToMany
    private List<Carrera> carreras;
    @OneToMany(mappedBy = "estudiante")
    private List<InscripcionE> examenes;
    @OneToMany
    private List<ResultadoP> notasParciales;

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

    public void setCursosAprobados(List<Curso> cursosAprobados) {
        this.cursosAprobados = cursosAprobados;
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

    public List<Curso> getCursosAprobados() {
        return cursosAprobados;
    }

    public List<Carrera> getCarreras() {
        return carreras;
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

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    public boolean estaInscriptoEnSede(Sede sede){
        for (Sede s : this.sedes) {
            if(s.equals(sede)){
                return true;
            }
        }        
        return false;
    }
    
    public boolean estaInscriptoEnCarrera(Carrera carrera){
        for (Carrera c : this.carreras) {
            if(c.equals(carrera)){
                return true;
            }
        }        
        return false;
    }
    
    public boolean estaInscriptoEnCurso(Curso curso){
        for (InscripcionC ic : this.inscripciones) {
            Curso c = ic.getCurso().getCurso();
            if(c.equals(curso)){
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
}
