
package Clases;

import java.util.List;


public interface IContAdmin {
    public abstract boolean login(String user, String Pass) throws Exception;    
    public abstract void nuevaNoticia(String titulo, String texto, List<String> etiquetas);
    public abstract List<Noticia> listarNoticias(String buscar);
}
