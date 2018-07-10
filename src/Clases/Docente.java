/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="docente")
public class Docente extends Usuario {
    private String ci, nombres, apellidos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date FechaNac;
    @ManyToMany
    private List<CursoSede> clases;
    private boolean enviarMails, habilitado = true;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    
    
    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date FechaNac) {
        this.FechaNac = FechaNac;
    }

    public List<CursoSede> getClases() {
        return clases;
    }

    public void setClases(List<CursoSede> clases) {
        this.clases = clases;
    }

    public void setClase(CursoSede clase) {
        this.clases.add(clase);
    }
    
    public void quitarClase(CursoSede clase) {
        this.clases.remove(clase);
    }

    public boolean isEnviarMails() {
        return enviarMails;
    }

    public void setEnviarMails(boolean enviarMails) {
        this.enviarMails = enviarMails;
    }
    
    public int cantNotifNoVista() {
        int cant = 0;
        for (Notificacion notif : notificaciones) {
            if (notif.isVista() == false) {
                cant += 1;
            }
        }
        return cant;
    }
}
