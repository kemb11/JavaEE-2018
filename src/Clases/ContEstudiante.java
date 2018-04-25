
package Clases;

import Persistencia.EstudianteJpaController;
import java.util.Iterator;

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
        EstudianteJpaController ejpa = new EstudianteJpaController(Fabrica.getInstance().getEmf());
        Estudiante e = ejpa.findEstudiante(id);
        if(e != null && e.getPass().equals(pass)){
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
    public void inscripcion(CursoSede cs) throws Exception{
        this.login.setIncripcion(cs);
    }
    
    
    
}
