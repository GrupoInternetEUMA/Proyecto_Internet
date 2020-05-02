package jsf;

import jpa.Usuario;
import jpa.Responsable_actividad;
import jpa.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;

@Named(value = "ListaResponsables")
@SessionScoped
public class ListaResponsables implements Serializable {

    private ArrayList<Responsable_actividad> responsables;
    private Usuario usuario;
    private Responsable_actividad responsable;

    public ListaResponsables() {
        responsables = new ArrayList<>();
        responsables.add(new Responsable_actividad(000003, 12345678, "Francisco", "El guay", "Fisica Nuclear", "Castellano", new Date(1975, 5, 30), "profe1@uma.es", "pass123", Rol.RESPONSABLE, "fisicoLoco", "Ciencias naturales"));
        responsables.add(new Responsable_actividad(000004, 39645678, "Vaiana", "Jimenez Guacho", "Odontologia", "Aleman", new Date(1987, 10, 6), "profe2@uma.es", "321PaS", Rol.RESPONSABLE, "Sacamuelas", "Anatomia"));
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Responsable_actividad> getResponsables() {
        return responsables;
    }

    public void setResponsables(Responsable_actividad responsable) {
        this.responsable = responsable;
    }

    public Responsable_actividad getResponsable() {
        return responsable;
    }

    public String crearResponsable() {
        return "anadirResponsable.xhtml";
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de responsable
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaResponsables.xhtml";
        }
        // Si el usuario es responsable, le llevará a la página web de INDEX
        // REVISAR
        if (getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)) {
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
