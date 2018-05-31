/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Usuario
 */
@Entity
public class Previa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean examenAprobado;
    @ManyToOne
    private Curso curso;
    @ManyToOne
    private Curso cursoPrevia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isExamenAprobado() {
        return examenAprobado;
    }

    public Curso getCurso() {
        return curso;
    }

    public Curso getCursoPrevia() {
        return cursoPrevia;
    }

    public void setExamenAprobado(boolean examenAprobado) {
        this.examenAprobado = examenAprobado;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setCursoPrevia(Curso cursoPrevia) {
        this.cursoPrevia = cursoPrevia;
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
        if (!(object instanceof Previa)) {
            return false;
        }
        Previa other = (Previa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Clases.Previa[ id=" + id + " ]";
    }
    
}
