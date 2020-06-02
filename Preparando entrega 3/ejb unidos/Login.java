package bakingbeans;

import Aplicacion.BaseDeDatosLocal;
import excepciones.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import Entidades.Usuario;
import Entidades.Usuario.Rol;

/**
 *
 * @author José Antonio Bravo Gonzalez
 */
@Named(value = "login")
@RequestScoped
public class Login {

   //private String usuario1;
   //private String contrasenia;
   //private List<Usuario> usuarios;
    
    private Usuario usuario;

    @Inject
    private ControlAutorizacion ctrl;
    
    

    @Inject
    private BaseDeDatosLocal bd;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        /*
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("admin", "admin", Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("ong", "ong", Rol.ONG));
        usuarios.add(new Usuario("resp", "resp", Rol.RESPONSABLE));
        usuarios.add(new Usuario("alu", "alu", Rol.ALUMNO));
        usuarios.add(new Usuario("normal", "normal", Rol.NORMAL));
        */
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return usuario.getContrasenia();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.usuario.setContrasenia(contrasenia);
    }

   public String autenticar() {
        try {
            bd.compruebaLogin(usuario);
            ctrl.setUsuario(bd.refrescarUsuario(usuario));
            return "normal.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (AcoesException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

}
