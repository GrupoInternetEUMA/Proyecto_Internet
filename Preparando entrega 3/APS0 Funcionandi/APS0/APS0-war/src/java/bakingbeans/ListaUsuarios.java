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

    @EJB
    private UsuarioEJB usuariosEJB;
    private Usuario usu;

    public ListaUsuarios() {

    }

    public List<Usuario> findAll() {
        return this.usuariosEJB.findAll();
    }
    
    public Rol[] getRoles(){
        return Rol.values();
    }

    public Usuario getUsuario() {
        return usu;
    }

    public void setUsuario(Usuario usu) {
        this.usu = usu;
    }
    
    public Integer getDni() {
        return this.usu.getDni();
    }

    public String getNombre() {
        return this.usu.getNombre();
    }

    public String getApellidos() {
        return this.usu.getApellidos();
    }

    public String getEstudios() {
        return this.usu.getEstudios();
    }

    public String getIdioma() {
        return this.usu.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.usu.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.usu.getEmail();
    }

    public String getContrasenia() {
        return this.usu.getContrasenia();
    }

    public Usuario.Rol getRol() {
        return this.usu.getRol();
    }

    public String crearUsuario() {
        return "anadirUsuario.xhtml";
    }
    
    public String ListaUsuarios() {
        return "listaUsuarios.xhtml";
    }

    public String verUsuario(int id) {
        return "editarUsuario.xhtml";
    }
    
    public String add(){
        this.usuariosEJB.create(this.usu);
        this.usu = new Usuario();
        return "listaUsuarios.xhtml";
    }
    
    public void delete(Usuario u){
        this.usuariosEJB.remove(u);
    }
    
    public String edit(Usuario usu){
        this.usu = usu;
        return "editarUsuario.xhtml";
    }
    
    public String edit(){
        this.usuariosEJB.edit(this.usu);
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
        usu = null;
        return "login.xhtml";
    }

}
