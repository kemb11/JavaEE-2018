/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.persistence.Entity;

@Entity
public class Estudiante extends Usuario {

    public Estudiante(String id, String pass, String email) {
        super(id, pass, email);
    }
    
}
