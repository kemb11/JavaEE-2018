/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class ContEstadisticas {

    private int promedioParcialesCurso(Sede sede, Curso curso){
        int promedio = 0;
        for (CursoSede cursoSede : curso.getCursoSedes()) {
            if(sede == null || sede.equals(cursoSede.getSede())){
                for (Parcial parcial : cursoSede.getParciales()) {
                    for (ResultadoP notaEst : parcial.getNotasEstudiantes()) {
                        if(promedio == 0){
                            promedio = notaEst.getNota();
                        }else{
                            promedio = (promedio + notaEst.getNota()) / 2;
                        }
                    }
                }
            }
        }
        
        return promedio;
    }
}
