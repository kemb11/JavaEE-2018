/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;

public interface IContEducacion {
    public abstract void seleccionCarrera(long id);
    public abstract void seleccionSede(long id);
    public abstract boolean cursoApto(long sede, long curso, long carrera) throws Exception;
    public abstract void cerrarSesionEstudiante();
    public abstract List<Curso> listarCursos(String buscar);
    public abstract Sede getSede();
}
