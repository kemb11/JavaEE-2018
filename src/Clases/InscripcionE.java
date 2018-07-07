/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "inscripcione")
public class InscripcionE implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Estudiante estudiante;
    @ManyToOne
    private Examen examen;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @OneToOne
    private ResultadoE nota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public Date getFecha() {
        return fecha;
    }

    public ResultadoE getNota() {
        return nota;
    }

    public void setNota(ResultadoE nota) {
        this.nota = nota;  
        Fabrica.getInstance().getEntity().persist(nota);
        Fabrica.getInstance().getEntity().merge(this);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscripcionE)) {
            return false;
        }
        InscripcionE other = (InscripcionE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (nota != null) {
            String retornar = "Estudiante : " + this.estudiante.getNombres() + " " + this.estudiante.getApellidos() + " (" + this.estudiante.getCi() + ")";
            retornar = retornar.concat("\nNota : " + String.valueOf((int) this.nota.getNota()));
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            retornar = retornar.concat("\nFecha de corrección : " + date.format(nota.getFecha()));
            String aprobado = "Sí";
            if (nota.getNota() < this.getExamen().getNotaApro()) {
                aprobado = "No";
            }
            retornar = retornar.concat("\nAprobado : " + aprobado);
            return retornar;
        } else {
            return "No se ha corregido";
        }
    }

}
