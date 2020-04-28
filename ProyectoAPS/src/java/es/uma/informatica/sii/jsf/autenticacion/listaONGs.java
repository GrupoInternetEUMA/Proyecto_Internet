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
import javax.faces.context.FacesContext;
import es.uma.informatica.sii.acoes.*;
/**
 *
 * @author josea
 */
@Named(value = "ListaONGs")
@SessionScoped

public class listaONGs implements Serializable {
    private final ArrayList<ONG> ongs;
    private Usuario usuario;
    private ONG ong;
    
    public listaSolicitudes(){
        ongs = new ArrayList<>();
        ongs.add(new Solicitud_Actividad(1,"Pendiente",);
        ongs = new ONG();
    }

    public ArrayList<ONG> getONGs(){
        return ongs;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public String crearONG(){
        return "anadirONG.xhtml";
    }
}
