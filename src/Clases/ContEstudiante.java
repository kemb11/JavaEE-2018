
package Clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

    private List<Estudiante> getEstudiantes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaEE2018PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Estudiante> retornar = null;
        try {
            Query q = em.createNativeQuery("SELECT * FROM Estudiante", Estudiante.class);
            retornar = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return retornar;
        }
    }

    public boolean login(String id, String pass) {
        Iterator<Estudiante> it = this.getEstudiantes().iterator();
        while (it.hasNext()) {
            Estudiante next = it.next();
            if(next.getPass().equals(pass) && next.getId().equals(id)){
                login = next;
                return true;}
        }
        return false;
    }

    @Override
    public void inscripcion(CursoSede cs) throws Exception{
        this.login.setIncripcion(cs);
    }
    
    
    
}
