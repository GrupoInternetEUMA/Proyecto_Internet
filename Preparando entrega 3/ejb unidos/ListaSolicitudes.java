package bakingbeans;

import Entidades.Usuario;
import Entidades.Actividad;
import Entidades.Solicitud_Actividad;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.context.FacesContext;
import modelos.SolicitudF;

@Named(value = "ListaSolicitudes")
@SessionScoped
public class ListaSolicitudes implements Serializable {

   
    private Actividad actividad;
    private Usuario usuario;
    private SolicitudF solicitudFacade;
    private Solicitud_Actividad solicitud = new Solicitud_Actividad();

    public ListaSolicitudes() {
        
    }

     public List<Solicitud_Actividad> findAll(){
        return this.solicitudFacade.findAll();
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

    public String crearSolicitud() {
        return "anadirSolicitud.xhtml";
    }
    
     public Integer getId() {
        return this.solicitud.getId();
    }

    public String getEstado() {
        return this.solicitud.getEstado();
    }

    public Date getFechaSolicitud() {
        return this.solicitud.getFecha_solicitud();
    }

    public String ListaSolicitudes() {
        return "listaSolicitudes.xhtml";
    }

    public String verSolicitud(int id) {
        return "editarSolicitud.xhtml";
    }

    public String anadir() {
        this.solicitudFacade.create(this.solicitud);
        this.solicitud = new Solicitud_Actividad();
        return "anadirSolicitud.xhtml";
    }

    public String editar() {
        this.solicitud = solicitud;
        return "editarSolicitud.xhtml";
    }

    public void eliminar() {
        this.solicitudFacade.remove(solicitud);
    }

}
