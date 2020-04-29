package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.acoes.Usuario;
import es.uma.informatica.sii.acoes.Responsable_actividad;
import es.uma.informatica.sii.acoes.Usuario.Rol;
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




@Named(value = "ModificarResponsable")
@SessionScoped
public class ModificarResponsable implements Serializable {

    private Responsable_actividad responsable;

    public Responsable_actividad getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable_actividad responsable) {
        this.responsable = responsable;
    }

    public Responsable_actividad getUsuario() {
        return this.getUsuario();
    }

    public String getDepartamento() {
        return this.responsable.getDepartamento();
    }

    public Integer getId() {
        return this.responsable.getId();
    }

    public Integer getDni() {
        return this.responsable.getDni();
    }

    public String getNombre() {
        return this.responsable.getNombre();
    }

    public String getApellidos() {
        return this.responsable.getApellidos();
    }

    public String getEstudios() {
        return this.responsable.getEstudios();
    }

    public String getIdioma() {
        return this.responsable.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.responsable.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.responsable.getEmail();
    }

    public String getContrasenia() {
        return this.responsable.getContrasenia();
    }

    public Rol getRol() {
        return this.responsable.getRol();
    }

    public String anadir() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir a un responsable, inténtelo más tarde", "No ha sido posible añadir a un responsable, inténtelo más tarde"));
        return null;
    }

    public String editar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar a un responsable, inténtelo más tarde", "No ha sido posible editar a un responsable, inténtelo más tarde"));
        return null;
    }

    public String eliminar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar a un responsable, inténtelo más tarde", "No ha sido posible eliminar a un responsable, inténtelo más tarde"));
        return null;
    }

    public ModificarResponsable() {
    }
}
