
package Clases;

import Persistencia.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ContEducacion implements IContEducacion{
    private static ContEducacion instancia;
    private Carrera carrera;
    private Sede sede;
    private ContEducacion(){
    }
    
    public static ContEducacion getInstance(){
        if(instancia == null){
            instancia = new ContEducacion();
        }
        return instancia;
    }

    @Override
    public void seleccionCarrera(long id) {
        CarreraJpaController cjpa = new CarreraJpaController();
        this.carrera = cjpa.findCarrera(id);
    }

    @Override
    public void seleccionSede(long id) {
        SedeJpaController sjpa = new SedeJpaController();
        this.sede = sjpa.findSede(id);
    }

    @Override
    public boolean cursoApto(long carrera, long sede, long id) throws Exception {
        CursoSedeJpaController csjpa = new CursoSedeJpaController();
        CursoSede curso = csjpa.findCursoSedeEntities(id, sede);
        if(curso != null && curso.getCurso().getCarrera().getId() == carrera)
            return true;
        else{
            if(curso == null)
                throw new Exception("El curso no pertenece a la sede seleccionada");
            else
                throw new Exception("El curso no pertenece a la carrera seleccionada");
        }
    }

    @Override
    public void cerrarSesionEstudiante() {
        carrera = null;
        sede = null;
    }
    
    public List<Curso> listarCursos(String buscar){
        List<Curso> cursosRetornar = new ArrayList<>();
        /*EntityManager em = Fabrica.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            Query q = em.createNativeQuery("SELECT curso.id, curso.creditos, curso.descripcion, curso.horarios, curso.nombre,"
                    + " curso.optativo, curso.carrera_id FROM curso INNER JOIN cursosede ON curso.id = cursosede.curso_id"
                    + " AND cursosede.sede_id="+this.sede.getId()+" AND nombre LIKE '%"+buscar+"%'", Curso.class);
            List<Curso> lista = q.getResultList();
            cursosRetornar=lista;
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }*/
        
        for (CursoSede cursoSede : this.sede.getCursoSedes()) {
            String nombreC = cursoSede.getCurso().getNombre().toLowerCase();
            buscar = buscar.toLowerCase();
            if(nombreC.contains(buscar)){
                cursosRetornar.add(cursoSede.getCurso());
            }
        }
        
        return cursosRetornar;
    }
    
    @Override
    public List<Curso> listarCursosAprobados(String buscar){
        List<Curso> cursosRetornar = new ArrayList<>();
        Estudiante e = Fabrica.getInstance().getContEst().getLogin(); 
        for (Curso c : e.getCursosAprobados()) {
            if(c.estaEnSede(this.sede)){
                String nombreC = c.getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreC.contains(buscar)){
                    cursosRetornar.add(c);
                }
            }
        }
        return cursosRetornar;
    }

    @Override
    public Sede getSede() {
        return sede;
    }

    @Override
    public List<Sede> listarSedes() {
        SedeJpaController sjpa = new SedeJpaController();
        return sjpa.findSedeEntities();
    }
    
    public List<Sede> listarSedes(String palabra) {
        SedeJpaController sjpa = new SedeJpaController();
        return sjpa.findSede(palabra);
    }
    
    public List<Carrera> listarCarrerasSede(){
        CarreraJpaController cjpa = new CarreraJpaController();
        return cjpa.findCarreraSede(sede.getId());
    }
    
    public List<Carrera> listarCarrerasSede(String palabra){
        CarreraJpaController cjpa = new CarreraJpaController();
        return cjpa.findCarreraSede(sede.getId(), palabra);
    }
    
    @Override
    public List<Curso> listarCursosCursando(String buscar){
        List<Curso> cursosRetornar = new ArrayList<>();
        
        Estudiante e = Fabrica.getInstance().getContEst().getLogin();   
        for (InscripcionC inscripcion : e.getInscripciones()) {
            Curso c = inscripcion.getCurso().getCurso();
            if(c.estaEnSede(this.sede)){
                String nombreC = c.getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreC.contains(buscar)){
                    cursosRetornar.add(c);
                }
            }
        }
        
        return cursosRetornar;
    }
    
    @Override
    public List<Examen> listarExamenes(String buscar){
        List<Examen> examenesRetornar = new ArrayList<>();
        CursoSedeJpaController jpa = new CursoSedeJpaController();
        for (CursoSede cursoS : jpa.findCursoSedeEntities()) {
            if(cursoS.getSede().equals(this.sede)){
                for (Examen e : cursoS.getExmenes()) {
                    String nombreC = e.getCurso().getCurso().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if(nombreC.contains(buscar)){
                        examenesRetornar.add(e);
                    }

                }
            }
        }
        
        return examenesRetornar;
    }
    
    public List<Examen> listaExamenesEst(String buscar){
        List<Examen> examenesRetornar = new ArrayList<>();
        
        Estudiante e = Fabrica.getInstance().getContEst().getLogin();   
        for (InscripcionE insEx:  e.getExamenes()) {
            Sede sedeEx = insEx.getExamen().getCurso().getSede();
            if(sedeEx.equals(this.sede)){
                String nombreC = insEx.getExamen().getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreC.contains(buscar)){
                    examenesRetornar.add(insEx.getExamen());
                }
            }
        }
        
        return examenesRetornar;
    }
    
//    public List<Examen> listarExamenes(String buscar){
//        List<Examen> examenesRetornar = new ArrayList<>();
//        EstudianteJpaController jpa = new EstudianteJpaController();
//        for (Estudiante findEstudianteEntity : jpa.findEstudianteEntities()) {
//            Estudiante est = Fabrica.getInstance().getContEst().getLogin();   
//            for (InscripcionE examen : est.getExamenes()) {
//                Examen e = examen.getExamen();
//                if(e.getCurso().getSede().equals(this.sede)){
//                    String nombreC = e.getCurso().getCurso().getNombre().toLowerCase();
//                    buscar = buscar.toLowerCase();
//                    if(nombreC.contains(buscar)){
//                        examenesRetornar.add(e);
//                    }
//                }
//            }
//        }
//        
//        return examenesRetornar;
//    }
}
