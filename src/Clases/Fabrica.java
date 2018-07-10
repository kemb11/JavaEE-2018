/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Fabrica {
    private static Fabrica instancia;
    private EntityManager em;
    private Fabrica(){
        this.em = Persistence.createEntityManagerFactory("JavaEE2018PU").createEntityManager();
    }
    public static Fabrica getInstance(){
        if(instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }
    public IContEstudiante getContEst(){
        return ContEstudiante.getInstance();
    }
    public IContEducacion getContEdu(){
        return ContEducacion.getInstance();
    }
    public IContAdmin getContAdmin(){
        return ContAdmin.getInstance();
    }
    public IContDocente getContDocente(){
        return ContDocente.getInstance();
    }
    public IContEstadisticas getContEstad(){
        return ContEstadisticas.getInstance();
    }

    public EntityManager getEntity() {
        return em;
    }    
    
}
