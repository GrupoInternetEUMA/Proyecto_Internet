package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.acoes.Actividad;
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




@Named(value = "ModificarActividad")
@SessionScoped
public class ModificarActividad implements Serializable {

    private Actividad actividad;

    public Actividad getActividad() {
        return this.actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Integer getId() {
        return this.actividad.getId();
    }

    public String getNombre() {
        return this.actividad.getNombre();
    }

    public String getDescripcion() {
        return this.actividad.getDescripcion();
    }

    public Date getFecha_inicio() {
        return this.actividad.getFecha_inicio();
    }

    public Date getFecha_fin() {
        return this.actividad.getFecha_fin();
    }

    public String getEstado() {
        return this.actividad.getEstado();
    }

    public String getTipo() {
        return this.actividad.getTipo();
    }

    public String getLugar() {
        return this.actividad.getLugar();
    }

    public String anadir() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir la actividad, inténtelo más tarde", "No ha sido posible añadir la actividad, inténtelo más tarde"));
        return null;

    }

    public String editar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible editar la actividad, inténtelo más tarde", "No ha sido posible editar la actividad, inténtelo más tarde"));
        return null;
    }

    public String eliminar() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible eliminar la actividad, inténtelo más tarde", "No ha sido posible eliminar la actividad, inténtelo más tarde"));
        return null;
    }

    public ModificarActividad() {
    }
}
