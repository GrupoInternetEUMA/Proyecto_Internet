package bakingbeans;

import Entidades.Usuario;
import Entidades.Responsable_actividad;
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
import modelos.ResponsableF;

@Named(value = "ModificarResponsable")
@SessionScoped
public class ModificarResponsable implements Serializable {

    @EJB
    private ResponsableF responsableFacade;
    private Responsable_actividad responsable = new Responsable_actividad();
    
    public List<Responsable_actividad> findAll(){
        return this.responsableFacade.findAll();
    }

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

    public String ListaResponsables() {
        return "listaResponsables.xhtml";
    }

    public String verResponsable(int id) {
        return "editarResponsable.xhtml";
    }

     public String anadir() {
        this.responsableFacade.create(this.responsable);
        this.responsable = new Responsable_actividad();
        return "anadirResponsable.xhtml";
    }

    public String editar() {
        this.responsable = responsable;
        return "editarResponsable.xhtml";
    }

    public void eliminar() {
        this.responsableFacade.remove(responsable);
    }

    public ModificarResponsable() {
    }
}
