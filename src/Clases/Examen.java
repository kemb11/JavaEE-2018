/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Examen extends Prueba {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicioInsripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date finInsripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMuestra;
    @ManyToOne(fetch=FetchType.EAGER)
    private CursoSede curso;

    public Date getInicioInsripcion() {
        return inicioInsripcion;
    }

    public Date getFinInsripcion() {
        return finInsripcion;
    }

    public Date getFechaMuestra() {
        return fechaMuestra;
    }

    public void setInicioInsripcion(Date inicioInsripcion) {
        this.inicioInsripcion = inicioInsripcion;
    }

    public void setFinInsripcion(Date finInsripcion) {
        this.finInsripcion = finInsripcion;
    }

    public void setFechaMuestra(Date fechaMuestra) {
        this.fechaMuestra = fechaMuestra;
    }

    public CursoSede getCurso() {
        return curso;
    }

    public void setCurso(CursoSede curso) {
        this.curso = curso;
    }
    
}
