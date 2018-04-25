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

    public boolean login(String id, String pass) throws Exception {
        EstudianteJpaController ejpa = new EstudianteJpaController(Fabrica.getInstance().getEmf());
        Estudiante e = ejpa.findEstudiante(id);
        if (e != null && e.getPass().equals(pass)) {
            this.login = e;
            return true;
        } else {
            if (e != null) {
                throw new Exception("Contraseña incorrecta");
            } else {
                throw new Exception("Usuario y contraseña incorrecta");
            }
        }
    }

    @Override
    public void inscripcion(CursoSede cs) throws Exception {
        this.login.setIncripcion(cs);
    }

    @Override
    public List<Object[]> sedesEstudiante() {
        List<Object[]> retornar = new ArrayList<>();
        if(this.login.getSedes()!= null){
        Iterator<Sede> it = this.login.getSedes().iterator();
        while (it.hasNext()) {
            Sede next = it.next();
            Object[] o = {next.getId(), next.getNombre()};
            retornar.add(o);
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

}
