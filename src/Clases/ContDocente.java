/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Persistencia.ExamenJpaController;
import Persistencia.InscripcionEJpaController;
import Persistencia.ParcialJpaController;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Usuario
 */
public class ContDocente implements IContDocente{

    private static ContDocente instancia;
    private Docente login;
    
    public ContDocente() {
    }    
    
    public static ContDocente getInstance() {
        if (instancia == null) {
            instancia = new ContDocente();
        }
        return instancia;
    }
    
    @Override
    public boolean subirMaterial(String titulo, String descripcion, String rutaArchivo, Curso curso){
        String extension = FilenameUtils.getExtension(rutaArchivo);
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        CursoSede cursoSede = null;
        for (CursoSede cursoS : curso.getCursoSedes()) {
            if(cursoS.getSede().equals(sedeSelec)){
                cursoSede = cursoS;
                break;
            }
        }        
        
        if(cursoSede!=null){
            Material material = new Material();
            material.setTitulo(titulo);
            material.setDescripcion(descripcion);
            material.setRutaArchivo("");
            material.setFechaSubida(new Date());

            // Lo persisto antes para obtener el id autogenerado
            EntityManager em = Fabrica.getInstance().getEntity();
            em.getTransaction().begin();
            try {
                em.persist(material);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
            }

            String rutaDestino = "MaterialDeEstudio/"+cursoSede.getId()+"/"+material.getId()+"."+extension;
            if(copiarArchivo(rutaArchivo, rutaDestino)){            
                return true;
            }else{
                try {
                    em.remove(material); // si no se pudo copiar el archivo que elimine el material de la bd
                } catch (Exception e) {
                    e.printStackTrace();
                    em.getTransaction().rollback();
                }
            }
        }       
        
        return false;
    }
    
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
    
    @Override
    public boolean dictaCurso(Curso curso){
        Sede sedeSelec = Fabrica.getInstance().getContEdu().getSede();
        for (CursoSede cursoS : curso.getCursoSedes()) {
            if(cursoS.getSede().equals(sedeSelec)){
                if(login.getClases().contains(cursoS)){
                    return true;
                }
            }
        }         
        return false;
    }
    
    @Override
    public void login(Docente docente){
        login = docente;
    }
    
    @Override
    public Docente getLogin(){
        return login;
    }

    @Override
    public boolean isEditableExamen(Examen e) {
        return e.getCurso().getDocente().equals(this.login);
    }

    @Override
    public void subirNotasExamen(Examen e) {
        try {
            ExamenJpaController ejpa = new ExamenJpaController();
            ejpa.edit(e);
            InscripcionEJpaController iejpa = new InscripcionEJpaController();
            for(InscripcionE ie : e.getEstudiantesInscritos()){
                iejpa.edit(ie);
            }
        } catch (Exception ex) {
            Logger.getLogger(ContDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void subirNotasParcial(Parcial p) {
        ParcialJpaController pjpa = new ParcialJpaController();
        try {
            pjpa.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ContDocente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
