/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("P")
public class Parcial extends Prueba {
    String instancia;
    @ManyToOne
    private CursoSede curso;
    @OneToMany
    private List<ResultadoP> notasEstudiantes;

    public String getInstancia() {
        return instancia;
    }

    public CursoSede getCurso() {
        return curso;
    }

    public List<ResultadoP> getNotasEstudiantes() {
        return notasEstudiantes;
    }

    public void setNotasEstudiantes(List<ResultadoP> notasEstudiantes) {
        this.notasEstudiantes = notasEstudiantes;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public void setCurso(CursoSede curso) {
        this.curso = curso;
    }
    
    public ResultadoP getNotaEstudiante(Estudiante est){
        for (ResultadoP notaEstudiante : this.notasEstudiantes) {
            if(notaEstudiante.getEstudiante().equals(est)){
                return notaEstudiante;
            }
        }
        
        return null;
    }

    public void setNota(ResultadoP resultadoP) {
        this.notasEstudiantes.add(resultadoP);
    }
    
    public boolean editable() {
        if(this.notasEstudiantes != null) {
                return false;
        }
        return true;
    }
    
    
}
