package bakingbeans;

import Entidades.Usuario;
import Entidades.Actividad;
import Entidades.Solicitud_Actividad;
import ejb.ActividadEJB;
import ejb.SolicitudEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaSolicitudes")
@SessionScoped
public class ListaSolicitudes implements Serializable {

 
    private Actividad actividad;
    private Usuario usuario;
    private Solicitud_Actividad solicitud = new Solicitud_Actividad();
    
    @Inject
    SolicitudEJB bbdd;
    @Inject
    ControlAutorizacion ctrl;

    public ListaSolicitudes(){   
    }
       

    public List<Solicitud_Actividad> getSolicitudes() {
        return bbdd.findAll();
    }

    public Actividad getActividad() {
        return actividad;
    }
    
    

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Solicitud_Actividad getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud_Actividad solicitud) {
        this.solicitud = solicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public String ListaSolicitudes() {
        return "listaSolicitudes.xhtml";
    }
    
    public String verSolicitud(Solicitud_Actividad s) {
        solicitud = s;
        return "editarSolicitud.xhtml";
    }

    public String crearSolicitud() {
        return "anadirSolicitud.xhtml";
    }
    
    public String anadir() {
       this.bbdd.create(this.solicitud);
       this.solicitud = new Solicitud_Actividad();
       return "listaSolicitudes.xhtml";
    }
    
    public String editar() {  // Pasar parámetros del login
        bbdd.edit(solicitud);
        return "listaSolicitudes.xhtml";
    }
    
    public void eliminar(Solicitud_Actividad s) {  // Pasar parámetros del login
        bbdd.remove(s);
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
