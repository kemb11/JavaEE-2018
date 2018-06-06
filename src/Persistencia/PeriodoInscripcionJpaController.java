/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Fabrica;
import Clases.PeriodoInscripcion;
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
 * @author root
 */
public class PeriodoInscripcionJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(PeriodoInscripcion periodoInscripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(periodoInscripcion);
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(PeriodoInscripcion periodoInscripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            periodoInscripcion = em.merge(periodoInscripcion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = periodoInscripcion.getId();
                if (findPeriodoInscripcion(id) == null) {
                    throw new NonexistentEntityException("The periodoInscripcion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PeriodoInscripcion periodoInscripcion;
            try {
                periodoInscripcion = em.getReference(PeriodoInscripcion.class, id);
                periodoInscripcion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The periodoInscripcion with id " + id + " no longer exists.", enfe);
            }
            em.remove(periodoInscripcion);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<PeriodoInscripcion> findPeriodoInscripcionEntities() {
        return findPeriodoInscripcionEntities(true, -1, -1);
    }

    public List<PeriodoInscripcion> findPeriodoInscripcionEntities(int maxResults, int firstResult) {
        return findPeriodoInscripcionEntities(false, maxResults, firstResult);
    }

    private List<PeriodoInscripcion> findPeriodoInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PeriodoInscripcion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public PeriodoInscripcion findPeriodoInscripcion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PeriodoInscripcion.class, id);
        } finally {
        }
    }

    public int getPeriodoInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PeriodoInscripcion> rt = cq.from(PeriodoInscripcion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
