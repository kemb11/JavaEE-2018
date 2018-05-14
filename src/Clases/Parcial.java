/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("P")
public class Parcial extends Prueba {
    String instancia;
    @ManyToOne
    private CursoSede curso;

    public String getInstancia() {
        return instancia;
    }

    public CursoSede getCurso() {
        return curso;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public void setCurso(CursoSede curso) {
        this.curso = curso;
    }
}
