/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Fabrica;
import Clases.ResultadoE;
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
public class ResultadoEJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(ResultadoE resultadoE) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(resultadoE);
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(ResultadoE resultadoE) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            resultadoE = em.merge(resultadoE);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = resultadoE.getId();
                if (findResultadoE(id) == null) {
                    throw new NonexistentEntityException("The resultadoE with id " + id + " no longer exists.");
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
            ResultadoE resultadoE;
            try {
                resultadoE = em.getReference(ResultadoE.class, id);
                resultadoE.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resultadoE with id " + id + " no longer exists.", enfe);
            }
            em.remove(resultadoE);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<ResultadoE> findResultadoEEntities() {
        return findResultadoEEntities(true, -1, -1);
    }

    public List<ResultadoE> findResultadoEEntities(int maxResults, int firstResult) {
        return findResultadoEEntities(false, maxResults, firstResult);
    }

    private List<ResultadoE> findResultadoEEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResultadoE.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public ResultadoE findResultadoE(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResultadoE.class, id);
        } finally {
        }
    }

    public int getResultadoECount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResultadoE> rt = cq.from(ResultadoE.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
