package jsf;

import jpa.Solicitud_Actividad;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "ModificarSolicitud")
@SessionScoped
public class ModificarSolicitud implements Serializable {

    private Solicitud_Actividad solicitud;

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
    
    public String anadir() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir a un alumno, inténtelo más tarde", "No ha sido posible añadir a un alumno, inténtelo más tarde"));
        return null;
    }

    public String editar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar a un alumno, inténtelo más tarde", "No ha sido posible editar a un alumno, inténtelo más tarde"));
        return null;
    }

    public String eliminar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar a un alumno, inténtelo más tarde", "No ha sido posible eliminar a un alumno, inténtelo más tarde"));
        return null;
    }

    public ModificarSolicitud() {
    }
}
