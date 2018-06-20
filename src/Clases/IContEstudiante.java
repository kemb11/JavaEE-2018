
package Clases;

import java.util.List;

public interface IContEstudiante {
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
}
