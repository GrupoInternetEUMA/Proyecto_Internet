package bakingbeans;

import Aplicacion.BaseDeDatosLocal;
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

    private String usuario;
    private String contrasenia;
    private List<Usuario> usuarios;

    @Inject
    private ControlAutorizacion ctrl;
    
    

    @Inject
    private BaseDeDatosLocal bd;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<Usuario>();
        usuarios.add(new Usuario("admin", "admin", Rol.ADMINISTRADOR));
        usuarios.add(new Usuario("ong", "ong", Rol.ONG));
        usuarios.add(new Usuario("resp", "resp", Rol.RESPONSABLE));
        usuarios.add(new Usuario("alu", "alu", Rol.ALUMNO));
        usuarios.add(new Usuario("normal", "normal", Rol.NORMAL));
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String autenticar() {
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        Iterator<Usuario> iter = usuarios.iterator();
        boolean pass = false;
        boolean user = false;
        Usuario usuario = null;

        while (iter.hasNext() && !user) {
            usuario = iter.next();

            if (usuario.getUsuario().equals(getUsuario())) {
                user = true;
                if (usuario.getContrasenia().equals(getContrasenia())) {
                    pass = true;
                    ctrl.setUsuario(usuario);
                    return ctrl.home();
                }
            }
        }

        if (!user) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario introducido no existe", "El usuario introducido no existe"));
            return null;
        }

        if (!pass) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña introducida es incorrecta", "La contraseña introducida es incorrecta"));
            return null;
        }

        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El método autenticar() no está implementado", "El método autenticar() no está implementado"));
        return null;
    }

}
