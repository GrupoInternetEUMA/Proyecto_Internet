package jsf;

import jpa.ONG;
import jsf.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author José Antonio Bravo Gonzalez
 */

@Named(value = "ModificarONG")
@SessionScoped
public class ModificarONG implements Serializable {

    private ONG ong;

    public ONG getONG() {
        return ong;
    }

    public void setONG(ONG ong) {
        this.ong = ong;
    }

    public Integer getId() {
        return this.ong.getId();
    }

    public String getNombre() {
        return this.ong.getNombre();
    }

    public String getDescripcion() {
        return this.ong.getDescripcion();
    }

    public String getEmail() {
        return this.ong.getEmail();
    }

    public Integer getTelefono() {
        return this.ong.getTelefono();
    }

    public String getDireccion() {
        return this.ong.getDireccion();
    }

    public String getPais() {
        return this.ong.getPais();
    }

    public String getPassword() {
        return this.ong.getPassword();
    }

    public String ListaONGs() {
        return "listaONGs.xhtml";
    }

    public String verONG(int id) {
        return "editarONG.xhtml";
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

    public ModificarONG() {
    }
}
