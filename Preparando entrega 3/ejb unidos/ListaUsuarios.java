package bakingbeans;

import Entidades.Usuario;
import Entidades.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import modelos.UsuarioF;

@Named(value = "ListaUsuarios")
@SessionScoped
public class ListaUsuarios implements Serializable {

    @EJB
    private UsuarioF usuarioFacade;
    private Usuario usuario = new Usuario();

    public ListaUsuarios() {
       

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Usuario> findAll(){
        return this.usuarioFacade.findAll();
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

    public String crearUsuario() {
        return "anadirUsuario.xhtml";
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Usuarios
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaUsuarios.xhtml";
        }
        // Si el usuario es Usuario, le llevará a la página web de INDEX
        // REVISAR
        if (getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "login.xhtml";
        }
        return null;
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

}
