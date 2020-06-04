package JSF;

import Entidades.Usuario;
import Entidades.Responsable_actividad;
import Entidades.Usuario.Rol;
import ejb.ResponsableEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaResponsables")
@RequestScoped
public class ListaResponsables implements Serializable {

    private Usuario usuario;
    private Responsable_actividad responsableconectado;
    
    private Responsable_actividad responsable = new Responsable_actividad();
    @Inject
    ResponsableEJB bbdd;
    @Inject
    ControlAutorizacion ctrl;
    
    
    public ListaResponsables() {
    
    }
    
    public String verResponsable(Responsable_actividad a) {
        responsable = a;
        return "editarResponsable.xhtml";
    }
    
    public String getResponsableC(){
        responsableconectado = new Responsable_actividad();
      for(Responsable_actividad res : bbdd.findAll()){
           if(res.getUsuario().equals(ctrl.getUsuario().getUsuario())){
               responsable = res;
               responsableconectado = res;
           }
       } 
      return "misDatos.xhtml";
     }
    
    public List<Responsable_actividad> getResponsables() {
        return bbdd.findAll();
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

    public String editarResponsable() {
        
        return "editarResponsable.xhtml";
    }
    
    public String editar(){
        bbdd.edit(responsable);
        return "listaResponsables.xhtml";
    }
    
    public void eliminar(Responsable_actividad a){
        bbdd.remove(a);
        
    }
    
    public String anadir(){
        responsable.setRol(Rol.RESPONSABLE);
        this.bbdd.create(this.responsable);
        this.responsable = new Responsable_actividad();
        return "listaResponsables.xhtml";
       
    }
}
