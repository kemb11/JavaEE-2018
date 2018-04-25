/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Estudiante extends Usuario {

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;
    private String ci, nombres, apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNac;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Sede> sedes;
//    @ManyToMany
//    private List<Carrera> carreras;

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

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void setIncripcion(CursoSede cs) throws Exception {
        if (buscarInscripcion(cs)) {
            throw new Exception("Ya está inscripto al curso");
        } else {
            Inscripcion ins = new Inscripcion();
            ins.setCurso(cs);
            cs.setInscripcion(ins);
            ins.setFecha(new Date());
            ins.setEstudiante(this);
            this.inscripciones.add(ins);
        }
    }

    private boolean buscarInscripcion(CursoSede cs) {
        Iterator<Inscripcion> it = this.inscripciones.iterator();
        while (it.hasNext()) {
            Inscripcion next = it.next();
            if (next.getCurso().equals(cs)) {
                return true;
            }
        }
        return false;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }
}
