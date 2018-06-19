/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="curso")
public class Curso implements Serializable {

    @ManyToOne
    private Carrera carrera;

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @Column(columnDefinition = "text")
    private String descripcion;
    private int creditos, semestre;
    @Column(columnDefinition = "text")
    private String horarios;
    private boolean optativo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CursoSede> cursoSedes;
    @ManyToMany
    private List<Estudiante> estudiantesAprobados;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Previa> previas;
    private int notaExonerarEx;
    private int notaAprobacion;

    public Long getId() {
        return id;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public void setOptativo(boolean optativo) {
        this.optativo = optativo;
    }

    public void setCursoSedes(List<CursoSede> cursoSedes) {
        this.cursoSedes = cursoSedes;
    }

    public void setEstudiantesAprobados(List<Estudiante> estudiantesAprobados) {
        this.estudiantesAprobados = estudiantesAprobados;
    }

        public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCreditos() {
        return creditos;
    }

    public String getHorarios() {
        return horarios;
    }

    public List<Estudiante> getEstudiantesAprobados() {
        return estudiantesAprobados;
    }

    public boolean isOptativo() {
        return optativo;
    }

    public List<CursoSede> getCursoSedes() {
        return cursoSedes;
    }
    
    public void setPrevias(List<Previa> previas) {
        this.previas = previas;
    }

    public List<Previa> getPrevias() {
        return previas;
    }
    
    public int getNotaExonerarEx() {
        return notaExonerarEx;
    }

    public int getNotaAprobacion() {
        return notaAprobacion;
    }

    public void setNotaExonerarEx(int notaExonerarEx) {
        this.notaExonerarEx = notaExonerarEx;
    }

    public void setNotaAprobacion(int notaAprobacion) {
        this.notaAprobacion = notaAprobacion;
    }
    
    public boolean estaEnSede(Sede sede){
        for (CursoSede cursoSede : cursoSedes) {
            if(cursoSede.getSede().equals(sede)){
                return true;
            }
        }
        return false;
    }
    
    public boolean tieneComoPrevia(Curso curso){
        for (Previa previa : this.previas) {
            if(previa.getCursoPrevia().equals(curso)){
                return true;
            }else{
                if(previa.getCursoPrevia().tieneComoPrevia(curso)){
                    return true;
                }
            }
        }
        
        return false;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Curso[ id=" + id + " ]";
    }

    public boolean periodo() {
        if(this.semestre % 2 ==0){
            return this.carrera.segundoperiodo();
        }else{
            return this.carrera.primerperiodo();
        }
    }
    
}
