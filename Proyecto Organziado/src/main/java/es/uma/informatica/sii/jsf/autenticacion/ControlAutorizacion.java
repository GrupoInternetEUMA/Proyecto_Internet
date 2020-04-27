/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.acoes.Usuario;
import static es.uma.informatica.sii.acoes.Usuario.Rol.ADMINISTRADOR;
import static es.uma.informatica.sii.acoes.Usuario.Rol.ONG;
import static es.uma.informatica.sii.acoes.Usuario.Rol.RESPONSABLE;
import static es.uma.informatica.sii.acoes.Usuario.Rol.ALUMNO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose Antonio Bravo Gonzalez
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "admin.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ONG)){
            return "ong.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)){
            return "responsable.xhtml";
        }
        
        if(getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)){
            return "alumno.xhtml";
        }
        
        return null;
    }
    
    public String registro() {
        if(getUsuario()==null){
            return "registrarse.xhtml";
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
