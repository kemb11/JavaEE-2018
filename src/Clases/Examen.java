/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import Persistencia.*;

@Entity
@DiscriminatorValue("E")
public class Examen extends Prueba {
    
    @OneToOne
    private PeriodoInscripcion inscripcion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaMuestra;
    @ManyToOne
    private CursoSede curso;
    @OneToMany
    List<InscripcionE> estudiantesInscritos;

    public Date getInicioInsripcion() {
        return inscripcion.getInicio();
    }

    public Date getFinInsripcion() {
        return inscripcion.getFin();
    }

    public Date getFechaMuestra() {
        return fechaMuestra;
    }

    public void setInicioInsripcion(Date inicioInsripcion) {
        if(inscripcion == null){
            inscripcion = new PeriodoInscripcion();
        }
        this.inscripcion.setInicio(inicioInsripcion);
    }

    public void setFinInsripcion(Date finInsripcion) {
        this.inscripcion.setFin(finInsripcion);
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

    public void setEstudiantesInscritos(List<InscripcionE> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    public List<InscripcionE> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }
    
    public boolean periodoOK(){
        Date dia = new Date();
        return this.inscripcion.valido(dia);
    }

    public PeriodoInscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(PeriodoInscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}
