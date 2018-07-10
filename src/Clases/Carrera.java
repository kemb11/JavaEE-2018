/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name="carrera")
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private int creditos;
    @ManyToMany
    private List<Sede> sedes;
    @OneToMany(mappedBy = "carrera")
    private List<Curso> cursos;
    @OneToOne(cascade = CascadeType.ALL)
    private PeriodoInscripcion primerSemestre;
    @OneToOne(cascade = CascadeType.ALL)
    private PeriodoInscripcion segundoSemestre;
    @OneToMany(mappedBy = "carrera")
    private List<CarreraEstudiante> carreraEstudiantes;

    public Long getId() {
        return id;
    }

    public PeriodoInscripcion getPrimerSemestre() {
        return primerSemestre;
    }

    public void setPrimerSemestre(PeriodoInscripcion primerSemestre) {
        this.primerSemestre = primerSemestre;
    }

    public PeriodoInscripcion getSegundoSemestre() {
        return segundoSemestre;
    }

    public void setSegundoSemestre(PeriodoInscripcion segundoSemestre) {
        this.segundoSemestre = segundoSemestre;
    }

    public List<CarreraEstudiante> getCarreraEstudiantes() {
        return carreraEstudiantes;
    }

    public void setCarreraEstudiantes(List<CarreraEstudiante> carreraEstudiantes) {
        this.carreraEstudiantes = carreraEstudiantes;
    }
    
    public List<Estudiante> getEstudiantes(){
        List<Estudiante> list = new ArrayList<>();
        for(CarreraEstudiante e : carreraEstudiantes)
            list.add(e.getEstudiante());
        return list;
    }

    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void setCurso(Curso cursos) {
        this.cursos.add(cursos);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carrera() {
    }

    public Carrera(Long id, String nombre, String descripcion, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCreditos() {
        return creditos;
    }
    
    public int cantidadAprobados(boolean todasSedes){
        int aprobados = 0;
        for (CarreraEstudiante carreraEst : this.carreraEstudiantes) {
            if(carreraEst.isAprobada()){
                carreraEst.getCarrera().getCursos();
                Sede sede = Fabrica.getInstance().getContEdu().getSede();
                CursoSede cs = carreraEst.getEstudiante().ultimoCursoAprobado(this);
                if(todasSedes || (cs != null && cs.getSede().equals(sede))){
                    aprobados += 1;
                }
            }
        }
        
        return aprobados;
    }
    
    public int cantidadInscriptos(){
        int inscripciones = 0;
        for (CarreraEstudiante carreraEst : this.carreraEstudiantes) {
            if(carreraEst.isHabilitado()){
                inscripciones += 1;
            }
        }
        
        return inscripciones;
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
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String texto = "Carrera: "+ this.nombre;
        texto += "\nDescripcion: "+ this.descripcion;
        texto += "\nCreditos: "+String.valueOf(creditos);
        return texto;
    }
    
    public boolean primerperiodo(){
        Date dia = new Date();
        if(dia.after(this.primerSemestre.getInicio()) && dia.before(this.primerSemestre.getFin()))
            return true;
        return false;
    }
    
    public boolean segundoperiodo(){
        Date dia = new Date();
        if(dia.after(this.segundoSemestre.getInicio()) && dia.before(this.segundoSemestre.getFin()))
            return true;
        return false;
    }
    
    public void setEstudiante(CarreraEstudiante ce){
        this.carreraEstudiantes.add(ce);
    }
    
}
