/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import Persistencia.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cursosede")
public class CursoSede implements Serializable {

    @ManyToMany(mappedBy = "clases")
    private List<Docente> docentes;
    @OneToMany(mappedBy = "curso")
    private List<InscripcionC> inscripciones;
    @ManyToOne
    private Curso curso;
    @ManyToOne
    private Sede sede;
    @OneToMany(mappedBy = "curso")
    private List<Examen> exmenes;
    @OneToMany(mappedBy = "curso")
    private List<Parcial> parciales;
    @ManyToOne
    private Docente docente;
    @OneToMany(mappedBy = "curso")
    private List<Material> materiales;
    private int maxParciales, aproParciales, derechoExamen;

    public int getMaxParciales() {
        return maxParciales;
    }

    public int getDerechoExamen() {
        return derechoExamen;
    }

    public void setDerechoExamen(int derechoExamen) {
        this.derechoExamen = derechoExamen;
    }

    public void setMaxParciales(int maxParciales) {
        this.maxParciales = maxParciales;
    }

    public int getAproParciales() {
        return aproParciales;
    }

    public void setAproParciales(int aproParciales) {
        this.aproParciales = aproParciales;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public void setMaterial(Material material) {
        this.materiales.add(material);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoSede)) {
            return false;
        }
        CursoSede other = (CursoSede) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.CursoSede[ id=" + id + " ]";
    }

    public List<InscripcionC> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionC> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setInscripcion(InscripcionC ins) {
        if (this.inscripciones == null) {
            inscripciones = new ArrayList<>();
        }
        this.inscripciones.add(ins);
    }

    public List<Examen> getExmenes() {
        return exmenes;
    }

    public void setExmenes(List<Examen> exmenes) {
        this.exmenes = exmenes;
    }

    public List<Parcial> getParciales() {
        return parciales;
    }

    public void setParciales(List<Parcial> parciales) {
        this.parciales = parciales;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setExamen(Examen examen) {
        this.exmenes.add(examen);
        ExamenJpaController ejpa = new ExamenJpaController();
        ejpa.create(examen);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        notificarAlumnos("Nuevo examen", "Nuevo examen de " + curso.getNombre() + "\nFecha " + dateFormat.format(examen.getFecha())
                + "\nReplicar\nSaludos, gracias");
    }

    public void notificarAlumnos(String titulo, String mensaje) {
        for (InscripcionC i : inscripciones) {
            if (!i.isAprobado(curso) && i.isHabilitado()) {
                try {
                    SendEmail.EnviarMail(i.getEstudiante().getEmail(), titulo, mensaje);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(CursoSede.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void notificarAlumnosActuales(String titulo, String mensaje) {
        for (InscripcionC i : this.getEstudiantesActuales()) {
            if (i.isHabilitado()) {
                try {
                    SendEmail.EnviarMail(i.getEstudiante().getEmail(), titulo, mensaje);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(CursoSede.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<InscripcionC> getEstudiantesActuales() {
        List<InscripcionC> retornar = new ArrayList<>();
        if (inscripciones != null) {
            for (InscripcionC i : inscripciones) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date año;
                try {
                    año = dateFormat.parse("01/01/" + String.valueOf(Calendar.YEAR));
                    if (i.getFecha().after(año)) {
                        retornar.add(i);
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(CursoSede.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return retornar;
    }

    void setParcial(Parcial p) {
        if (this.parciales == null) {
            this.parciales = new ArrayList<>();
        }
        this.parciales.add(p);
    }

    boolean parcialesMarcados() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date año;
            año = dateFormat.parse("01/01/" + String.valueOf(Calendar.YEAR));
            if (this.parciales != null) {
                for (Parcial p : this.parciales) {
                    if (año.before(p.getFecha())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(CursoSede.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
