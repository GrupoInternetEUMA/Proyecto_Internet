package jsf;

import jpa.Usuario;
import jpa.Alumno;
import jpa.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;
import modelos.AlumnosF;
import entidades.*;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

@Named(value = "ListaAlumnos")
@SessionScoped
public class ListaAlumnos implements Serializable {

    private ArrayList<Alumno> alumnos;
    private Usuario usuario;
    @EJB
    private AlumnosF alumnosF;
    private Alumno alumno = new Alumno();
    
    public ListaAlumnos() {
        alumnos = new ArrayList<>();
        alumnos.add(new Alumno(000001, 12345678, "David", "El Gnomo", null, "Castellano", new Date(1997, 2, 28), "prueba@uma.es", "1234", Rol.ALUMNO, "DavidGnomo", "Ing Informatica", 1231234));
        alumnos.add(new Alumno(000002, 12312312, "Anastasia", "Sanches Cotrina", "Psicologia", "Castellano, Ingles", new Date(1998, 11, 3), "La_Anastasita_xula@uma.es", "twerk", Rol.ALUMNO, "AnaSans", "Universidad de la calle", 1234729));
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String crearAlumno() {
        return "anadirAlumno.xhtml";
    }
    
    public void delete(Alumno alu){
        this.AlumnosF.remove(alu);
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaAlumnos.xhtml";
        }
        // Si el usuario es Alumno, le llevará a la página web de INDEX
        // REVISAR
        if (getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "login.xhtml";
        }
        return null;
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

}
