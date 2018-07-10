/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IContDocente {
    public abstract boolean subirMaterial(String titulo, String descripcion, String rutaArchivo, Curso curso);    
    public abstract boolean dictaCurso(Curso curso);
    public abstract void login(Docente docente);
    public abstract Docente getLogin();
    public abstract boolean isEditableExamen(Examen e);
    public abstract boolean isEditableParcial(Parcial p);
    public abstract void subirNotasExamen(Examen e);
    public abstract void subirNotasParcial(Parcial p);
    public abstract void asociarACurso(Curso curso, Docente docente) throws Exception;
    public abstract void notificacionVista(Notificacion notif);
    public abstract void configEnviarMails(boolean opocion);
    
    public abstract Docente getDocenteByCedula(String ci);
    public abstract void confirmarCambios(Docente d);
}
