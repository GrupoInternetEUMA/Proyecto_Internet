/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.acoes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jesús Correa Conejero
 */

@Named(value = "ModificarSolicitud")
@SessionScoped
public class ModificarSolicitud implements Serializable {
    private Solicitud_Actividad solicitud;


    public Solicitud_Actividad getSolicitud() {
        return solicitud;
    }

    public void setSolicitu(Solicitud_Actividad solicitud) {
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

   
    public String ListaSolicitudes(){
        return "listaSolicitudes.xhtml";
    }
     
   public String verSolicitud(int id){
        return "modificarSolicitud.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ModificarSolicitud(){
    }
}

