package bakingbeans;

import Entidades.Actividad;
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
import Entidades.Usuario;
import javax.ejb.EJB;
import modelos.ActividadF;

@Named(value = "ModificarActividad")
@SessionScoped
public class ModificarActividad implements Serializable {

    @EJB
    private ActividadF actividadFacade;
    private Actividad actividad = new Actividad();

    private ArrayList<Usuario> participantes;

    public void listaParticipantes() {
        participantes = new ArrayList<>();
        participantes.add(new Usuario( 782536, "Jorge", "Javier Vazquez", "Presentador", "Castelano", new Date(1997, 2, 28), "jorjevzquez@gmail.com", "ContraQWER", null, "JorVaz"));
        participantes.add(new Usuario( 782536, "Mariko", "Kaga", "Alquimista", "Japones", new Date(1997, 2, 28), "japonitoSabroso@gmail.com", "ContraQWER", null, "elJapo"));

    }
    
    public List<Actividad> findAll(){
        return this.actividadFacade.findAll();
    }

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
        return "anadirActividad.xhtml";
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

    public ModificarActividad() {
    }
}
