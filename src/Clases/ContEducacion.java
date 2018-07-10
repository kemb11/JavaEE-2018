package Clases;

import Persistencia.ParcialJpaController;
import Persistencia.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.io.FilenameUtils;

public class ContEducacion implements IContEducacion {

    private static ContEducacion instancia;
    private Carrera carrera;
    private Sede sede;
    private List<Curso> previasSelec = new ArrayList<>(); // se usa para el crear curso para controlar las previas
    private List<Sede> sedesSelec = new ArrayList<>(); // se usa para el crear curso para controlar las previas
    private List<Curso> cursosCrearCarr = new ArrayList<>(); // se usa para el crear carrera

    private ContEducacion() {
    }

    public static ContEducacion getInstance() {
        if (instancia == null) {
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
        if (curso != null && curso.getCurso().getCarrera().getId() == carrera) {
            return true;
        } else {
            if (curso == null) {
                throw new Exception("El curso no pertenece a la sede seleccionada");
            } else {
                throw new Exception("El curso no pertenece a la carrera seleccionada");
            }
        }
    }

    @Override
    public void cerrarSesionEstudiante() {
        carrera = null;
        sede = null;
    }

    public List<Curso> listarCursos(String buscar) {
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
        if (this.sede.getCursoSedes() != null) {
            for (CursoSede cursoSede : this.sede.getCursoSedes()) {
                String nombreCurso = cursoSede.getCurso().getNombre().toLowerCase();
                String nombreCarrera = cursoSede.getCurso().getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)) {
                    cursosRetornar.add(cursoSede.getCurso());
                }
            }
        }

        return cursosRetornar;
    }

    @Override
    public List<Curso> listarCursosAprobados(String buscar) {
        List<Curso> cursosRetornar = new ArrayList<>();
        Estudiante e = Fabrica.getInstance().getContEst().getLogin();
        for (Curso c : e.getListaCursosAprobados()) {
            if (c.estaEnSede(this.sede)) {
                String nombreCurso = c.getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                String nombreCarrera = c.getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)) {
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
    public List<Carrera> listarCarrerasSede() {
        CarreraJpaController cjpa = new CarreraJpaController();
        return cjpa.findCarreraSede(sede.getId());
    }

    @Override
    public List<Carrera> listarCarrerasSede(String palabra) {
        CarreraJpaController cjpa = new CarreraJpaController();
        return cjpa.findCarreraSede(sede.getId(), palabra);
    }

    @Override
    public List<Curso> listarCursosCursando(String buscar) {
        List<Curso> cursosRetornar = new ArrayList<>();

        Estudiante e = Fabrica.getInstance().getContEst().getLogin();
        for (InscripcionC inscripcion : e.getInscripciones()) {
            Curso c = inscripcion.getCurso().getCurso();
            if (c.estaEnSede(this.sede)) {
                String nombreCurso = c.getNombre().toLowerCase();
                String nombreCarrera = c.getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)) {
                    cursosRetornar.add(c);
                }
            }
        }

        return cursosRetornar;
    }

    @Override
    public List<Examen> listarExamenes(String buscar) {
        List<Examen> examenesRetornar = new ArrayList<>();
        CursoSedeJpaController jpa = new CursoSedeJpaController();
        for (CursoSede cursoS : jpa.findCursoSedeEntities()) {
            if (cursoS.getSede().equals(this.sede)) {
                for (Examen e : cursoS.getExmenes()) {
                    String nombreC = cursoS.getCurso().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if (nombreC.contains(buscar)) {
                        examenesRetornar.add(e);
                    }
                }
            }
        }
        return examenesRetornar;
    }

    @Override
    public List<Examen> listarExamenesEst(String buscar) {
        List<Examen> examenesRetornar = new ArrayList<>();

        Estudiante e = Fabrica.getInstance().getContEst().getLogin();
        for (InscripcionE insEx : e.getExamenes()) {
            Sede sedeEx = insEx.getExamen().getCurso().getSede();
            if (sedeEx.equals(this.sede)) {
                String nombreC = insEx.getExamen().getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreC.contains(buscar)) {
                    examenesRetornar.add(insEx.getExamen());
                }
            }
        }

        return examenesRetornar;
    }

    @Override
    public List<Parcial> listarParciales(String buscar) {
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
            if (parcial.getCurso().getSede().equals(this.sede)) {
                String nombreC = parcial.getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreC.contains(buscar)) {
                    parcialesRetornar.add(parcial);
                }
            }
        }

        return parcialesRetornar;
    }

    @Override
    public List<Parcial> listarParcialesEst(String buscar) {
        List<Parcial> parcialesRetornar = new ArrayList<>();

        Estudiante e = Fabrica.getInstance().getContEst().getLogin();
        for (ResultadoP rp : e.getNotasParciales()) {
            Parcial parcial = rp.getParcial();
            Sede sedeP = parcial.getCurso().getSede();
            if (sedeP.equals(this.sede)) {
                String nombreC = parcial.getCurso().getCurso().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreC.contains(buscar)) {
                    parcialesRetornar.add(parcial);
                }
            }
        }

        return parcialesRetornar;
    }

    @Override
    public List<Parcial> listarParcialesDoc(String buscar) {
        List<Parcial> parcialesRetornar = new ArrayList<>();
        Docente d = Fabrica.getInstance().getContDocente().getLogin();
        for (CursoSede cs : d.getClases()) {
            for (Parcial parcial : cs.getParciales()) {
                if (cs.getSede().equals(this.sede)) {
                    String nombreC = parcial.getCurso().getCurso().getNombre().toLowerCase();
                    String nombreCa = parcial.getCurso().getCurso().getCarrera().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if (nombreC.contains(buscar) || nombreCa.contains(buscar)) {
                        parcialesRetornar.add(parcial);
                    }
                }
            }
        }

        return parcialesRetornar;
    }

    @Override
    public void nuevoCurso(String nombre, int creditos, int semestre, String descripcion, String horario, boolean optativo, Carrera carrera, ArrayList<Boolean> tiposPrevia) throws Exception {
        Curso curso = new Curso();
        curso.setNombre(nombre);
        curso.setCreditos(creditos);
        curso.setSemestre(semestre);
        curso.setDescripcion(descripcion);
        curso.setHorarios(horario);
        curso.setOptativo(optativo);

        List<Previa> previasCur = new ArrayList<>();
        int indice = 0;
        for (Curso cursoPrevia : previasSelec) {
            Previa p = new Previa();
            p.setCurso(curso);
            p.setCursoPrevia(cursoPrevia);
            p.setExamenAprobado(tiposPrevia.get(indice));
            previasCur.add(p);
        }

        curso.setPrevias(previasCur);

        // es cuando el curso se crea a la vez que se esta creando una carrera, se crea y guarda temporalmente en una lista
        if (carrera == null) {
            for (Curso cursoCarrera : cursosCrearCarr) {
                if (cursoCarrera.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                    throw new Exception("Ya existe un curso llamado '" + nombre + "' en la nueva carrera");
                }
            }
            cursosCrearCarr.add(curso);
        } else {
            // en el caso de crear carrera no se setea todavia la relacion carrera-curso ni persiste todavia
            curso.setCarrera(carrera);
            carrera.setCurso(curso);

            CursoSede cs = new CursoSede();
            cs.setCurso(curso);
            cs.setSede(this.sede);
            this.sede.setCursoSede(cs);
            List<CursoSede> cursosedes = new ArrayList<>();
            cursosedes.add(cs);
            curso.setCursoSedes(cursosedes);

            for (Curso cursoCarrera : carrera.getCursos()) {
                if (cursoCarrera.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
                    throw new Exception("Ya existe un curso llamado '" + nombre + "' en la carrera '" + carrera.getNombre() + "'");
                }
            }

            EntityManager em = Fabrica.getInstance().getEntity();
            em.getTransaction().begin();
            try {

                em.persist(cs);
                em.persist(curso);
                for (Previa previa : previasCur) {
                    em.persist(previa);
                }
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
        }
    }

    public boolean esPrevia(Curso curso) {
        if (previasSelec.contains(curso)) {
            return false; // ya esta como previa
        }

        for (Curso c : previasSelec) {
            if (c.tieneComoPrevia(curso)) {
                return false; // es previa de un curso ya seleccionado como previa, redundante
            }
        }

        previasSelec.add(curso); // previa seleccionada OK, se guarada en la lista

        return true;
    }

    public List<Curso> selecSonPrevia(Curso curso) {
        List<Curso> listaCur = new ArrayList<>();
        for (Curso c : previasSelec) {
            if (curso.tieneComoPrevia(c)) {
                listaCur.add(c);
            }
        }

        previasSelec.removeAll(listaCur);

        return listaCur;
    }

    public void limpiarPreviasSelec() {
        this.previasSelec.clear();
    }

    @Override
    public void eliminarPreviaSelec(Curso curso) {
        this.previasSelec.remove(curso);
    }

    @Override
    public boolean selecSedeCarr(Sede sede) {
        if (this.sedesSelec.contains(sede)) {
            return false;
        } else {
            this.sedesSelec.add(sede);
            return true;
        }
    }

    public void limpiarSedesSelec() {
        this.sedesSelec.clear();
    }
    
    public boolean seleccionoAlgunaSede(){
        if(this.sedesSelec.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void eliminarSedeSelec(Sede sede) {
        this.sedesSelec.remove(sede);
    }

    public void nuevaCarrera(String nombre, int creditos, String descripcion, Date inicioPS, Date finPS, Date inicioSS, Date finSS) throws Exception {
        CarreraJpaController jpa = new CarreraJpaController();
        for (Carrera c : jpa.findCarreraEntities()) {
            if (c.getNombre().equals(nombre)) {
                throw new Exception("Ya existe una carrera con el nombre ingresado");
            }
        }
        
        if(cursosCrearCarr.isEmpty()){
            throw new Exception("Debe ingresar al menos un curso para la carrera");
        }
        
        int creditosCursos = 0;
        for (Curso curso : cursosCrearCarr) {
            creditosCursos += curso.getCreditos();
        }
        
        if(creditosCursos < creditos){
            throw new Exception("La suma total de créditos de los cursos ingresados \nes menor a los creditos necesarios para la carrera");
        }

        PeriodoInscripcion inscPrimerSem = new PeriodoInscripcion();
        inscPrimerSem.setInicio(inicioPS);
        inscPrimerSem.setFin(finPS);
        PeriodoInscripcion inscSegSem = new PeriodoInscripcion();
        inscSegSem.setInicio(inicioSS);
        inscSegSem.setFin(finSS);

        Carrera carr = new Carrera();
        carr.setNombre(nombre);
        carr.setCreditos(creditos);
        carr.setDescripcion(descripcion);
        carr.setSedes(sedesSelec);
        carr.setCursos(cursosCrearCarr);
        carr.setPrimerSemestre(inscPrimerSem);
        carr.setSegundoSemestre(inscSegSem);
        for (Curso curso : cursosCrearCarr) {
            List<CursoSede> cursosedes = new ArrayList<>();
            for (Sede s : sedesSelec) {
                CursoSede cs = new CursoSede();
                cs.setCurso(curso);
                cs.setSede(s);
                s.setCursoSede(cs);
                cursosedes.add(cs);
            }
            curso.setCarrera(carr);
            curso.setCursoSedes(cursosedes);
        }

        for (Sede s : sedesSelec) {
            s.setCarrera(carr);
        }

        EntityManager em = Fabrica.getInstance().getEntity();
        em.getTransaction().begin();
        try {
            em.persist(carr);
            for (Curso curso : cursosCrearCarr) {
//                for (CursoSede cursoSede : curso.getCursoSedes()) {
//                    em.persist(cursoSede);
//                }
                em.persist(curso);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }

    public void borrarCursoNuevaCarrera(int index) {
        this.cursosCrearCarr.remove(index);
    }

    public List<Curso> listarCursosCrearCarrera() {
        return this.cursosCrearCarr;
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
        for (Sede s : sedes) {
            if (s.getNombre().equals(Nombre)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Noticia> listarNoticias(String buscar) {
        NoticiaJpaController njpa = new NoticiaJpaController();
        return njpa.getNoticias(sede.getNombre(), buscar);
    }

    @Override
    public List<Noticia> listarNoticias() {
        NoticiaJpaController njpa = new NoticiaJpaController();
        return njpa.getNoticias(sede.getNombre());
    }

    @Override
    public List<Curso> listarCursosDictando(String buscar) {
        List<Curso> cursosRetornar = new ArrayList<>();

        Docente docente = Fabrica.getInstance().getContDocente().getLogin();
        for (CursoSede cursoS : docente.getClases()) {
            if (cursoS.getSede().equals(this.sede)) {
                String nombreCurso = cursoS.getCurso().getNombre().toLowerCase();
                String nombreCarrera = cursoS.getCurso().getCarrera().getNombre().toLowerCase();
                buscar = buscar.toLowerCase();
                if (nombreCurso.contains(buscar) || nombreCarrera.contains(buscar)) {
                    cursosRetornar.add(cursoS.getCurso());
                }
            }
        }

        return cursosRetornar;
    }

    public List<Material> listarMaterialCurso(Curso curso){
        List<Material> materialRetornar = new ArrayList<>();
        
        for (CursoSede cursoS : curso.getCursoSedes()) {
            if(cursoS.getSede().equals(this.sede)){
                materialRetornar = cursoS.getMateriales();
            }
        }
        
        return materialRetornar;
    }
    
    @Override
    public List<Examen> listarExamenesDoc(String buscar){
        List<Examen> examenesRetornar = new ArrayList<>();
        
        Docente docente = Fabrica.getInstance().getContDocente().getLogin();   
        for (CursoSede cursoSClase:  docente.getClases()) {
            if(cursoSClase.getSede().equals(this.sede)){
                for (Examen examen: cursoSClase.getExmenes()) {
                    String nombreC = cursoSClase.getCurso().getNombre().toLowerCase();
                    buscar = buscar.toLowerCase();
                    if(nombreC.contains(buscar)){
                        examenesRetornar.add(examen);
                    }
                }
            }
        }
        
        return examenesRetornar;
    }
    
    public boolean descargarMaterial(String carpetaDestino, Material material) {        
        String extension = FilenameUtils.getExtension(material.getRutaArchivo());
        String rutaDestino = carpetaDestino + "/" + material.getTitulo() + " - " + material.getFechaSubida()+"."+extension;

        return copiarArchivo(material.getRutaArchivo(), rutaDestino);
    }
    
    ////
    public boolean copiarArchivo(String rutaOrigenArchivo, String rutaDestino) {
        try {
            File archivoOrigen = new File(rutaOrigenArchivo);

            //Archivo de destino auxiliar
            File dest = new File(rutaDestino);

            //Crea las carpetas en donde va a ser guardado el tema si no estaban creadas todavia
            dest.getParentFile().mkdirs();

            //Crea el archivo auxiliar primero para despues sobreescribirlo, sino da error
            dest.createNewFile();

            //Copiar el archivo seleccionado al destino
            Files.copy(archivoOrigen.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return true; // Se pudo copiar la imagen correctamente
        } catch (IOException ex) {
            Logger.getLogger(ContDocente.class.getName()).log(Level.SEVERE, null, ex);

            return false; // Error, no se pudo copiar la imagen
        }
    }
}
