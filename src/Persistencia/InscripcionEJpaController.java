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
import Clases.Examen;
import Clases.Fabrica;
import Clases.InscripcionE;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class InscripcionEJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(InscripcionE inscripcionE) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estudiante = inscripcionE.getEstudiante();
            if (estudiante != null) {
                estudiante = em.getReference(estudiante.getClass(), estudiante.getId());
                inscripcionE.setEstudiante(estudiante);
            }
            Examen examen = inscripcionE.getExamen();
            if (examen != null) {
                examen = em.getReference(examen.getClass(), examen.getId());
                inscripcionE.setExamen(examen);
            }
            em.persist(inscripcionE);
            if (estudiante != null) {
                estudiante.getExamenes().add(inscripcionE);
                estudiante = em.merge(estudiante);
            }
            if (examen != null) {
                examen.getEstudiantesInscritos().add(inscripcionE);
                examen = em.merge(examen);
            }
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(InscripcionE inscripcionE) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            InscripcionE persistentInscripcionE = em.find(InscripcionE.class, inscripcionE.getId());
            Estudiante estudianteOld = persistentInscripcionE.getEstudiante();
            Estudiante estudianteNew = inscripcionE.getEstudiante();
            Examen examenOld = persistentInscripcionE.getExamen();
            Examen examenNew = inscripcionE.getExamen();
            if (estudianteNew != null) {
                estudianteNew = em.getReference(estudianteNew.getClass(), estudianteNew.getId());
                inscripcionE.setEstudiante(estudianteNew);
            }
            if (examenNew != null) {
                examenNew = em.getReference(examenNew.getClass(), examenNew.getId());
                inscripcionE.setExamen(examenNew);
            }
            inscripcionE = em.merge(inscripcionE);
            if (estudianteOld != null && !estudianteOld.equals(estudianteNew)) {
                estudianteOld.getExamenes().remove(inscripcionE);
                estudianteOld = em.merge(estudianteOld);
            }
            if (estudianteNew != null && !estudianteNew.equals(estudianteOld)) {
                estudianteNew.getExamenes().add(inscripcionE);
                estudianteNew = em.merge(estudianteNew);
            }
            if (examenOld != null && !examenOld.equals(examenNew)) {
                examenOld.getEstudiantesInscritos().remove(inscripcionE);
                examenOld = em.merge(examenOld);
            }
            if (examenNew != null && !examenNew.equals(examenOld)) {
                examenNew.getEstudiantesInscritos().add(inscripcionE);
                examenNew = em.merge(examenNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = inscripcionE.getId();
                if (findInscripcionE(id) == null) {
                    throw new NonexistentEntityException("The inscripcionE with id " + id + " no longer exists.");
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
            InscripcionE inscripcionE;
            try {
                inscripcionE = em.getReference(InscripcionE.class, id);
                inscripcionE.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripcionE with id " + id + " no longer exists.", enfe);
            }
            Estudiante estudiante = inscripcionE.getEstudiante();
            if (estudiante != null) {
                estudiante.getExamenes().remove(inscripcionE);
                estudiante = em.merge(estudiante);
            }
            Examen examen = inscripcionE.getExamen();
            if (examen != null) {
                examen.getEstudiantesInscritos().remove(inscripcionE);
                examen = em.merge(examen);
            }
            em.remove(inscripcionE);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<InscripcionE> findInscripcionEEntities() {
        return findInscripcionEEntities(true, -1, -1);
    }

    public List<InscripcionE> findInscripcionEEntities(int maxResults, int firstResult) {
        return findInscripcionEEntities(false, maxResults, firstResult);
    }

    private List<InscripcionE> findInscripcionEEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InscripcionE.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public InscripcionE findInscripcionE(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InscripcionE.class, id);
        } finally {
        }
    }

    public int getInscripcionECount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InscripcionE> rt = cq.from(InscripcionE.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
