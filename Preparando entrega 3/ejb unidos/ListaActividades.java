package bakingbeans;

import Entidades.Actividad;
import Entidades.Usuario;
import Entidades.Usuario.Rol;
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
import modelos.ActividadF;

@Named(value = "ListaActividades")
@SessionScoped
public class ListaActividades implements Serializable {

    private ActividadF actividadFacade;
    private Actividad actividad = new Actividad();
    private Usuario usuario;

    public ListaActividades(){
        
    }

    public Actividad getActividad() {
        return actividad;
    }
    
    public List<Actividad> findAll(){
        return this.actividadFacade.findAll();
    }


    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public String crearActividad() {
        return "anadirActividad.xhtml";
    }

    public String verActividad(int id) {
        return "verActividad.xhtml";
    }

    public String ListaActividades() {
        return "listaActividades.xhtml";
    }

    public String editarActividad(int id) {
        return "editarActividad.xhtml";
    }

    public String verParticipantes(int id) {
        return "listaParticipantesActividad.xhtml";
    }

    public String anadir() {
        this.actividadFacade.create(this.actividad);
        this.actividad = new Actividad();
        return "listaActividad.xhtml";
    }

    public String anadirParticipante() throws ParseException {  // Pasar parámetros del login
        // Implementar este método
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible añadir el participante, inténtelo más tarde", "No ha sido posible añadir el participante, inténtelo más tarde"));
        return null;
    }

    public String editar() {
        this.actividad = actividad;
        return "editarActividad.xhtml";
    }

    public void eliminar() {
        this.actividadFacade.remove(actividad);
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaActividades.xhtml";
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
