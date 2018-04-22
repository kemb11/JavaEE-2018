/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Fabrica {
    private static Fabrica instancia;
    private EntityManagerFactory emf;
    private Fabrica(){
        this.emf = Persistence.createEntityManagerFactory("JavaEE2018PU");
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

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
    
}
