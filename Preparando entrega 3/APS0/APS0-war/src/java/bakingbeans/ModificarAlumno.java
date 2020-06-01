package bakingbeans;

import Entidades.Usuario;
import Entidades.Alumno;
import Entidades.Usuario.Rol;
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
import modelos.AlumnoF;

@Named(value = "ModificarAlumno")
@SessionScoped
public class ModificarAlumno implements Serializable {

    @EJB
    private AlumnoF alumnoFacade;
    private Alumno alumno = new Alumno();
    
    public List<Alumno> findAll(){
        return this.alumnoFacade.findAll();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getUsuario() {
        return this.getUsuario();
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

    public String verAlumno(int id) {
        return "editarAlumno.xhtml";
    }

    public String anadir() {
        this.alumnoFacade.create(this.alumno);
        this.alumno = new Alumno();
        return "anadirUsuario.xhtml";
    }

    public String editar() {
        this.alumno = alumno;
        return "editarUsuario.xhtml";
    }

    public void eliminar() {
        this.alumnoFacade.remove(alumno);
    }

    public ModificarAlumno() {
    }
}
