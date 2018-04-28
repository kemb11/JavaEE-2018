package Clases;

import Persistencia.EstudianteJpaController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Persistence;

public class ContEstudiante implements IContEstudiante {

    private static ContEstudiante instancia;
    private Estudiante login;

    private ContEstudiante() {
    }

    public static ContEstudiante getInstance() {
        if (instancia == null) {
            instancia = new ContEstudiante();
        }
        return instancia;
    }

    public boolean login(String id, String pass) throws Exception {
        EstudianteJpaController ejpa = new EstudianteJpaController();
        Estudiante e = ejpa.findEstudiante(id);
        if (e != null && e.getPass().equals(pass)) {
            this.login = e;
            return true;
        } else {
            if (e != null) {
                throw new Exception("Contraseña incorrecta");
            } else {
                throw new Exception("Usuario y contraseña incorrecta");
            }
        }
    }

   
    @Override
    public boolean inscripcionCurso(Curso curso) throws Exception{
        Fabrica.getInstance().getEntity().getTransaction().begin();
        try {
            if(this.login.estaInscriptoEnSede(Fabrica.getInstance().getContEdu().getSede())){
                 Sede sede = Fabrica.getInstance().getContEdu().getSede();
                CursoSede cs = (CursoSede) Fabrica.getInstance().getEntity().createNativeQuery("SELECT * FROM cursosede WHERE curso_id = '"+curso.getId()+"'"+" AND sede_id = '"+sede.getId()+"'", CursoSede.class).getSingleResult();
                if(this.login.setIncripcion(cs) == false){
                    throw new Exception("Ya está inscripto a este curso");
                }                
                Fabrica.getInstance().getEntity().getTransaction().commit();
                return true;
            }else{
                throw new Exception("Debe estar inscripto en la sede en la cual se dicta el curso");
            }
        } catch (Exception e) {
            Fabrica.getInstance().getEntity().getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Sede> sedesEstudiante() {
        List<Sede> retornar = new ArrayList<>();
        if(this.login.getSedes()!= null){
        Iterator<Sede> it = this.login.getSedes().iterator();
        while (it.hasNext()) {
            Sede next = it.next();
            retornar.add(next);
        }}
        return retornar;
    }

    @Override
    public void seleccionarSede(Long id) {
        Fabrica.getInstance().getContEdu().seleccionSede(id);
    }

    @Override
    public void cerrarSesion() {
        this.login = null;
    }

    
}
