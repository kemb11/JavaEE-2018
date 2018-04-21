/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Curso;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Clases.CursoSede;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) {
        if (curso.getCursoSedes() == null) {
            curso.setCursoSedes(new ArrayList<CursoSede>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<CursoSede> attachedCursoSedes = new ArrayList<CursoSede>();
            for (CursoSede cursoSedesCursoSedeToAttach : curso.getCursoSedes()) {
                cursoSedesCursoSedeToAttach = em.getReference(cursoSedesCursoSedeToAttach.getClass(), cursoSedesCursoSedeToAttach.getId());
                attachedCursoSedes.add(cursoSedesCursoSedeToAttach);
            }
            curso.setCursoSedes(attachedCursoSedes);
            em.persist(curso);
            for (CursoSede cursoSedesCursoSede : curso.getCursoSedes()) {
                Curso oldCursoOfCursoSedesCursoSede = cursoSedesCursoSede.getCurso();
                cursoSedesCursoSede.setCurso(curso);
                cursoSedesCursoSede = em.merge(cursoSedesCursoSede);
                if (oldCursoOfCursoSedesCursoSede != null) {
                    oldCursoOfCursoSedesCursoSede.getCursoSedes().remove(cursoSedesCursoSede);
                    oldCursoOfCursoSedesCursoSede = em.merge(oldCursoOfCursoSedesCursoSede);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getId());
            List<CursoSede> cursoSedesOld = persistentCurso.getCursoSedes();
            List<CursoSede> cursoSedesNew = curso.getCursoSedes();
            List<CursoSede> attachedCursoSedesNew = new ArrayList<CursoSede>();
            for (CursoSede cursoSedesNewCursoSedeToAttach : cursoSedesNew) {
                cursoSedesNewCursoSedeToAttach = em.getReference(cursoSedesNewCursoSedeToAttach.getClass(), cursoSedesNewCursoSedeToAttach.getId());
                attachedCursoSedesNew.add(cursoSedesNewCursoSedeToAttach);
            }
            cursoSedesNew = attachedCursoSedesNew;
            curso.setCursoSedes(cursoSedesNew);
            curso = em.merge(curso);
            for (CursoSede cursoSedesOldCursoSede : cursoSedesOld) {
                if (!cursoSedesNew.contains(cursoSedesOldCursoSede)) {
                    cursoSedesOldCursoSede.setCurso(null);
                    cursoSedesOldCursoSede = em.merge(cursoSedesOldCursoSede);
                }
            }
            for (CursoSede cursoSedesNewCursoSede : cursoSedesNew) {
                if (!cursoSedesOld.contains(cursoSedesNewCursoSede)) {
                    Curso oldCursoOfCursoSedesNewCursoSede = cursoSedesNewCursoSede.getCurso();
                    cursoSedesNewCursoSede.setCurso(curso);
                    cursoSedesNewCursoSede = em.merge(cursoSedesNewCursoSede);
                    if (oldCursoOfCursoSedesNewCursoSede != null && !oldCursoOfCursoSedesNewCursoSede.equals(curso)) {
                        oldCursoOfCursoSedesNewCursoSede.getCursoSedes().remove(cursoSedesNewCursoSede);
                        oldCursoOfCursoSedesNewCursoSede = em.merge(oldCursoOfCursoSedesNewCursoSede);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = curso.getId();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<CursoSede> cursoSedes = curso.getCursoSedes();
            for (CursoSede cursoSedesCursoSede : cursoSedes) {
                cursoSedesCursoSede.setCurso(null);
                cursoSedesCursoSede = em.merge(cursoSedesCursoSede);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Curso findCurso(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
