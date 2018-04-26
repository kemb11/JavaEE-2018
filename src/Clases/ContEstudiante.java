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
    public void inscripcionCurso(Curso curso) throws Exception{
        Fabrica.getInstance().getEntity().getTransaction().begin();
        try {
//            if(this.login.estaInscrpto(this.sede)){
//                
//            }
            
            Sede sede = Fabrica.getInstance().getContEdu().getSede();
            CursoSede cs = (CursoSede) Fabrica.getInstance().getEntity().createNativeQuery("SELECT * FROM cursosede WHERE curso_id = '"+curso.getId()+"'"+" AND sede_id = '"+sede.getId()+"'", CursoSede.class).getSingleResult();
            this.login.setIncripcion(cs);
            Fabrica.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Fabrica.getInstance().getEntity().getTransaction().rollback();
        }
    }

    @Override
    public List<Object[]> sedesEstudiante() {
        List<Object[]> retornar = new ArrayList<>();
        if(this.login.getSedes()!= null){
        Iterator<Sede> it = this.login.getSedes().iterator();
        while (it.hasNext()) {
            Sede next = it.next();
            Object[] o = {next.getId(), next.getNombre()};
            retornar.add(o);
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
