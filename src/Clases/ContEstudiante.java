
package Clases;

import Persistencia.EstudianteJpaController;
import java.util.Iterator;
import javax.persistence.Persistence;

public class ContEstudiante implements IContEstudiante{
    private static ContEstudiante instancia;
    private Estudiante login;
    private ContEstudiante(){
    }
    
    public static ContEstudiante getInstance(){
        if(instancia == null){
            instancia = new ContEstudiante();
        }
        return instancia;
    }

    public boolean login(String id, String pass) throws Exception {
        EstudianteJpaController ejpa = new EstudianteJpaController(Persistence.createEntityManagerFactory("JavaEE2018PU"));
        Estudiante e = ejpa.findEstudiante(id);
        if(e != null && e.getPass().equals(pass)){
            this.login = e;
                return true;
        }
        else{
            if(e != null){
                throw new Exception("Contraseña incorrecta");
            }else{
                throw new Exception("Usuario y contraseña incorrecta");
            }
        }
    }

   
    @Override
    public void inscripcionCurso(Curso curso) throws Exception{
        Fabrica.getInstance().getEntity().getTransaction().begin();
        try {
            System.out.println("Curso.getId() -> "+curso.getId());
            CursoSede cs = (CursoSede) Fabrica.getInstance().getEntity().createNativeQuery("SELECT * FROM cursosede WHERE curso_id = '"+curso.getId()+"'", CursoSede.class).getSingleResult();
            System.out.println("CursoSede.getId() -> "+cs.getId());
            this.login.setIncripcion(cs);
            Fabrica.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Fabrica.getInstance().getEntity().getTransaction().rollback();
        }
    }
    
}
