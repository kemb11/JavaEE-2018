
package Clases;

import Persistencia.CarreraJpaController;
import Persistencia.SedeJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


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
        CarreraJpaController cjpa = new CarreraJpaController(Persistence.createEntityManagerFactory("JavaEE2018PU"));
        this.carrera = cjpa.findCarrera(id);
    }

    @Override
    public void seleccionSede(long id) {
        SedeJpaController sjpa = new SedeJpaController(Persistence.createEntityManagerFactory("JavaEE2018PU"));
        this.sede = sjpa.findSede(id);
    }
    
    public List<Curso> listarCursos(String buscar){
        List<Curso> lista = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2018PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            lista = em.createNativeQuery("SELECT * FROM curso WHERE nombre LIKE '%"+buscar+"%' OR descripcion LIKE '%"+buscar+"%'", Curso.class).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        
        return lista;
    }
    
}
