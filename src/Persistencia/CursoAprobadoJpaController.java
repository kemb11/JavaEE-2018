/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Clases.Curso;
import Clases.CursoAprobado;
import Clases.Fabrica;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class CursoAprobadoJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(CursoAprobado cursoAprobado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso = cursoAprobado.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                cursoAprobado.setCurso(curso);
            }
            em.persist(cursoAprobado);
            if (curso != null) {
                curso.getEstudiantesAprobados().add(cursoAprobado);
                curso = em.merge(curso);
            }
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(CursoAprobado cursoAprobado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoAprobado persistentCursoAprobado = em.find(CursoAprobado.class, cursoAprobado.getId());
            Curso cursoOld = persistentCursoAprobado.getCurso();
            Curso cursoNew = cursoAprobado.getCurso();
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                cursoAprobado.setCurso(cursoNew);
            }
            cursoAprobado = em.merge(cursoAprobado);
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getEstudiantesAprobados().remove(cursoAprobado);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getEstudiantesAprobados().add(cursoAprobado);
                cursoNew = em.merge(cursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cursoAprobado.getId();
                if (findCursoAprobado(id) == null) {
                    throw new NonexistentEntityException("The cursoAprobado with id " + id + " no longer exists.");
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
            CursoAprobado cursoAprobado;
            try {
                cursoAprobado = em.getReference(CursoAprobado.class, id);
                cursoAprobado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cursoAprobado with id " + id + " no longer exists.", enfe);
            }
            Curso curso = cursoAprobado.getCurso();
            if (curso != null) {
                curso.getEstudiantesAprobados().remove(cursoAprobado);
                curso = em.merge(curso);
            }
            em.remove(cursoAprobado);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<CursoAprobado> findCursoAprobadoEntities() {
        return findCursoAprobadoEntities(true, -1, -1);
    }

    public List<CursoAprobado> findCursoAprobadoEntities(int maxResults, int firstResult) {
        return findCursoAprobadoEntities(false, maxResults, firstResult);
    }

    private List<CursoAprobado> findCursoAprobadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CursoAprobado.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public CursoAprobado findCursoAprobado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CursoAprobado.class, id);
        } finally {
        }
    }

    public int getCursoAprobadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CursoAprobado> rt = cq.from(CursoAprobado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
