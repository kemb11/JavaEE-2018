/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Docente;
import Clases.Estudiante;
import Clases.Fabrica;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
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
 * @author root
 */
public class DocenteJpaController implements Serializable {

    public void create(Docente docente) throws PreexistingEntityException, Exception {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            em.getTransaction().begin();
            em.persist(docente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocente(docente.getId()) != null) {
                throw new PreexistingEntityException("Docente " + docente + " already exists.", ex);
            }
            throw ex;
        } finally {
        }
    }

    public void edit(Docente docente) throws NonexistentEntityException, Exception {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            em.getTransaction().begin();
            docente = em.merge(docente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = docente.getId();
                if (findDocente(id) == null) {
                    throw new NonexistentEntityException("The docente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            em.getTransaction().begin();
            Docente docente;
            try {
                docente = em.getReference(Docente.class, id);
                docente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The docente with id " + id + " no longer exists.", enfe);
            }
            em.remove(docente);
            em.getTransaction().commit();
        } finally {
        }
    }

    public List<Docente> findDocenteEntities() {
        return findDocenteEntities(true, -1, -1);
    }

    public List<Docente> findDocenteEntities(int maxResults, int firstResult) {
        return findDocenteEntities(false, maxResults, firstResult);
    }

    private List<Docente> findDocenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Docente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
           
        }
    }

    public Docente findDocente(String id) {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            return em.find(Docente.class, id);
        } finally {
           
        }
    }

    public int getDocenteCount() {
        EntityManager em = Fabrica.getInstance().getEntity();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Docente> rt = cq.from(Docente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
           
        }
    }
    
    public boolean id(String id){
        for(Docente d : this.findDocenteEntities()){
            if(d.getId().equals(id))
                return true;
        } 
        return false;
    }
    
    public boolean email(String email){
        for(Docente d : this.findDocenteEntities()){
            if(d.getEmail().equals(email))
                return true;
        } 
        return false;
    }
    
}
