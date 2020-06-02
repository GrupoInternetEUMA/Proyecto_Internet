package bakingbeans;

import Entidades.Usuario;
import static Entidades.Usuario.Rol.ADMINISTRADOR;
import static Entidades.Usuario.Rol.ONG;
import static Entidades.Usuario.Rol.RESPONSABLE;
import static Entidades.Usuario.Rol.ALUMNO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author José Antonio Bravo Gonzalez
 */
@Named(value = "controlAutorizacion")
@SessionScoped
public class ControlAutorizacion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;
   
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "admin.xhtml";
        }
        if (getUsuario().getRol().equals(getUsuario().getRol().ONG)) {
            return "ong.xhtml";
        }
        if (getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)) {
            return "responsable.xhtml";
        }
        if (getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "alumno.xhtml";
        }
        if (getUsuario().getRol().equals(getUsuario().getRol().NORMAL)) {
            return "normal.xhtml";
        }
        return null;
    }

    public String registro() {
        if (getUsuario() == null) {
            return "registrarse.xhtml";
        }
        return null;
    }

    public String listaONGs() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "listaONGs.xhtml";
        }
        return null;
    }

    public String listaInformes() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR) || getUsuario().getRol().equals(getUsuario().getRol().ONG)
                || getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE) || getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "listaInformes.xhtml";
        }
        return null;
    }

    public String listaAlumnos() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR) || getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)) {
            return "listaAlumnos.xhtml";
        }
        return null;
    }

    public String listaUsuarios() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "listaUsuarios.xhtml";
        }
        return null;
    }

    public String listaResponsables() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "listaResponsables.xhtml";
        }
        return null;
    }

    public String listaActividades() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR) || getUsuario().getRol().equals(getUsuario().getRol().ONG)
                || getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE) || getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)
                || getUsuario().getRol().equals(getUsuario().getRol().NORMAL)) {
            return "listaActividades.xhtml";
        }
        return null;
    }

    public String listaSolicitudes() {
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR) || getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)
                || getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "listaSolicitudes.xhtml";
        }
        return null;
    }

    public String misDatos() {
        if (getUsuario().getRol().equals(getUsuario().getRol().NORMAL) || getUsuario().getRol().equals(getUsuario().getRol().RESPONSABLE)
                || getUsuario().getRol().equals(getUsuario().getRol().ALUMNO) || getUsuario().getRol().equals(getUsuario().getRol().ONG)) {

            return "misDatos.xhtml";
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

    public ControlAutorizacion() {
    }

    private static class BaseDeDatosLocal {

        public BaseDeDatosLocal() {
        }
    }
}
