package bakingbeans;

import Entidades.Usuario;
import Entidades.Alumno;
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
import modelos.AlumnoF;

@Named(value = "ListaAlumnos")
@SessionScoped
public class ListaAlumnos implements Serializable {

    @EJB
    private Usuario usuario;
    private AlumnoF alumnoFacade;
    private Alumno alumno = new Alumno();

    public ListaAlumnos() {
        
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Alumno> findAll(){
        return this.alumnoFacade.findAll();
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    
    
    public String getTitulacion() {
        return this.alumno.getTitulacion();
    }

    public Integer getNum_expediente() {
        return this.alumno.getNum_expediente();
    }

    public Integer getDni() {
        return this.alumno.getDni();
    }

    public String getNombre() {
        return this.alumno.getNombre();
    }

    public String getApellidos() {
        return this.alumno.getApellidos();
    }

    public String getEstudios() {
        return this.alumno.getEstudios();
    }

    public String getIdioma() {
        return this.alumno.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.alumno.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.alumno.getEmail();
    }

    public String getContrasenia() {
        return this.alumno.getContrasenia();
    }

    public Rol getRol() {
        return this.alumno.getRol();
    }

    public String ListaAlumnos() {
        return "listaAlumnos.xhtml";
    }
    
    public String crearAlumno() {
        return "anadirAlumno.xhtml";
    }

    public String verAlumno(int id) {
        return "editarAlumno.xhtml";
    }

    public String anadir() {
        this.alumnoFacade.create(this.alumno);
        this.alumno = new Alumno();
        return "listaAlumno.xhtml";
    }

    public String editar() {
        this.alumno = alumno;
        return "editarAlumno.xhtml";
    }

    public void eliminar() {
        this.alumnoFacade.remove(alumno);
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaAlumnos.xhtml";
        }
        // Si el usuario es Alumno, le llevará a la página web de INDEX
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
