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
import Clases.Estudiante;
import Clases.CursoSede;
import Clases.Fabrica;
import Clases.InscripcionC;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class InscripcionJpaController implements Serializable {

    public InscripcionJpaController() {
    }
    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(InscripcionC inscripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estudiante = inscripcion.getEstudiante();
            if (estudiante != null) {
                estudiante = em.getReference(estudiante.getClass(), estudiante.getId());
                inscripcion.setEstudiante(estudiante);
            }
            CursoSede curso = inscripcion.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                inscripcion.setCurso(curso);
            }
            em.persist(inscripcion);
            if (estudiante != null) {
                estudiante.getInscripciones().add(inscripcion);
                estudiante = em.merge(estudiante);
            }
            if (curso != null) {
                curso.getInscripciones().add(inscripcion);
                curso = em.merge(curso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public void edit(InscripcionC inscripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InscripcionC persistentInscripcion = em.find(InscripcionC.class, inscripcion.getId());
            Estudiante estudianteOld = persistentInscripcion.getEstudiante();
            Estudiante estudianteNew = inscripcion.getEstudiante();
            CursoSede cursoOld = persistentInscripcion.getCurso();
            CursoSede cursoNew = inscripcion.getCurso();
            if (estudianteNew != null) {
                estudianteNew = em.getReference(estudianteNew.getClass(), estudianteNew.getId());
                inscripcion.setEstudiante(estudianteNew);
            }
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                inscripcion.setCurso(cursoNew);
            }
            inscripcion = em.merge(inscripcion);
            if (estudianteOld != null && !estudianteOld.equals(estudianteNew)) {
                estudianteOld.getInscripciones().remove(inscripcion);
                estudianteOld = em.merge(estudianteOld);
            }
            if (estudianteNew != null && !estudianteNew.equals(estudianteOld)) {
                estudianteNew.getInscripciones().add(inscripcion);
                estudianteNew = em.merge(estudianteNew);
            }
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getInscripciones().remove(inscripcion);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getInscripciones().add(inscripcion);
                cursoNew = em.merge(cursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = inscripcion.getId();
                if (findInscripcion(id) == null) {
                    throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.");
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
            InscripcionC inscripcion;
            try {
                inscripcion = em.getReference(InscripcionC.class, id);
                inscripcion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.", enfe);
            }
            Estudiante estudiante = inscripcion.getEstudiante();
            if (estudiante != null) {
                estudiante.getInscripciones().remove(inscripcion);
                estudiante = em.merge(estudiante);
            }
            CursoSede curso = inscripcion.getCurso();
            if (curso != null) {
                curso.getInscripciones().remove(inscripcion);
                curso = em.merge(curso);
            }
            em.remove(inscripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
            }
        }
    }

    public List<InscripcionC> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    public List<InscripcionC> findInscripcionEntities(int maxResults, int firstResult) {
        return findInscripcionEntities(false, maxResults, firstResult);
    }

    private List<InscripcionC> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InscripcionC.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public InscripcionC findInscripcion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InscripcionC.class, id);
        } finally {
            em.close();
        }
    }

    public int getInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InscripcionC> rt = cq.from(InscripcionC.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
