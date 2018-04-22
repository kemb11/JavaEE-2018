
package Clases;

public interface IContEstudiante {
    public abstract boolean login(String id, String pass);
    public abstract void inscripcion(CursoSede cs) throws Exception;
}
