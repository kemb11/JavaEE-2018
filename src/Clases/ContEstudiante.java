
package Clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ContEstudiante implements IContEstudiante{
    private static ContEstudiante instancia;
    private List<Estudiante> estudiantes;
    private ContEstudiante(){
        estudiantes = this.getEstudiantes();
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
        Iterator<Estudiante> it = estudiantes.iterator();
        while (it.hasNext()) {
            Estudiante next = it.next();
            if(next.getPass().equals(pass) && next.getId().equals(id))
                return true;
        }
        return false;
    }
    
    
    
}
