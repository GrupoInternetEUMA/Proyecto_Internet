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
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named(value = "ListaUsuarios")
@SessionScoped
public class ListaUsuarios implements Serializable {

    private ArrayList<Usuario> usuarios;
    private Usuario usuario;

    public ListaUsuarios() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario( 782536, "Paula", "Lopes Bizagui", "Barrendera", "Castelano", new Date(1997, 2, 28), "paulita@gmail.com", "ContraQWER", null, "paulinaRubio69"));

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
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
