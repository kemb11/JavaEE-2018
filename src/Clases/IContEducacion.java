/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import java.util.List;

public interface IContEducacion {
    public abstract void seleccionCarrera(long id);
    public abstract void seleccionSede(long id);
    public abstract boolean cursoApto(long sede, long curso, long carrera) throws Exception;
    public abstract void cerrarSesionEstudiante();
    public abstract List<Curso> listarCursos(String buscar);
    public abstract List<Noticia> listarNoticias(String buscar);
    public abstract List<Noticia> listarNoticias();
    public abstract List<Curso> listarCursosAprobados(String buscar);
    public abstract List<Curso> listarCursosCursando(String buscar);
    public abstract Sede getSede();
    public abstract Sede getSede(String Nombre);
    public abstract List<Sede> listarSedes();
    public abstract List<Carrera> listarCarrerasSede();
    public abstract List<Sede> listarSedes(String palabra);
    public abstract List<Carrera> listarCarrerasSede(String palabra);    
    public abstract List<Examen> listarExamenes(String buscar);
    public abstract List<Examen> listarExamenesEst(String buscar);
    public abstract List<Parcial> listarParciales(String buscar);
    public abstract List<Parcial> listarParcialesEst(String buscar);
    public abstract void nuevoCurso(String nombre, int creditos, int semestre, String descripcion, String horario, boolean optativo, Carrera carrera, int notaExonEx, int notaAprobacion) throws Exception;
    public abstract boolean esPrevia(Curso curso);
    public abstract List<Curso> selecSonPrevia(Curso curso);
    public abstract void eliminarPreviaSelec(Curso curso);
    public abstract void limpiarPreviasSelec();
    public abstract boolean selecSedeCarr(Sede sede);
    public abstract void eliminarSedeSelec(Sede sede);
    public abstract void limpiarSedesSelec();
    public abstract void nuevaCarrera(String nombre, int creditos, String descripcion, Date inicioPS, Date finPS, Date inicioSS, Date finSS) throws Exception;
    public abstract void borrarCursoNuevaCarrera(int index);
    public abstract List<Curso> listarCursosCrearCarrera();
    public abstract List<Curso> listarCursosDictando(String buscar);
    public abstract List<Examen> listarExamenesDoc(String buscar);
}
