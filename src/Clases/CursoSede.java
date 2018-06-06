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

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="cursosede")
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
    
    public void setInscripcion(InscripcionC ins){
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
    
    public void setExamen(Examen examen) {
        this.exmenes.add(examen);
        ExamenJpaController ejpa= new ExamenJpaController();
        ejpa.create(examen);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        notificarAlumnos("Nuevo examen", "Nuevo examen de "+curso.getNombre()+"\nFecha "+ dateFormat.format(examen.getFecha())+
                "\nReplicar\nSaludos, gracias");
    }
    
    public void notificarAlumnos(String titulo, String mensaje){
        for(InscripcionC i: inscripciones){
            if(!i.isAprobado(curso)){
                try {
                    SendEmail.EnviarMail(i.getEstudiante().getEmail(), titulo, mensaje);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(CursoSede.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
