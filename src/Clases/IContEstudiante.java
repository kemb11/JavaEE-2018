
package Clases;

import java.util.HashMap;
import java.util.List;

public interface IContEstudiante {
 
    public abstract HashMap<String,String> getInfoEstudiante(String ci);
    public abstract void confirmarMod(String ci, String nombre, String apellido, String email, String fechaNac);
    public abstract Estudiante getEstudiante(String ci);
    public abstract void inhabilitarEstudiante(String ci);
    public abstract Estudiante getLogin();
    public abstract void login(String id);
    public abstract boolean inscripcionCurso(Curso c) throws Exception;
    public abstract List<Sede> sedesEstudiante();
    public abstract void seleccionarSede(Long id);
    public abstract void cerrarSesion();
    public abstract boolean inscripcionExamen(Examen examen) throws Exception;
    public abstract InscripcionE getInscripcionExamen(Examen examen);
    public abstract List<Estudiante> getEstudiantes();
    public abstract List<Estudiante> getEstudiantes(String palabra);
    public abstract void notificacionVista(Notificacion notif);
    public abstract void configEnviarMails(boolean opocion);
}
