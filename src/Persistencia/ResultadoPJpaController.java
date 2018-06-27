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
import Clases.Parcial;
import Clases.Estudiante;
import Clases.Fabrica;
import Clases.ResultadoP;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rodri
 */
public class ResultadoPJpaController implements Serializable {

    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(ResultadoP resultadoP) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Parcial parcial = resultadoP.getParcial();
            if (parcial != null) {
                parcial = em.getReference(parcial.getClass(), parcial.getId());
                resultadoP.setParcial(parcial);
            }
            Estudiante estudiante = resultadoP.getEstudiante();
            if (estudiante != null) {
                estudiante = em.getReference(estudiante.getClass(), estudiante.getId());
                resultadoP.setEstudiante(estudiante);
            }
            em.persist(resultadoP);
            if (parcial != null) {
                parcial.getNotasEstudiantes().add(resultadoP);
                parcial = em.merge(parcial);
            }
            if (estudiante != null) {
                estudiante.getNotasParciales().add(resultadoP);
                estudiante = em.merge(estudiante);
            }
            em.getTransaction().commit();
        } finally {
        }
    }

    public void edit(ResultadoP resultadoP) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ResultadoP persistentResultadoP = em.find(ResultadoP.class, resultadoP.getId());
            Parcial parcialOld = persistentResultadoP.getParcial();
            Parcial parcialNew = resultadoP.getParcial();
            Estudiante estudianteOld = persistentResultadoP.getEstudiante();
            Estudiante estudianteNew = resultadoP.getEstudiante();
            if (parcialNew != null) {
                parcialNew = em.getReference(parcialNew.getClass(), parcialNew.getId());
                resultadoP.setParcial(parcialNew);
            }
            if (estudianteNew != null) {
                estudianteNew = em.getReference(estudianteNew.getClass(), estudianteNew.getId());
                resultadoP.setEstudiante(estudianteNew);
            }
            resultadoP = em.merge(resultadoP);
            if (parcialOld != null && !parcialOld.equals(parcialNew)) {
                parcialOld.getNotasEstudiantes().remove(resultadoP);
                parcialOld = em.merge(parcialOld);
            }
            if (parcialNew != null && !parcialNew.equals(parcialOld)) {
                parcialNew.getNotasEstudiantes().add(resultadoP);
                parcialNew = em.merge(parcialNew);
            }
            if (estudianteOld != null && !estudianteOld.equals(estudianteNew)) {
                estudianteOld.getNotasParciales().remove(resultadoP);
                estudianteOld = em.merge(estudianteOld);
            }
            if (estudianteNew != null && !estudianteNew.equals(estudianteOld)) {
                estudianteNew.getNotasParciales().add(resultadoP);
                estudianteNew = em.merge(estudianteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = resultadoP.getId();
                if (findResultadoP(id) == null) {
                    throw new NonexistentEntityException("The resultadoP with id " + id + " no longer exists.");
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
            ResultadoP resultadoP;
            try {
                resultadoP = em.getReference(ResultadoP.class, id);
                resultadoP.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The resultadoP with id " + id + " no longer exists.", enfe);
            }
            Parcial parcial = resultadoP.getParcial();
            if (parcial != null) {
                parcial.getNotasEstudiantes().remove(resultadoP);
                parcial = em.merge(parcial);
            }
            Estudiante estudiante = resultadoP.getEstudiante();
            if (estudiante != null) {
                estudiante.getNotasParciales().remove(resultadoP);
                estudiante = em.merge(estudiante);
            }
            em.remove(resultadoP);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<ResultadoP> findResultadoPEntities() {
        return findResultadoPEntities(true, -1, -1);
    }

    public List<ResultadoP> findResultadoPEntities(int maxResults, int firstResult) {
        return findResultadoPEntities(false, maxResults, firstResult);
    }

    private List<ResultadoP> findResultadoPEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResultadoP.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
        }
    }

    public ResultadoP findResultadoP(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResultadoP.class, id);
        } finally {
        }
    }

    public int getResultadoPCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResultadoP> rt = cq.from(ResultadoP.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
        }
    }
    
}
