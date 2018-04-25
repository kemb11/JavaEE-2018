
package Clases;

import java.util.List;

public interface IContEstudiante {
    public abstract boolean login(String id, String pass) throws Exception;
    public abstract void inscripcion(CursoSede cs) throws Exception;
    public abstract List<Object[]> sedesEstudiante();
    public abstract void seleccionarSede(Long id);
    public abstract void cerrarSesion();
}
