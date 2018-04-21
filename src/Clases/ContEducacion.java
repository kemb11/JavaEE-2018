/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author rodri
 */
public class ContEducacion implements IContEducacion{
    private static ContEducacion instancia;
    private ContEducacion(){
    }
    
    public static ContEducacion getInstance(){
        if(instancia == null){
            instancia = new ContEducacion();
        }
        return instancia;
    }
    
}
