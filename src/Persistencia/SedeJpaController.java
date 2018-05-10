/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Fabrica;
import Clases.Sede;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rodri
 */
public class SedeJpaController implements Serializable {

    public SedeJpaController() {
    }
    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(Sede sede) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sede);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public void edit(Sede sede) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sede = em.merge(sede);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = sede.getId();
                if (findSede(id) == null) {
                    throw new NonexistentEntityException("The sede with id " + id + " no longer exists.");
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
            Sede sede;
            try {
                sede = em.getReference(Sede.class, id);
                sede.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sede with id " + id + " no longer exists.", enfe);
            }
            em.remove(sede);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public List<Sede> findSedeEntities() {
        return findSedeEntities(true, -1, -1);
    }

    public List<Sede> findSedeEntities(int maxResults, int firstResult) {
        return findSedeEntities(false, maxResults, firstResult);
    }

    private List<Sede> findSedeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sede.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public Sede findSede(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sede.class, id);
        } finally {
        }
    }

    public int getSedeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sede> rt = cq.from(Sede.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
    public List<Sede> findSede(String palabra) {
        EntityManager em = getEntityManager();
        try {
            Query carreras = em.createNativeQuery("select * from sede where nombre like '%"+palabra+"%'",Sede.class);
            return carreras.getResultList();
        } finally {
        }
    }
    
}
