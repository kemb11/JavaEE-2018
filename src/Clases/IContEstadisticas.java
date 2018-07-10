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
public interface IContEstadisticas {
    //Cursos
    public abstract double promedioParcialesCurso(boolean enTodasSedes, Curso curso);
    public abstract double promedioExamenesCurso(boolean enTodasSedes, Curso curso);
    public abstract double promedioAprobacionCurso(boolean enTodasSedes, Curso curso);
    
    //Carreras
    public abstract double promedioParcialesCarrera(boolean enTodasSedes, Carrera carrera);
    public abstract double promedioExamenesCarrera(boolean enTodasSedes, Carrera carrera);
    public abstract double promedioAprobacionCarrera(boolean enTodasSedes, Carrera carrera);
    public abstract Object[] cursoConMasEstudiantesCursandoCarrera(boolean enTodasSedes, Carrera carrera);
    public abstract Object[] cursoConMasAprobacionesCarrera(boolean enTodasSedes, Carrera carrera);
    public abstract Object[] cursoConMejorPrmedioAprobacionCarrera(boolean enTodasSedes, Carrera carrera);
    
    //Sedes
    public abstract double promedioParcialesSede(boolean enTodasSedes);
    public abstract double promedioExamenesSede(boolean enTodasSedes);
    public abstract double promedioAprobacionSede(boolean enTodasSedes);
    public abstract Object[] cursoConMasEstudiantesCursandoSede(boolean enTodasSedes);
    public abstract Object[] cursoConMasAprobacionesCarreraSede(boolean enTodasSedes);
    public abstract Object[] cursoConMejorPrmedioAprobacionCarreraSede(boolean enTodasSedes);
    public abstract Object[] carreraConMasEstudiantesCursandoSede(boolean enTodasSedes);
    public abstract Object[] carreraConMasAprobacionesSede(boolean enTodasSedes);
    public abstract Object[] carreraConMejorPrmedioAprobacionSede(boolean enTodasSedes);
    
}
