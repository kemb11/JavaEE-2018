/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author rodri
 */
@Entity
@Table(name="inscripcionc")
public class InscripcionC implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private CursoSede curso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;

    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public CursoSede getCurso() {
        return curso;
    }

    public void setCurso(CursoSede curso) {
        this.curso = curso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        if (!(object instanceof InscripcionC)) {
            return false;
        }
        InscripcionC other = (InscripcionC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Inscripcion[ id=" + id + " ]";
    }
    
    public boolean isAprobado(Curso c){
        return estudiante.cursoAprobado(c);    
    }
    
    public boolean isHabilitado(){
        return this.estudiante.habilitadoCarrera(this.curso.getCurso().getCarrera());
    }    
    
}
