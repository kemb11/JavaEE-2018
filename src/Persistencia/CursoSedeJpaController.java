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
import Clases.CursoSede;
import Clases.Inscripcion;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class CursoSedeJpaController implements Serializable {

    public CursoSedeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CursoSede cursoSede) {
        if (cursoSede.getInscripciones() == null) {
            cursoSede.setInscripciones(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso = cursoSede.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                cursoSede.setCurso(curso);
            }
            List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesInscripcionToAttach : cursoSede.getInscripciones()) {
                inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getId());
                attachedInscripciones.add(inscripcionesInscripcionToAttach);
            }
            cursoSede.setInscripciones(attachedInscripciones);
            em.persist(cursoSede);
            if (curso != null) {
                curso.getCursoSedes().add(cursoSede);
                curso = em.merge(curso);
            }
            for (Inscripcion inscripcionesInscripcion : cursoSede.getInscripciones()) {
                CursoSede oldCursoOfInscripcionesInscripcion = inscripcionesInscripcion.getCurso();
                inscripcionesInscripcion.setCurso(cursoSede);
                inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
                if (oldCursoOfInscripcionesInscripcion != null) {
                    oldCursoOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                    oldCursoOfInscripcionesInscripcion = em.merge(oldCursoOfInscripcionesInscripcion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CursoSede cursoSede) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CursoSede persistentCursoSede = em.find(CursoSede.class, cursoSede.getId());
            Curso cursoOld = persistentCursoSede.getCurso();
            Curso cursoNew = cursoSede.getCurso();
            List<Inscripcion> inscripcionesOld = persistentCursoSede.getInscripciones();
            List<Inscripcion> inscripcionesNew = cursoSede.getInscripciones();
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                cursoSede.setCurso(cursoNew);
            }
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getId());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            cursoSede.setInscripciones(inscripcionesNew);
            cursoSede = em.merge(cursoSede);
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getCursoSedes().remove(cursoSede);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getCursoSedes().add(cursoSede);
                cursoNew = em.merge(cursoNew);
            }
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setCurso(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    CursoSede oldCursoOfInscripcionesNewInscripcion = inscripcionesNewInscripcion.getCurso();
                    inscripcionesNewInscripcion.setCurso(cursoSede);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldCursoOfInscripcionesNewInscripcion != null && !oldCursoOfInscripcionesNewInscripcion.equals(cursoSede)) {
                        oldCursoOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldCursoOfInscripcionesNewInscripcion = em.merge(oldCursoOfInscripcionesNewInscripcion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cursoSede.getId();
                if (findCursoSede(id) == null) {
                    throw new NonexistentEntityException("The cursoSede with id " + id + " no longer exists.");
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
            CursoSede cursoSede;
            try {
                cursoSede = em.getReference(CursoSede.class, id);
                cursoSede.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cursoSede with id " + id + " no longer exists.", enfe);
            }
            Curso curso = cursoSede.getCurso();
            if (curso != null) {
                curso.getCursoSedes().remove(cursoSede);
                curso = em.merge(curso);
            }
            List<Inscripcion> inscripciones = cursoSede.getInscripciones();
            for (Inscripcion inscripcionesInscripcion : inscripciones) {
                inscripcionesInscripcion.setCurso(null);
                inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            }
            em.remove(cursoSede);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CursoSede> findCursoSedeEntities() {
        return findCursoSedeEntities(true, -1, -1);
    }

    public List<CursoSede> findCursoSedeEntities(int maxResults, int firstResult) {
        return findCursoSedeEntities(false, maxResults, firstResult);
    }

    private List<CursoSede> findCursoSedeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CursoSede.class));
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

    public CursoSede findCursoSede(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CursoSede.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoSedeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CursoSede> rt = cq.from(CursoSede.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public CursoSede findCursoSedeEntities(long idcurso, long idsede) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("select * from cursosede where sede_id = " + String.valueOf(idsede) + " and curso_id", CursoSede.class);
            return (CursoSede) q.getResultList().get(0);
        } finally {
            em.close();
        }
    }
    
}
