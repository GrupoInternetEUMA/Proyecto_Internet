package bakingbeans;

import Entidades.Usuario;
import Entidades.Usuario.Rol;
import ejb.UsuarioEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaUsuarios")
@RequestScoped
public class ListaUsuarios implements Serializable {
    
    private Usuario usuario = new Usuario();
    @Inject
    UsuarioEJB bbdd;
    @Inject
    ControlAutorizacion ctrl;
    
    public ListaUsuarios() {

    }

    public List<Usuario> findAll() {
        return this.bbdd.findAll();
    }
    
    public Rol[] getRoles(){
        return Rol.values();
    }

    public Usuario getUsuario() {
        return usuario;
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
    
    public String registro(){
            usuario.setRol(Rol.NORMAL);
            this.bbdd.create(this.usuario);
            this.usuario = new Usuario();
            return "login.xhtml";
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

    public String crearUsuario() {
        return "anadirUsuario.xhtml";
    }
    
    public String ListaUsuarios() {
        return "listaUsuarios.xhtml";
    }

    public String verUsuario(Usuario usu) {
        usuario = usu;
        return "editarUsuario.xhtml";
    }
    
    public String add(){
        this.bbdd.create(this.usuario);
        this.usuario = new Usuario();
        return "listaUsuarios.xhtml";
    }
    
    public void delete(Usuario usuario){
        this.bbdd.remove(usuario);
    }
    
    public String edit(){
        this.bbdd.edit(this.usuario);
        return "listaUsuarios.xhtml";
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
