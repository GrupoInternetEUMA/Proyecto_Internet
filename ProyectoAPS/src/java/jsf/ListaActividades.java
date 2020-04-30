package jsf;

import jpa.Actividad;
import jpa.Usuario;
import jpa.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

@Named(value = "ListaActividades")
@SessionScoped
public class ListaActividades implements Serializable {

    private ArrayList<Actividad> actividades;
    private Actividad actividad;
    private Usuario usuario;

    public ListaActividades() {
        actividades = new ArrayList<>();
        actividades.add(new Actividad(000005, "Recogida Alimentos", "Se va a recoger alimentos por malaga", new Date(2020, 5, 13), new Date(2020, 5, 20), "ACEPTADA", "Voluntariado", "Malaga"));
        actividades.add(new Actividad(000006, "Campaña E.T.S", "Test gratuitos de enfermedades de transimion sexual a cualquier persona", new Date(2020, 2, 11), new Date(2020, 2, 18), "FINALIZADA", "ApS", "Malaga"));
    }

    public Actividad getActividad() {
        return actividad;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String crearActividad() {
        return "anadirActividad.xhtml";
    }
    
    public String verActividad(int id){
        return "verActividad.xhtml";
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaActividades.xhtml";
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
