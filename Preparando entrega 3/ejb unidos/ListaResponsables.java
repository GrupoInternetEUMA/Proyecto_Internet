package bakingbeans;

import Entidades.Usuario;
import Entidades.Responsable_actividad;
import Entidades.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import modelos.ResponsableF;

@Named(value = "ListaResponsables")
@SessionScoped
public class ListaResponsables implements Serializable {

    @EJB
    private Usuario usuario;
    private ResponsableF responsableFacade;
    private Responsable_actividad responsable = new Responsable_actividad();

    public ListaResponsables() {
        
    }

    public List<Responsable_actividad> findAll(){
        return this.responsableFacade.findAll();
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setResponsables(Responsable_actividad responsable) {
        this.responsable = responsable;
    }

    public Responsable_actividad getResponsable() {
        return responsable;
    }

    public String getDepartamento() {
        return this.responsable.getDepartamento();
    }

    public Integer getDni() {
        return this.responsable.getDni();
    }

    public String getNombre() {
        return this.responsable.getNombre();
    }

    public String getApellidos() {
        return this.responsable.getApellidos();
    }

    public String getEstudios() {
        return this.responsable.getEstudios();
    }

    public String getIdioma() {
        return this.responsable.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.responsable.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.responsable.getEmail();
    }

    public String getContrasenia() {
        return this.responsable.getContrasenia();
    }

    public Rol getRol() {
        return this.responsable.getRol();
    }

    public String ListaResponsables() {
        return "listaResponsables.xhtml";
    }

    public String verResponsable(int id) {
        return "editarResponsable.xhtml";
    }

     public String anadir() {
        this.responsableFacade.create(this.responsable);
        this.responsable = new Responsable_actividad();
        return "anadirResponsable.xhtml";
    }

    public String editar() {
        this.responsable = responsable;
        return "editarResponsable.xhtml";
    }

    public void eliminar() {
        this.responsableFacade.remove(responsable);
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
