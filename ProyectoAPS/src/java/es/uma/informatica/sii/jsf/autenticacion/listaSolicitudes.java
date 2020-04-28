/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import es.uma.informatica.sii.acoes.*;

/**
 *
 * @author Antonio
 */
@Named(value = "ListaSolicitudes")
@SessionScoped
public class listaSolicitudes implements Serializable {

    private final ArrayList<Solicitud_Actividad> solicitudes;
    private Actividad actividad;
    private Usuario usuario;
    private Solicitud_Actividad solicitud;

    public listaSolicitudes() {
        solicitudes = new ArrayList<>();
        solicitudes.add(new Solicitud_Actividad(1, "Pendiente", (new Date(2000, 10, 23))));
        solicitudes.add(new Solicitud_Actividad(2, "Aprobada", (new Date(2001, 10, 23))));
        solicitudes.add(new Solicitud_Actividad(3, "Pendiente", (new Date(2010, 12, 3))));
        solicitudes.add(new Solicitud_Actividad(4, "Pendiente", (new Date(2004, 1, 23))));
        solicitud = new Solicitud_Actividad();
    }

    public ArrayList<Solicitud_Actividad> getSolicitudes() {
        return solicitudes;
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

}
