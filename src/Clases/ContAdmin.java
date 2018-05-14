
package Clases;

import Persistencia.AdminJpaController;
import Persistencia.NoticiaJpaController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
    
}
