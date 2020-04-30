package jsf;

import jpa.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "ModificarUsuario")
@SessionScoped
public class ModificarUsuario implements Serializable {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.usuario.getId();
    }

    public Integer getDni() {
        return this.usuario.getDni();
    }

    public String getNombre() {
        return this.usuario.getNombre();
    }

    public String getApellidos() {
        return this.usuario.getApellidos();
    }

    public String getEstudios() {
        return this.usuario.getEstudios();
    }

    public String getIdioma() {
        return this.usuario.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.usuario.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.usuario.getEmail();
    }

    public String getContrasenia() {
        return this.usuario.getContrasenia();
    }

    public Usuario.Rol getRol() {
        return this.usuario.getRol();
    }


    public String ListaUsuarios() {
        return "listaUsuarios.xhtml";
    }

    public String verUsuario(int id) {
        return "editarUsuario.xhtml";
    }

    public String anadir() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir a un usuario, inténtelo más tarde", "No ha sido posible añadir a un usuario, inténtelo más tarde"));
        return null;
    }

    public String editar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar a un usuario, inténtelo más tarde", "No ha sido posible editar a un usuario, inténtelo más tarde"));
        return null;
    }

    public String eliminar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar a un usuario, inténtelo más tarde", "No ha sido posible eliminar a un usuario, inténtelo más tarde"));
        return null;
    }

    public ModificarUsuario() {
    }
}
