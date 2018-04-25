/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Estudiante;
import Clases.Fabrica;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Clases.Inscripcion;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController() {
    }
    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(Estudiante estudiante) throws PreexistingEntityException, Exception {
        if (estudiante.getInscripciones() == null) {
            estudiante.setInscripciones(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Inscripcion> attachedInscripciones = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesInscripcionToAttach : estudiante.getInscripciones()) {
                inscripcionesInscripcionToAttach = em.getReference(inscripcionesInscripcionToAttach.getClass(), inscripcionesInscripcionToAttach.getId());
                attachedInscripciones.add(inscripcionesInscripcionToAttach);
            }
            estudiante.setInscripciones(attachedInscripciones);
            em.persist(estudiante);
            for (Inscripcion inscripcionesInscripcion : estudiante.getInscripciones()) {
                Estudiante oldEstudianteOfInscripcionesInscripcion = inscripcionesInscripcion.getEstudiante();
                inscripcionesInscripcion.setEstudiante(estudiante);
                inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
                if (oldEstudianteOfInscripcionesInscripcion != null) {
                    oldEstudianteOfInscripcionesInscripcion.getInscripciones().remove(inscripcionesInscripcion);
                    oldEstudianteOfInscripcionesInscripcion = em.merge(oldEstudianteOfInscripcionesInscripcion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEstudiante(estudiante.getId()) != null) {
                throw new PreexistingEntityException("Estudiante " + estudiante + " already exists.", ex);
            }
            throw ex;
        } 
    }

    public void edit(Estudiante estudiante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getId());
            List<Inscripcion> inscripcionesOld = persistentEstudiante.getInscripciones();
            List<Inscripcion> inscripcionesNew = estudiante.getInscripciones();
            List<Inscripcion> attachedInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion inscripcionesNewInscripcionToAttach : inscripcionesNew) {
                inscripcionesNewInscripcionToAttach = em.getReference(inscripcionesNewInscripcionToAttach.getClass(), inscripcionesNewInscripcionToAttach.getId());
                attachedInscripcionesNew.add(inscripcionesNewInscripcionToAttach);
            }
            inscripcionesNew = attachedInscripcionesNew;
            estudiante.setInscripciones(inscripcionesNew);
            estudiante = em.merge(estudiante);
            for (Inscripcion inscripcionesOldInscripcion : inscripcionesOld) {
                if (!inscripcionesNew.contains(inscripcionesOldInscripcion)) {
                    inscripcionesOldInscripcion.setEstudiante(null);
                    inscripcionesOldInscripcion = em.merge(inscripcionesOldInscripcion);
                }
            }
            for (Inscripcion inscripcionesNewInscripcion : inscripcionesNew) {
                if (!inscripcionesOld.contains(inscripcionesNewInscripcion)) {
                    Estudiante oldEstudianteOfInscripcionesNewInscripcion = inscripcionesNewInscripcion.getEstudiante();
                    inscripcionesNewInscripcion.setEstudiante(estudiante);
                    inscripcionesNewInscripcion = em.merge(inscripcionesNewInscripcion);
                    if (oldEstudianteOfInscripcionesNewInscripcion != null && !oldEstudianteOfInscripcionesNewInscripcion.equals(estudiante)) {
                        oldEstudianteOfInscripcionesNewInscripcion.getInscripciones().remove(inscripcionesNewInscripcion);
                        oldEstudianteOfInscripcionesNewInscripcion = em.merge(oldEstudianteOfInscripcionesNewInscripcion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = estudiante.getId();
                if (findEstudiante(id) == null) {
                    throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            List<Inscripcion> inscripciones = estudiante.getInscripciones();
            for (Inscripcion inscripcionesInscripcion : inscripciones) {
                inscripcionesInscripcion.setEstudiante(null);
                inscripcionesInscripcion = em.merge(inscripcionesInscripcion);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
           
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Estudiante findEstudiante(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
        }
    }

    public int getEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }
    
}
