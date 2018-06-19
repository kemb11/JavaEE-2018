/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Clases.Admin;
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
 * @author Usuario
 */
public class AdminJpaController implements Serializable {

    public AdminJpaController() {
    }
    
    public EntityManager getEntityManager() {
        return Fabrica.getInstance().getEntity();
    }

    public void create(Admin admin) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAdmin(admin.getId()) != null) {
                throw new PreexistingEntityException("Admin " + admin + " already exists.", ex);
            }
            throw ex;
        } finally {
            
        }
    }

    public void edit(Admin admin) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            admin = em.merge(admin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = admin.getId();
                if (findAdmin(id) == null) {
                    throw new NonexistentEntityException("The admin with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Admin admin;
            try {
                admin = em.getReference(Admin.class, id);
                admin.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The admin with id " + id + " no longer exists.", enfe);
            }
            em.remove(admin);
            em.getTransaction().commit();
        } finally {
            
        }
    }

    public List<Admin> findAdminEntities() {
        return findAdminEntities(true, -1, -1);
    }

    public List<Admin> findAdminEntities(int maxResults, int firstResult) {
        return findAdminEntities(false, maxResults, firstResult);
    }

    private List<Admin> findAdminEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Admin.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            
        }
    }

    public Admin findAdmin(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Admin.class, id);
        } finally {
            
        }
    }

    public int getAdminCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Admin> rt = cq.from(Admin.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            
        }
    }
    public boolean verificarUser(String user){
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("SELECT * FROM admin where id = '"+ user +"' or email = '"+ user +"';", Admin.class);
            if(q.getResultList().size() > 0)
                return true;
            else
                return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean login(String user, String pass){
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNativeQuery("SELECT * FROM admin where (id = '"+ user +"' or email = '"+ user +"') and pass = '"+pass+"';", Admin.class);
            if(q.getResultList().size() > 0)
                return true;
            else
                return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public Admin getAdmin(String id) {
        EntityManager em = Fabrica.getInstance().getEntity();
        List<Admin> admins = this.findAdminEntities();
        for(Admin a : admins){
            if(a.getId().equals(id) || a.getEmail().equals(id))
                return a;
        }
        return null;
    }
    
}
