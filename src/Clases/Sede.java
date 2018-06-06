/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="sede")
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    @ManyToMany
    private List<Estudiante> estudiantes;
    @ManyToMany
    private List<Carrera> carreras;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CursoSede> cursoSedes;

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
    
    public void setCarrera(Carrera carrera){
        this.carreras.add(carrera);
    }

    public List<CursoSede> getCursoSedes() {
        return cursoSedes;
    }

    public void setCursoSedes(List<CursoSede> cursoSedes) {
        this.cursoSedes = cursoSedes;
    }
    
    public void setCursoSede(CursoSede cursoSedes) {
        this.cursoSedes.add(cursoSedes);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sede() {
    }

    public Sede(Long id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
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
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String texto = "Nombre: "+ this.nombre;
        texto += "\nDirección: "+ this.direccion;
        texto += "\nTeléfono: " + this.telefono;
        return texto;
    }
    
    public void setEstudiante(Estudiante e){
        this.estudiantes.add(e);
    }
    //retorna un cursosede a partir del curso
    public CursoSede getCurso(Curso c){
        if(this.cursoSedes!=null){
            for(CursoSede cs : cursoSedes){
                if(cs.getCurso().equals(c))
                    return cs;
            }
        }
        return null;
    }
    
}
