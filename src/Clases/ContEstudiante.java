package Clases;

import Persistencia.EstudianteJpaController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContEstudiante implements IContEstudiante {

    private static ContEstudiante instancia;
    private Estudiante login;

    private ContEstudiante() {
    }

    public static ContEstudiante getInstance() {
        if (instancia == null) {
            instancia = new ContEstudiante();
        }
        return instancia;
    }

    public Estudiante getLogin() {
        return login;
    }

    @Override
    public boolean login(String id, String pass) throws Exception {
        EstudianteJpaController ejpa = new EstudianteJpaController();
        Estudiante e = ejpa.findEstudiante(id);
        if (e != null && e.getPass().equals(pass)) {
            this.login = e;
            return true;
        } else {
            if (e != null) {
                throw new Exception("Contraseña incorrecta");
            } else {
                throw new Exception("Usuario y contraseña incorrectos");
            }
        }
    }

   
    @Override
    public boolean inscripcionCurso(Curso curso) throws Exception{
        if(curso.getCarrera().periodo()){
            if(this.login.estaInscriptoEnSede(Fabrica.getInstance().getContEdu().getSede())){
                Sede sede = Fabrica.getInstance().getContEdu().getSede();
                for (CursoSede cs : curso.getCursoSedes()) {
                    if(cs.getSede().equals(sede)){
                        if(this.login.estaInscriptoEnCarrera(cs.getCurso().getCarrera())){
                            if(this.login.setIncripcionC(cs) == false){
                                throw new Exception("Ya está inscrito a este curso");
                            }                
                            return true;
                        }else{
                            throw new Exception("Debe estar inscrito en la carrera en la cual se dicta el curso");
                        }
                    }
                }
                return false;
            }else{
                throw new Exception("Debe estar inscrito en la sede en la cual se dicta el curso");
            }
        }else
            throw new Exception("Está fuera del periodo de inscripción");
    }

    @Override
    public List<Sede> sedesEstudiante() {
        List<Sede> retornar = new ArrayList<>();
        if(this.login.getSedes()!= null){
        Iterator<Sede> it = this.login.getSedes().iterator();
        while (it.hasNext()) {
            Sede next = it.next();
            retornar.add(next);
        }}
        return retornar;
    }

    @Override
    public void seleccionarSede(Long id) {
        Fabrica.getInstance().getContEdu().seleccionSede(id);
    }

    @Override
    public void cerrarSesion() {
        this.login = null;
    }
    
    public boolean inscripcionExamen(Examen examen) throws Exception{
        if(examen.periodoOK()){
            if(this.login.estaInscriptoEnSede(Fabrica.getInstance().getContEdu().getSede())){
                Sede sede = Fabrica.getInstance().getContEdu().getSede();                
                if(examen.getCurso().getSede().equals(sede)){
                    if(this.login.estaInscriptoEnCarrera(examen.getCurso().getCurso().getCarrera())){
                        if(this.login.estaInscriptoEnCurso(examen.getCurso().getCurso())){
                            if(this.login.setIncripcionE(examen))
                                return true;
                            else
                                throw new Exception("Ya está inscrito a este exámen");
                        }else{
                            throw new Exception("Debe estar inscrito en el curso en la cual se dará el exámen");
                        }
                    }else{
                        throw new Exception("Debe estar inscrito en la carrera en la cual se dará el exámen");
                    }
                }
                
                return false;
            }else{
                throw new Exception("Debe estar inscrito en la sede en la cual se dará el exámen");
            }
        }else
            throw new Exception("Está fuera del periodo de inscripción");
    }
    
    @Override
    public InscripcionE getInscripcionExamen(Examen examen){
        for (InscripcionE insEx : this.login.getExamenes()) {
            if(insEx.getExamen().equals(examen)){
                return insEx;
            }
        }
        
        return null;
    }
}
