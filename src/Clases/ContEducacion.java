
package Clases;

import Persistencia.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ContEducacion implements IContEducacion{
    private static ContEducacion instancia;
    private Carrera carrera;
    private Sede sede;
    private ContEducacion(){
    }
    
    public static ContEducacion getInstance(){
        if(instancia == null){
            instancia = new ContEducacion();
        }
        return instancia;
    }

    @Override
    public void seleccionCarrera(long id) {
        CarreraJpaController cjpa = new CarreraJpaController();
        this.carrera = cjpa.findCarrera(id);
    }

    @Override
    public void seleccionSede(long id) {
        SedeJpaController sjpa = new SedeJpaController();
        this.sede = sjpa.findSede(id);
    }

    @Override
    public boolean cursoApto(long carrera, long sede, long id) throws Exception {
        CursoSedeJpaController csjpa = new CursoSedeJpaController();
        CursoSede curso = csjpa.findCursoSedeEntities(id, sede);
        if(curso != null && curso.getCurso().getCarrera().getId() == carrera)
            return true;
        else{
            if(curso == null)
                throw new Exception("El curso no pertenece a la sede seleccionada");
            else
                throw new Exception("El curso no pertenece a la carrera seleccionada");
        }
    }

    @Override
    public void cerrarSesionEstudiante() {
        carrera = null;
        sede = null;
    }
    
    public List<Curso> listarCursos(String buscar){
        List<Curso> lista = new ArrayList<>();
        EntityManager em = Fabrica.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT * FROM Curso WHERE nombre LIKE '%"+buscar+"%' OR descripcion LIKE '%"+buscar+"%'", Curso.class);
            lista = q.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Sede getSede() {
        return sede;
    }

    @Override
    public List<Sede> listarSedes() {
        SedeJpaController sjpa = new SedeJpaController();
        return sjpa.findSedeEntities();
    }
    
}
