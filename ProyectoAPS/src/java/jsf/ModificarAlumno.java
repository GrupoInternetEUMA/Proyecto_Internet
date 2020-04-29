package jsf;

import jpa.Usuario;
import jpa.Alumno;
import jpa.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "ModificarAlumno")
@SessionScoped
public class ModificarAlumno implements Serializable {

    private Alumno alumno;

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

    public Integer getId() {
        return this.alumno.getId();
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

    public String anadir() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir a un alumno, inténtelo más tarde", "No ha sido posible añadir a un alumno, inténtelo más tarde"));
        return null;
    }

    public String editar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar a un alumno, inténtelo más tarde", "No ha sido posible editar a un alumno, inténtelo más tarde"));
        return null;
    }

    public String eliminar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar a un alumno, inténtelo más tarde", "No ha sido posible eliminar a un alumno, inténtelo más tarde"));
        return null;
    }

    public ModificarAlumno() {
    }
}
