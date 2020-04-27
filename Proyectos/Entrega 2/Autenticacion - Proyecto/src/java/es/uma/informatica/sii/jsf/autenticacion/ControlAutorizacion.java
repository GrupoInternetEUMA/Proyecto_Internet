/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ADMINISTRADOR;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ESTUDIANTE;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.PROFESOR;
import static es.uma.informatica.sii.jsf.autenticacion.modelo.Usuario.Rol.ONG;

/**
 *
 * @author francis
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "admin.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ESTUDIANTE)){
            return "estudiante.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().PROFESOR)){
            return "profesor.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ONG)){
            return "ong.xhtml";
        }
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}