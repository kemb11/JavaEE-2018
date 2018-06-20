
package Clases;

import java.util.HashMap;
import java.util.List;

public interface IContEstudiante {
    public abstract Estudiante getLogin();
    public abstract boolean login(String id, String pass) throws Exception;
    public abstract boolean inscripcionCurso(Curso c) throws Exception;
    public abstract List<Sede> sedesEstudiante();
    public abstract void seleccionarSede(Long id);
    public abstract void cerrarSesion();
    public abstract boolean inscripcionExamen(Examen examen) throws Exception;
    public abstract InscripcionE getInscripcionExamen(Examen examen);
    public abstract List<Estudiante> getEstudiantes();
    public abstract List<Estudiante> getEstudiantes(String palabra);
    public abstract HashMap<String,String> getInfoEstudiante(String ci);
    public abstract void confirmarMod(String ci, String nombre, String apellido, String email, String fechaNac);
}
