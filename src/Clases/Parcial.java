/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Parcial extends Prueba {
    String periodo;
    @ManyToOne
    private CursoSede curso;

    public String getPeriodo() {
        return periodo;
    }

    public CursoSede getCurso() {
        return curso;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setCurso(CursoSede curso) {
        this.curso = curso;
    }
}
