
package Clases;

import Persistencia.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
public class ContAdmin implements IContAdmin {
    private static ContAdmin instancia;
    private Admin login;

    public ContAdmin() {
    }
    
    public static ContAdmin getInstance(){
        if(instancia == null){
            instancia = new ContAdmin();
        }
        return instancia;
    }

    @Override
    public boolean login(String user, String pass) throws Exception {
        AdminJpaController ajpa = new AdminJpaController();
        Admin a = ajpa.findAdmin(user);
        if (a != null && a.getPass().equals(pass)) {
            this.login = a;
            return true;
        } else {
            if (a != null) {
                throw new Exception("Contraseña incorrecta");
            } else {
                throw new Exception("Usuario y contraseña incorrectos");
            }
        }
    }
    
    
    public Admin getLogin() {
        return login;
    }
    
    @Override
    public void nuevaNoticia(String titulo, String texto, List<String> etiquetas){
        Fabrica.getInstance().getEntity().getTransaction().begin();
        try {             
            Noticia noticia = new Noticia();
            noticia.setTitulo(titulo);
            noticia.setTexto(texto);
            noticia.setEtiquetas(etiquetas);
            noticia.setFecha(new Date());
            Fabrica.getInstance().getEntity().persist(noticia);
            Fabrica.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Fabrica.getInstance().getEntity().getTransaction().rollback();
            throw e;
        }
    }
    
    @Override
    public List<Noticia> listarNoticias(String buscar) {
        NoticiaJpaController njpa = new NoticiaJpaController();
        List<Noticia> noticias = new ArrayList<>();
        
        for (Noticia noticia : njpa.findNoticiaEntities()) {
            if(noticia.getTitulo().contains(buscar)){
                noticias.add(noticia);
            }
        }
        
        return noticias;
    }
    
        
    public void crearEstudiante(Estudiante e) throws Exception{
        EstudianteJpaController ejpa = new EstudianteJpaController();  
        if(ejpa.email(e.getEmail()))
            throw new Exception("El email está ocupado");
        if(ejpa.id(e.getId()))
            throw new Exception("El id está ocupado");
        e.setPass(clave());
        ejpa.create(e);
    }
    
    private String clave() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 125; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
   
    @Override
    public void crearSedeVar(String nombre, String direccion, String telefono) throws Exception{
        Sede s = new Sede();
        s.setNombre(nombre);
        s.setTelefono(telefono);
        s.setDireccion(direccion);
        s.setCarreras(null);
        s.setCursoSedes(null);
        s.setEstudiantes(null);
        SedeJpaController sjpa = new SedeJpaController();
        if(sjpa.existeNombre(s.getNombre()))
            throw new Exception("El nombre de la sede ya existe");
        sjpa.create(s);
    }
    @Override
    public List<String> getSedes(){
        SedeJpaController sjpa = new SedeJpaController();
        List<String> ls = new ArrayList();
        for( Sede s : sjpa.findSedeEntities() ){
            ls.add(s.getNombre());
        }
        return ls;
    }
    @Override
    public void borrarSede(String nombre){
        SedeJpaController sjpa = new SedeJpaController();
        Sede s = sjpa.returnByNombre(nombre);
        Long id = s.getId();
        try{
            sjpa.destroy(id);
        }catch(NonexistentEntityException nee){
            
        }
        
    }
    @Override
    public Map<String,String> getInfoSedeByNombre(String nombre){
        SedeJpaController sjpa = new SedeJpaController();
        Sede s = sjpa.returnByNombre(nombre);
        Map<String, String> hm = new HashMap<String,String>();
        hm.put("nombre", s.getNombre());
        hm.put("direccion", s.getDireccion());
        hm.put("telefono", s.getTelefono());
        return hm;
    }
    
    public void crearDocente(Docente d) throws Exception{
        EstudianteJpaController ejpa = new EstudianteJpaController();  
        DocenteJpaController djpa = new DocenteJpaController();
        if(ejpa.id(d.getId()))
            throw new Exception("El id está ocupado");
        if(djpa.id(d.getId()))
            throw new Exception("El id está ocupado");
        d.setPass(this.clave());
        
    }

}
/*
package Clases;

import Persistencia.*;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.persistence.EntityManager;
public class ContAdmin implements IContAdmin {
    private static ContAdmin instancia;
    private Admin login;

    public ContAdmin() {
    }
    
    public static ContAdmin getInstance(){
        if(instancia == null){
            instancia = new ContAdmin();
        }
        return instancia;
    }
    
    public Admin getLogin() {
        return login;
    }

    @Override
    public boolean login(String user, String pass) throws Exception {
        AdminJpaController ajpa = new AdminJpaController();
        Admin a = ajpa.findAdmin(user);
        if (a != null && a.getPass().equals(pass)) {
            this.login = a;
            return true;
        } else {
            if (a != null) {
                throw new Exception("Contraseña incorrecta");
            } else {
                throw new Exception("Usuario y contraseña incorrectos");
            }
        }
    }
    
    @Override
    public void nuevaNoticia(String titulo, String texto, List<String> etiquetas){
        Fabrica.getInstance().getEntity().getTransaction().begin();
        try {             
            Noticia noticia = new Noticia();
            noticia.setTitulo(titulo);
            noticia.setTexto(texto);
            noticia.setEtiquetas(etiquetas);
            noticia.setFecha(new Date());
            Fabrica.getInstance().getEntity().persist(noticia);
            Fabrica.getInstance().getEntity().getTransaction().commit();
        } catch (Exception e) {
            Fabrica.getInstance().getEntity().getTransaction().rollback();
            throw e;
        }
    }
    
    @Override
    public List<Noticia> listarNoticias(String buscar) {
        NoticiaJpaController njpa = new NoticiaJpaController();
        List<Noticia> noticias = new ArrayList<>();
        
        for (Noticia noticia : njpa.findNoticiaEntities()) {
            if(noticia.getTitulo().contains(buscar)){
                noticias.add(noticia);
            }
        }
        
        return noticias;
    }
    
    public void crearEstudiante(Estudiante e) throws Exception{
        EstudianteJpaController ejpa = new EstudianteJpaController();  
        if(ejpa.email(e.getEmail()))
            throw new Exception("El email está ocupado");
        if(ejpa.id(e.getId()))
            throw new Exception("El id está ocupado");
        e.setPass(clave());
        ejpa.create(e);
    }
    
    private String clave() {
        int leftLimit = 48; // letter 'a'
        int rightLimit = 125; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
   
    @Override
    public void crearSedeVar(String nombre, String direccion, String telefono) throws Exception{
        Sede s = new Sede();
        s.setNombre(nombre);
        s.setTelefono(telefono);
        s.setDireccion(direccion);
        s.setCarreras(null);
        s.setCursoSedes(null);
        s.setEstudiantes(null);
        SedeJpaController sjpa = new SedeJpaController();
        if(sjpa.existeNombre(s.getNombre()))
            throw new Exception("El nombre de la sede ya existe");
        sjpa.create(s);
    }
    @Override
    public List<String> getSedes(){
        SedeJpaController sjpa = new SedeJpaController();
        List<String> ls = new ArrayList();
        for( Sede s : sjpa.findSedeEntities() ){
            ls.add(s.getNombre());
        }
        return ls;
    }
    @Override
    public void borrarSede(String nombre){
        SedeJpaController sjpa = new SedeJpaController();
        Sede s = sjpa.returnByNombre(nombre);
        Long id = s.getId();
        try{
            sjpa.destroy(id);
        }catch(NonexistentEntityException nee){
            
        }
        
    }
    @Override
    public Map<String,String> getInfoSedeByNombre(String nombre){
        SedeJpaController sjpa = new SedeJpaController();
        Sede s = sjpa.returnByNombre(nombre);
        Map<String, String> hm = new HashMap<String,String>();
        hm.put("nombre", s.getNombre());
        hm.put("direccion", s.getDireccion());
        hm.put("telefono", s.getTelefono());
        return hm;
    }
    
    public void crearDocente(Docente d) throws Exception{
        EstudianteJpaController ejpa = new EstudianteJpaController();  
        DocenteJpaController djpa = new DocenteJpaController();
        if(ejpa.id(d.getId()))
            throw new Exception("El id está ocupado");
        if(djpa.id(d.getId()))
            throw new Exception("El id está ocupado");
        d.setPass(this.clave());
        
    }
}
*/