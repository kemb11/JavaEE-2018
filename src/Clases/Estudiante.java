/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

@Entity
public class Estudiante extends Usuario {
    private String ci, nombres, apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNac;
//    @ManyToMany
//    private List<Sede> sedes;
//    @ManyToMany
//    private List<Carrera> carreras;
    @ManyToMany
    private List<Curso> cursos;

    public Estudiante(String id, String pass, String email) {
        super(id, pass, email);
    }

    public Estudiante(String ci, String nombres, String apellidos, Date FechaNac, List<Curso> cursos, String id, String pass, String email) {
        super(id, pass, email);
        this.ci = ci;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.FechaNac = FechaNac;
        this.cursos = cursos;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getCi() {
        return ci;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
    
    
}
