/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ContEstadisticas implements IContEstadisticas{
    
    private static ContEstadisticas instancia;

    private ContEstadisticas() {
    }
    
    public static ContEstadisticas getInstance() {
        if (instancia == null) {
            instancia = new ContEstadisticas();
        }
        return instancia;
    }

    /// Estadisticas Curso ///
    @Override
    public double promedioParcialesCurso(boolean todasSedes, Curso curso){
        int suma = 0;
        int cantCursos = 0;
        for (CursoSede cursoSede : curso.getCursoSedes()) {
            Sede sede = Fabrica.getInstance().getContEdu().getSede();
            if(todasSedes == true || sede.equals(cursoSede.getSede())){
                for (Parcial parcial : cursoSede.getParciales()) {
                    for (ResultadoP notaEst : parcial.getNotasEstudiantes()) {
                        suma += notaEst.getNota();
                        cantCursos += 1;
                    }
                }
            }
        }
        
        if(cantCursos != 0){
            double promedio = suma/cantCursos; // regla de tres 
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioExamenesCurso(boolean todasSedes, Curso curso){
        System.out.println("Clases.ContEstadisticas.promedioExamenesCurso()");
        int suma = 0;
        int cantEx = 0;
        System.out.println("for cursosSede");
        for (CursoSede cursoSede : curso.getCursoSedes()) {
            System.out.println("-> "+cursoSede.getCurso().getNombre());
            Sede sede = Fabrica.getInstance().getContEdu().getSede();
            if(todasSedes == true || sede.equals(cursoSede.getSede())){
                System.out.println("-> todasSedes == true || sede.equals(cursoSede.getSede())");
                for (Examen examen : cursoSede.getExmenes()) {
                    System.out.println("\t-> getNotaApro: "+examen.getNotaApro());
                    System.out.println("\t-> getNotaMax: "+examen.getNotaMax());
                    System.out.println("\t-> inscripciones: "+examen.getEstudiantesInscritos().size());
                    for (InscripcionE inscripcion : examen.getEstudiantesInscritos()) {
                        System.out.println("\t\t-> "+inscripcion.getId());
                        if(inscripcion.getNota() != null){
                            suma += inscripcion.getNota().getNota();
                            cantEx += 1;
                        }
                    }
                }
            }
        }
        
        if(cantEx != 0){
            double promedio = suma/cantEx;
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioAprobacionCurso(boolean todasSedes, Curso curso){
        int inscriptos = curso.cantidadDeInscriptos(todasSedes);        
        int aprobados = curso.cantidadDeAprobados(todasSedes);
        
        if(inscriptos != 0){
            double promedio = (aprobados*100)/inscriptos; // regla de tres 
            return promedio;
        }else{
            return -1;
        }
    }
    
    /// Estadisticas Carrera ///
    @Override
    public double promedioParcialesCarrera(boolean enTodasSedes, Carrera carrera){
        int suma = 0;
        int cantCursos = 0;
        for (Curso curso : carrera.getCursos()) {
            for (CursoSede cursoSede : curso.getCursoSedes()) {
                Sede sede = Fabrica.getInstance().getContEdu().getSede();
                if(enTodasSedes == true || sede.equals(cursoSede.getSede())){
                    for (Parcial parcial : cursoSede.getParciales()) {
                        for (ResultadoP notaEst : parcial.getNotasEstudiantes()) {
                            suma += notaEst.getNota();
                            cantCursos += 1;
                        }
                    }
                }
            }
        }
        
        if(cantCursos != 0){
            double promedio = suma/cantCursos;
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioExamenesCarrera(boolean enTodasSedes, Carrera carrera){
        int suma = 0;
        int cantCursos = 0;
        
        for (Curso curso : carrera.getCursos()) {  
            for (CursoSede cursoSede : curso.getCursoSedes()) {
                Sede sede = Fabrica.getInstance().getContEdu().getSede();
                if(enTodasSedes == true || sede.equals(cursoSede.getSede())){
                        for (Examen examen : cursoSede.getExmenes()) {
                            for (InscripcionE inscripcion : examen.getEstudiantesInscritos()) {
                                if(inscripcion.getNota() != null){
                                    suma += inscripcion.getNota().getNota();
                                    cantCursos += 1;
                                }
                            }
                        }
                    }
                }
        }
        
        if(cantCursos != 0){
            double promedio = suma/cantCursos;
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioAprobacionCarrera(boolean enTodasSedes, Carrera carrera){
        Sede sede = Fabrica.getInstance().getContEdu().getSede();
        
        int inscriptos = carrera.cantidadInscriptos();
        int aprobados = carrera.cantidadAprobados(enTodasSedes);        
        
        if(inscriptos != 0){
            double promedio = (aprobados*100)/inscriptos; // regla de tres       
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public Object[] cursoConMasEstudiantesCursandoCarrera(boolean enTodasSedes, Carrera carrera){
        Object[] cursoRetornar ={null, 0};
        
        Sede sede = Fabrica.getInstance().getContEdu().getSede();
        
        for (Curso curso : carrera.getCursos()) {
            int cantEstudiantes = 0;
            for (CursoSede cursoSede : curso.getCursoSedes()) {                
                if(enTodasSedes == true || sede.equals(cursoSede.getSede())){
                    cantEstudiantes += cursoSede.getEstudiantesActuales().size();
                }
            }
            
            int cantAnt = (int) cursoRetornar[1];
            if(cantEstudiantes > cantAnt){
                cursoRetornar[0] = curso;
                cursoRetornar[1] = cantEstudiantes;
            }
        }
        
        return cursoRetornar;
    }
    
    @Override
    public Object[] cursoConMasAprobacionesCarrera(boolean enTodasSedes, Carrera carrera){
        Object[] cursoRetornar ={null, 0};
        
        Sede sede = Fabrica.getInstance().getContEdu().getSede();
        
        for (Curso curso : carrera.getCursos()) {
            int aprobados = curso.cantidadDeAprobados(enTodasSedes);
            
            int aprobdosAnt = (int) cursoRetornar[1];
            if(aprobados > aprobdosAnt){
                cursoRetornar[0] = curso;
                cursoRetornar[1] = aprobados;
            }
            
        }
        
        return cursoRetornar;
    }
    
    @Override
    public Object[] cursoConMejorPrmedioAprobacionCarrera(boolean enTodasSedes, Carrera carrera){
        Object[] cursoRetornar ={null, 0.0};
        
        Sede sede = Fabrica.getInstance().getContEdu().getSede();
        
        for (Curso curso : carrera.getCursos()) {
            double promedio = this.promedioAprobacionCurso(enTodasSedes, curso);
            double promedioAnt = (double) cursoRetornar[1];
            
            if(promedio > promedioAnt){
                cursoRetornar[0] = curso;
                cursoRetornar[1] = promedio;
            }
        }
        
        return cursoRetornar;
    }
    
    /// Estadisticas Sedes ///
    @Override
    public double promedioParcialesSede(boolean enTodasSedes){
        int suma = 0;
        int cantCursos = 0;        
               
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {
                            for (CursoSede cursoSede : curso.getCursoSedes()) {
                                if(enTodasSedes==true || sedeSelec.equals(cursoSede.getSede())){
                                    for (Parcial parcial : cursoSede.getParciales()) {
                                        for (ResultadoP notaEst : parcial.getNotasEstudiantes()) {
                                            suma += notaEst.getNota();
                                            cantCursos += 1;
                                        }
                                    }
                                }
                            }
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        if(cantCursos != 0){
            double promedio = suma/cantCursos;
            return promedio;
        }else{
            return -1;
        }
    } 
    
    @Override
    public double promedioExamenesSede(boolean enTodasSedes){
        int suma = 0;
        int cantCursos = 0;
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {  
                            for (CursoSede cursoSede : curso.getCursoSedes()) {                        
                                if(enTodasSedes == true || sedeSelec.equals(cursoSede.getSede())){
                                    for (Examen examen : cursoSede.getExmenes()) {
                                        for (InscripcionE inscripcion : examen.getEstudiantesInscritos()) {
                                            if(inscripcion.getNota() != null){
                                                suma += inscripcion.getNota().getNota();
                                                cantCursos += 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        if(cantCursos != 0){
            double promedio = suma/cantCursos;
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioAprobacionCursoSede(boolean enTodasSedes){
        int inscriptos = 0;
        int aprobados = 0;
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {
                            inscriptos += curso.cantidadDeInscriptos(enTodasSedes);
                            aprobados += curso.cantidadDeAprobados(enTodasSedes);
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        if(inscriptos != 0){
            double promedio = (aprobados*100)/inscriptos; // regla de tres   
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public double promedioAprobacionCarreraSede(boolean enTodasSedes){
        int inscriptos = 0;
        int aprobados = 0;   
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        inscriptos += carrera.cantidadInscriptos();
                        aprobados += carrera.cantidadAprobados(enTodasSedes);   
                    }
                    carrerasRecorridas.add(carrera);
                }
            }
        }
        
        if(inscriptos != 0){
            double promedio = (aprobados*100)/inscriptos; // regla de tres       
            return promedio;
        }else{
            return -1;
        }
    }
    
    @Override
    public Object[] cursoConMasEstudiantesCursandoSede(boolean enTodasSedes){
        Object[] cursoRetornar ={null, 0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {
                            int cantEstudiantes = 0;
                            for (CursoSede cursoSede : curso.getCursoSedes()) {                
                                if(enTodasSedes == true || sedeSelec.equals(cursoSede.getSede())){
                                    cantEstudiantes += cursoSede.getEstudiantesActuales().size();
                                }
                            }

                            int cantAnt = (int) cursoRetornar[1];
                            if(cantEstudiantes > cantAnt){
                                cursoRetornar[0] = curso;
                                cursoRetornar[1] = cantEstudiantes;
                            }
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        return cursoRetornar;
    }
    
    @Override
    public Object[] cursoConMasAprobacionesCarreraSede(boolean enTodasSedes){
        Object[] cursoRetornar ={null, 0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {
                            int aprobados = curso.cantidadDeAprobados(enTodasSedes);
                            int aprobdosAnt = (int) cursoRetornar[1];
                            
                            if(aprobados > aprobdosAnt){
                                cursoRetornar[0] = curso;
                                cursoRetornar[1] = aprobados;
                            }
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        return cursoRetornar;
    }
    
    @Override
    public Object[] cursoConMejorPrmedioAprobacionCarreraSede(boolean enTodasSedes){
        Object[] cursoRetornar ={null, 0.0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        for (Curso curso : carrera.getCursos()) {
                            double promedioAnt = (double) cursoRetornar[1];
                            double promedio = this.promedioAprobacionCurso(enTodasSedes, curso);
                            
                            if(promedio > promedioAnt){
                                cursoRetornar[0] = curso;
                                cursoRetornar[1] = promedio;
                            }
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        return cursoRetornar;
    }
    
    @Override
    public Object[] carreraConMasEstudiantesCursandoSede(boolean enTodasSedes){
        Object[] carreraRetornar ={null, 0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        int cantEstudiantes = 0;
                        for (Curso curso : carrera.getCursos()) {                        
                            for (CursoSede cursoSede : curso.getCursoSedes()) {                
                                if(enTodasSedes == true || sedeSelec.equals(cursoSede.getSede())){
                                    cantEstudiantes += cursoSede.getEstudiantesActuales().size();
                                }
                            }
                        }

                        int cantAnt = (int) carreraRetornar[1];
                        if(cantEstudiantes > cantAnt){
                            carreraRetornar[0] = carrera;
                            carreraRetornar[1] = cantEstudiantes;
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        return carreraRetornar;
    }
    
    @Override
    public Object[] carreraConMasAprobacionesSede(boolean enTodasSedes){
        Object[] carreraRetornar ={null, 0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        int aprobados = carrera.cantidadAprobados(enTodasSedes);

                        int aprobdosAnt = (int) carreraRetornar[1];
                        if(aprobados > aprobdosAnt){
                            carreraRetornar[0] = carrera;
                            carreraRetornar[1] = aprobados;
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        return carreraRetornar;
    }
    
    @Override
    public Object[] carreraConMejorPrmedioAprobacionSede(boolean enTodasSedes){
        Object[] carreraRetornar ={null, 0.0};
        
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        
        List<Carrera> carrerasRecorridas = new ArrayList<>(); // Esto es porque una carrera puede estar en mas de una sede
        
        for (Sede sede : Fabrica.getInstance().getContEdu().listarSedes()) {
            if(enTodasSedes == true || sedeSelec.equals(sede)){ // para que no recorra toda la sede al pedo
                for (Carrera carrera : sede.getCarreras()) {
                    if(carrerasRecorridas.contains(carrera)==false){
                        double promedioAnt = (double) carreraRetornar[1];
                        double promedio = this.promedioAprobacionCarrera(enTodasSedes, carrera);
                        if(promedio > promedioAnt){
                            carreraRetornar[0] = carrera;
                            carreraRetornar[1] = promedio;
                        }
                        carrerasRecorridas.add(carrera);
                    }
                }
            }
        }
        
        return carreraRetornar;
    }
}
