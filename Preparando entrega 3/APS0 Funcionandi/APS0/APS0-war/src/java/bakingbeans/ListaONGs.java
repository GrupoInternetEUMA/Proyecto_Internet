package bakingbeans;


import Entidades.ONG;
import ejb.ONGEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;


/**
 *
 * @author JosÃ© Antonio Bravo Gonzalez
 */
@Named(value = "ListaONGs")
@SessionScoped

public class ListaONGs implements Serializable {

   
    private ONG ong = new ONG();
    
    @Inject
    ONGEJB bbdd;
    @Inject
    ControlAutorizacion ctrl;
    

    public ListaONGs() {
        
    }

    public List<ONG> getONGs(){
        return this.bbdd.findAll();
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
        this.bbdd.create(this.ong);
        this.ong = new ONG();
        return "listaONGs.xhtml";
    }

    public String editar() {
        this.ong = ong;
        return "listaONGs.xhtml";
    }

    public void eliminar() {
        this.bbdd.remove(ong);
    }

    public String crearInforme() {
        return "anadirInforme.xhtml";
    }

}
