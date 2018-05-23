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
import Clases.Carrera;
import Clases.CarreraEstudiante;
import Clases.Fabrica;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author root
 */
public class CarreraEstudianteJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(CarreraEstudiante carreraEstudiante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrera carrera = carreraEstudiante.getCarrera();
            if (carrera != null) {
                carrera = em.getReference(carrera.getClass(), carrera.getId());
                carreraEstudiante.setCarrera(carrera);
            }
            em.persist(carreraEstudiante);
            if (carrera != null) {
                carrera.getCarreraEstudiantes().add(carreraEstudiante);
                carrera = em.merge(carrera);
            }
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(CarreraEstudiante carreraEstudiante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CarreraEstudiante persistentCarreraEstudiante = em.find(CarreraEstudiante.class, carreraEstudiante.getId());
            Carrera carreraOld = persistentCarreraEstudiante.getCarrera();
            Carrera carreraNew = carreraEstudiante.getCarrera();
            if (carreraNew != null) {
                carreraNew = em.getReference(carreraNew.getClass(), carreraNew.getId());
                carreraEstudiante.setCarrera(carreraNew);
            }
            carreraEstudiante = em.merge(carreraEstudiante);
            if (carreraOld != null && !carreraOld.equals(carreraNew)) {
                carreraOld.getCarreraEstudiantes().remove(carreraEstudiante);
                carreraOld = em.merge(carreraOld);
            }
            if (carreraNew != null && !carreraNew.equals(carreraOld)) {
                carreraNew.getCarreraEstudiantes().add(carreraEstudiante);
                carreraNew = em.merge(carreraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = carreraEstudiante.getId();
                if (findCarreraEstudiante(id) == null) {
                    throw new NonexistentEntityException("The carreraEstudiante with id " + id + " no longer exists.");
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
            CarreraEstudiante carreraEstudiante;
            try {
                carreraEstudiante = em.getReference(CarreraEstudiante.class, id);
                carreraEstudiante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carreraEstudiante with id " + id + " no longer exists.", enfe);
            }
            Carrera carrera = carreraEstudiante.getCarrera();
            if (carrera != null) {
                carrera.getCarreraEstudiantes().remove(carreraEstudiante);
                carrera = em.merge(carrera);
            }
            em.remove(carreraEstudiante);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<CarreraEstudiante> findCarreraEstudianteEntities() {
        return findCarreraEstudianteEntities(true, -1, -1);
    }

    public List<CarreraEstudiante> findCarreraEstudianteEntities(int maxResults, int firstResult) {
        return findCarreraEstudianteEntities(false, maxResults, firstResult);
    }

    private List<CarreraEstudiante> findCarreraEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CarreraEstudiante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public CarreraEstudiante findCarreraEstudiante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CarreraEstudiante.class, id);
        } finally {
        }
    }

    public int getCarreraEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CarreraEstudiante> rt = cq.from(CarreraEstudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
