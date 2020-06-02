package bakingbeans;

import javax.enterprise.context.RequestScoped;
import Entidades.Usuario;
import Entidades.Responsable_actividad;
import Entidades.Usuario.Rol;
import ejb.ONGEJB;
import ejb.ResponsableEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaResponsables")
@RequestScoped
public class ListaResponsables implements Serializable {
    
    @Inject ResponsableEJB bbdd;

    private ArrayList<Responsable_actividad> responsables;
    private Usuario usuario;
    private Responsable_actividad responsable;

    public String ListaResponsables() {
        return "listaResponsables.xhtml";
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
    
    public Integer getDni(){
        return responsable.getDni();
    }
    
    public String anadir() throws ParseException{
       this.bbdd.create(this.responsable);
       this.responsable = new Responsable_actividad();
       return "listaResponsables.xhtml";
    }
    
    public String editar() throws ParseException {  // Pasar parámetros del login
        this.responsable = responsable;
        return "listaResponsables.xhtml";
    }
    
    public void eliminar() throws ParseException {  // Pasar parámetros del login
        this.bbdd.remove(responsable);
    }  
    
    //public void ModificarResponsable (){ 
    //    this.responsable = responsable
    // }
    
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