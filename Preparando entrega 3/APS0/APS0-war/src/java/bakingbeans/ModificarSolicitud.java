package bakingbeans;


import Entidades.Solicitud_Actividad;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelos.SolicitudF;

@Named(value = "ModificarSolicitud")
@SessionScoped
public class ModificarSolicitud implements Serializable {

    @EJB
    private SolicitudF solicitudFacade;
    private Solicitud_Actividad solicitud = new Solicitud_Actividad();
    
    public List<Solicitud_Actividad> findAll(){
        return this.solicitudFacade.findAll();
    }

    public Solicitud_Actividad getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud_Actividad solicitud) {
        this.solicitud = solicitud;
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

    public ModificarSolicitud() {
    }
}
