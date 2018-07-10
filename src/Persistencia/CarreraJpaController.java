/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Carrera;
import Clases.Fabrica;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rodri
 */
public class CarreraJpaController implements Serializable {

    public CarreraJpaController() {
    }
    
    public Carrera getCarreraByNombre(String nombreCarrera) {
        List<Carrera> lc = this.findCarreraEntities();
        for( Carrera l : lc) {
            if(l.getNombre().equals(nombreCarrera)) {
                return l;
            }
        }
        return new Carrera();
    }

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(Carrera carrera) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public void edit(Carrera carrera) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carrera = em.merge(carrera);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = carrera.getId();
                if (findCarrera(id) == null) {
                    throw new NonexistentEntityException("The carrera with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrera carrera;
            try {
                carrera = em.getReference(Carrera.class, id);
                carrera.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrera with id " + id + " no longer exists.", enfe);
            }
            em.remove(carrera);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public List<Carrera> findCarreraEntities() {
        return findCarreraEntities(true, -1, -1);
    }

    public List<Carrera> findCarreraEntities(int maxResults, int firstResult) {
        return findCarreraEntities(false, maxResults, firstResult);
    }

    private List<Carrera> findCarreraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrera.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public Carrera findCarrera(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrera.class, id);
        } finally {
            
        }
    }

    public int getCarreraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrera> rt = cq.from(Carrera.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }
    
    public List<Carrera> findCarreraSede(long id) {
        EntityManager em = getEntityManager();
        try {
            Query carreras = em.createNativeQuery("select * from carrera where id in (select carreras_id from sede_carrera where sede_id = "+String.valueOf(id)+")",Carrera.class);
            return carreras.getResultList();
        } finally {
        }
    }
    
    public List<Carrera> findCarreraSede(long id, String palabra) {
        EntityManager em = getEntityManager();
        try {
            Query carreras = em.createNativeQuery("select * from carrera where id in (select carreras_id from sede_carrera where sede_id = "+String.valueOf(id)+") and (nombre like '%"+palabra+"%' or descripcion like '%"+palabra+"%'",Carrera.class);
            return carreras.getResultList();
        } finally {
        }
    }
    
}
