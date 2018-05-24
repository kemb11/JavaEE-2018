
package Clases;

import java.util.List;
import java.util.Map;

public interface IContAdmin {
    public abstract boolean login(String user, String Pass) throws Exception;    
    public abstract void nuevaNoticia(String titulo, String texto, List<String> etiquetas);
    public abstract List<Noticia> listarNoticias(String buscar);
    
    public abstract void crearSedeVar(String nombre, String direccion, String telefono) throws Exception;
    public abstract List<String> getSedes();
    public abstract void borrarSede(String nombre);
    
    public abstract Map<String,String> getInfoSedeByNombre(String nombre);
    public abstract Admin getLogin();
}
