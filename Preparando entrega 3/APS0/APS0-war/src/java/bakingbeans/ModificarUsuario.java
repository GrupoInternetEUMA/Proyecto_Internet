package bakingbeans;

import Entidades.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelos.UsuarioF;

@Named(value = "ModificarUsuario")
@SessionScoped
public class ModificarUsuario implements Serializable {

    @EJB
    private UsuarioF usuarioFacade;
    private Usuario usuario = new Usuario();
    
    public ModificarUsuario(){
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public List<Usuario> findAll(){
        return this.usuarioFacade.findAll();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String anadir() {
        this.usuarioFacade.create(this.usuario);
        this.usuario = new Usuario();
        return "anadirUsuario.xhtml";
    }

    public String editar() {
        this.usuario = usuario;
        return "editarUsuario.xhtml";
    }

    public void eliminar() {
        this.usuarioFacade.remove(usuario);
    }

}
