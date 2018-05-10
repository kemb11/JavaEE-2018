
package Clases;

import java.util.List;

public interface IContEstudiante {
    public abstract Estudiante getLogin();
    public abstract boolean login(String id, String pass) throws Exception;
    public abstract boolean inscripcionCurso(Curso c) throws Exception;
    public abstract List<Sede> sedesEstudiante();
    public abstract void seleccionarSede(Long id);
    public abstract void cerrarSesion();
}
