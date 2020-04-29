package jsf;

import jpa.Solicitud_Actividad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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

    public ModificarSolicitud() {
    }
}
