
package Clases;

import Persistencia.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
        SendEmail.EnviarPass(e.getEmail(), e.getPass());
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
    
}
