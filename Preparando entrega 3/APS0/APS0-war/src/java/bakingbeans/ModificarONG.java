package bakingbeans;

import Entidades.ONG;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelos.ONGF;

/**
 *
 * @author José Antonio Bravo Gonzalez
 */
@Named(value = "ModificarONG")
@SessionScoped
public class ModificarONG implements Serializable {

    @EJB
    private ONGF ongFacade;
    private ONG ong = new ONG();
    
    public List<ONG> findAll(){
        return this.ongFacade.findAll();
    }

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

    public String getContrasenia() {
        return this.ong.getContrasenia();
    }

    public String ListaONGs() {
        return "listaONGs.xhtml";
    }

    public String verONG(int id) {
        return "editarONG.xhtml";
    }

    public String anadir() {
        this.ongFacade.create(this.ong);
        this.ong = new ONG();
        return "anadirONG.xhtml";
    }

    public String editar() {
        this.ong = ong;
        return "editarONG.xhtml";
    }

    public void eliminar() {
        this.ongFacade.remove(ong);
    }

    public ModificarONG() {
    }
}
