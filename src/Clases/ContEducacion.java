
package Clases;

import Persistencia.ParcialJpaController;
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
        if(this.sede.getCursoSedes() != null)
        for (CursoSede cursoSede : this.sede.getCursoSedes()) {
            String nombreCurso = cursoSede.getCurso().getNombre().toLowerCase();
            String nombreCarrera = cursoSede.getCurso().getCarrera().getNombre().toLowerCase();
            buscar = buscar.toLowerCase();
            if(nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)){
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
                String nombreCurso = c.getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                String nombreCarrera = c.getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)){
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
    
    @Override
    public List<Carrera> listarCarrerasSede(){
        CarreraJpaController cjpa = new CarreraJpaController();
        return cjpa.findCarreraSede(sede.getId());
    }
    
    @Override
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
                String nombreCurso = c.getNombre().toLowerCase();
                String nombreCarrera = c.getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)){
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
                    String nombreC = cursoS.getCurso().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if(nombreC.contains(buscar)){
                        examenesRetornar.add(e);
                    }
                }
            }
        }        
        return examenesRetornar;
    }
    
    @Override
    public List<Examen> listarExamenesEst(String buscar){
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
    
    @Override
    public List<Parcial> listarParciales(String buscar){
        List<Parcial> parcialesRetornar = new ArrayList<>();
        /*CursoSedeJpaController jpa = new CursoSedeJpaController();
        for (CursoSede cursoS : jpa.findCursoSedeEntities()) {
            if(cursoS.getSede().equals(this.sede)){
                for (Parcial p : cursoS.getParciales()) {
                    String nombreC = cursoS.getCurso().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if(nombreC.contains(buscar)){
                        parcialesRetornar.add(p);
                    }
                }
            }
        }        */
        
        ParcialJpaController jpaP = new ParcialJpaController();
        for (Parcial parcial : jpaP.findParcialEntities()) {
            if(parcial.getCurso().getSede().equals(this.sede)){
                String nombreC = parcial.getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreC.contains(buscar)){
                    parcialesRetornar.add(parcial);
                }
            }
        }
        
        return parcialesRetornar;
    }
    
    @Override
    public List<Parcial> listarParcialesEst(String buscar){
        List<Parcial> parcialesRetornar = new ArrayList<>();
        
        Estudiante e = Fabrica.getInstance().getContEst().getLogin();   
        for (ResultadoP rp:  e.getNotasParciales()) {
            Parcial parcial = rp.getParcial();
            Sede sedeP = parcial.getCurso().getSede();
            if(sedeP.equals(this.sede)){
                String nombreC = parcial.getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if(nombreC.contains(buscar)){
                    parcialesRetornar.add(parcial);
                }
            }
        }
        
        return parcialesRetornar;
    }
    
    @Override
    public void nuevoCurso(String nombre, int creditos, int semestre, String descripcion, String horario, boolean optativo, Carrera carrera) throws Exception{
        for (Curso cursoCarrera : carrera.getCursos()) {
            if(cursoCarrera.getNombre().toLowerCase().equals(nombre.toLowerCase())){
                throw new Exception("Ya existe un curso llamado '"+nombre+"' en la carrera '"+carrera.getNombre()+"'");
            }
        }
        
        EntityManager em = Fabrica.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            Curso curso = new Curso();
            curso.setNombre(nombre);curso.setCreditos(creditos);
            curso.setSemestre(semestre);
            curso.setDescripcion(descripcion);
            curso.setHorarios(horario);
            curso.setCarrera(carrera);
            curso.setOptativo(optativo);
            
            CursoSede cs = new CursoSede();
            cs.setCurso(curso);
            cs.setSede(this.sede);
            this.sede.setCursoSede(cs);    
            carrera.setCurso(curso);
            List<CursoSede> cursosedes = new ArrayList<>();
            cursosedes.add(cs);
            curso.setCursoSedes(cursosedes);
            
            em.persist(cs);
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
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

    @Override
    public Sede getSede(String Nombre) {
        SedeJpaController sjpa = new SedeJpaController();
        List<Sede> sedes = sjpa.findSedeEntities();
        for(Sede s : sedes)
            if(s.getNombre().equals(Nombre))
                return s;
        return null;
    }
}
