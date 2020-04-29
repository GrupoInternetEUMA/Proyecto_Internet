package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.acoes.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;




@Named(value = "EditarONG")
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

    public ModificarONG() {
    }
}
