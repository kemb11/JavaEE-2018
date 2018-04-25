
package Clases;

public interface IContEstudiante {
    public abstract boolean login(String id, String pass);
    public abstract void inscripcionCurso(Curso c) throws Exception;
}
