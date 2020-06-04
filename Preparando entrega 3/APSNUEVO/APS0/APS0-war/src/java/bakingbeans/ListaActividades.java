package bakingbeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Entidades.Actividad;
import Entidades.Informe;
import Entidades.Solicitud_Actividad;
import Entidades.Usuario;
import Entidades.Usuario.Rol;
import ejb.ActividadEJB;
import ejb.ONGEJB;
import ejb.ResponsableEJB;
import ejb.SolicitudEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javafx.scene.input.DataFormat;
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
    @Inject
    SolicitudEJB bbdds;
    
    protected String o =new String();
    protected String r = new String();
    @Inject
    ONGEJB bbddo;
    Date d;
    
    public ListaActividades(){
        
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
    
    public static String getFechaActual() {
    Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
    return formateador.format(ahora);
    }
    
    public String Apuntarse(Actividad a){
        Date d = new Date();
        Random r = new Random(40000);
        bbdds.create(new Solicitud_Actividad(r.nextInt(),"Solicitada",new Date(d.getYear(),d.getMonth(),d.getDay()),a,ctrl.getUsuario()));
        return "listaActividades.xhtml";
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
        actividad = new Actividad();
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

    public String verParticipantes(Actividad a) {
        return "listaParticipantesActividad.xhtml";
    }

    public String anadir() {
        actividad.setOng(bbddo.find(o));
        actividad.setResponsable_actividad(bbddr.find(r));
        this.bbdd.create(this.actividad);
        this.actividad = new Actividad();
        return "listaActividades.xhtml";
    }
    
    /*
    public String anadirParticipante(){ 
        
    }
    */

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
