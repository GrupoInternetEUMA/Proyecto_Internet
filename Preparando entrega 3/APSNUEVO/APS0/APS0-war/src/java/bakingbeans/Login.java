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
import ejb.UsuarioEJB;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.enterprise.context.SessionScoped;

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
    UsuarioEJB bbdd;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        
    }
     
    public List<Usuario> getUsuarios(){
        
       return bbdd.findAll();
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
        /*usuarios = getUsuarios();
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
        return null;*/
        Usuario u = bbdd.comprobarContrasenia(usuario,contrasenia);
        if(u!=null){
            ctrl.setUsuario(u);
            return ctrl.home();
        }
        return null;
       
    }
        
        

}
