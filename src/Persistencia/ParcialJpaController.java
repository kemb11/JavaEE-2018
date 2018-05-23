/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.CursoSede;
import Clases.Fabrica;
import Clases.Parcial;
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
 * @author Usuario
 */
public class ParcialJpaController implements Serializable {

    public ParcialJpaController() {
        this.emf = Fabrica.getInstance().getEntity().getEntityManagerFactory();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Parcial parcial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoSede curso = parcial.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                parcial.setCurso(curso);
            }
            em.persist(parcial);
            if (curso != null) {
                curso.getParciales().add(parcial);
                curso = em.merge(curso);
            }
            em.getTransaction().commit();
        } finally {
            
        }
    }

    public void edit(Parcial parcial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parcial persistentParcial = em.find(Parcial.class, parcial.getId());
            CursoSede cursoOld = persistentParcial.getCurso();
            CursoSede cursoNew = parcial.getCurso();
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                parcial.setCurso(cursoNew);
            }
            parcial = em.merge(parcial);
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getParciales().remove(parcial);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getParciales().add(parcial);
                cursoNew = em.merge(cursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = parcial.getId();
                if (findParcial(id) == null) {
                    throw new NonexistentEntityException("The parcial with id " + id + " no longer exists.");
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
            Parcial parcial;
            try {
                parcial = em.getReference(Parcial.class, id);
                parcial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The parcial with id " + id + " no longer exists.", enfe);
            }
            CursoSede curso = parcial.getCurso();
            if (curso != null) {
                curso.getParciales().remove(parcial);
                curso = em.merge(curso);
            }
            em.remove(parcial);
            em.getTransaction().commit();
        } finally {
            
        }
    }

    public List<Parcial> findParcialEntities() {
        return findParcialEntities(true, -1, -1);
    }

    public List<Parcial> findParcialEntities(int maxResults, int firstResult) {
        return findParcialEntities(false, maxResults, firstResult);
    }

    private List<Parcial> findParcialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Parcial.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Parcial findParcial(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Parcial.class, id);
        } finally {
            
        }
    }

    public int getParcialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Parcial> rt = cq.from(Parcial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }
    
}
