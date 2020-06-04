package bakingbeans;

import Entidades.Actividad;
import Entidades.Informe;
import Entidades.Usuario;
import Entidades.Usuario.Rol;
import ejb.ActividadEJB;
import ejb.ONGEJB;
import ejb.ResponsableEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


@Named(value = "ListaActividades")
@RequestScoped
public class ListaActividades implements Serializable {

    
    private Actividad actividad = new Actividad();
    private Usuario usuario;
    
    @Inject
    ActividadEJB bbdd;
    @Inject
    ResponsableEJB bbddr;
    @Inject
    ControlAutorizacion ctrl;
    
    protected String o =new String();
    protected String r = new String();
    @Inject
    ONGEJB bbddo;
    
    public ListaActividades(){
        
    }
    
    public Actividad ActividadBack(Informe i){
        
        Actividad ac = null;
        
        for(Actividad act : getActividades()){    
            
            if(act.getId().equals(i.getActividad())){
                
                ac = act;
            }
        }
        return ac;
    }
    
    public Actividad getActividad() {
        return actividad;
    }
    
    public List<Actividad> getActividades(){
        return this.bbdd.findAll();
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
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

    public String verActividad(Actividad a) {
        actividad = a;
        return "verActividad.xhtml";
    }

    public String ListaActividades() {
        return "listaActividades.xhtml";
    }

    public String editarActividad(Actividad a) {
        actividad = a;
        return "editarActividad.xhtml";
    }

    public String verParticipantes(int id) {
        return "listaParticipantesActividad.xhtml";
    }

    public String anadir() {
        actividad.setOng(bbddo.find(o));
        actividad.setResponsable_actividad(bbddr.find(r));
        this.bbdd.create(this.actividad);
        this.actividad = new Actividad();
        return "listaActividades.xhtml";
    }

    public String anadirParticipante() throws ParseException {  // Pasar parÃ¡metros del login
        // Implementar este mÃ©todo
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha sido posible aÃ±adir el participante, intÃ©ntelo mÃ¡s tarde", "No ha sido posible aÃ±adir el participante, intÃ©ntelo mÃ¡s tarde"));
        return null;
    }

    public String editar() {
        bbdd.edit(this.actividad);
        return "listaActividades.xhtml";
    }

    public void eliminar(Actividad a) {
        bbdd.remove(a);
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
        // Si el usuario es Alumno, le llevarÃ¡ a la pÃ¡gina web de INDEX
        // REVISAR
        if (getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "login.xhtml";
        }
        return null;
    }

    public String logout() {
        // Destruye la sesiÃ³n (y con ello, el Ã¡mbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
    
}
