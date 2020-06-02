package bakingbeans;

import Entidades.Usuario;
import Entidades.Actividad;
import Entidades.Informe;
import ejb.InformeEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaInformes")
@RequestScoped
public class ListaInformes implements Serializable {

    
    @Inject
    InformeEJB bbdd;
    //private final ArrayList<Informe> informes;
    private Actividad actividad;
    private Usuario usuario;
    private Informe informe;
    private final ArrayList<Informe> informesid = new ArrayList<>();

    public ArrayList<Informe> getInformesid() {
        return informesid;
    }

    /*public ListaInformes() {
        informes = new ArrayList<>();
        informes.add(new Informe(1, "Obtención de 5 créditos", "180 horas", "Curso de montaje de ordenador"));
        informes.add(new Informe(2, "Obtención de 1 créditos", "30 horas", "Tareas de mantenimiento de jardinería"));
        informes.add(new Informe(3, "Obtención de 2 créditos", "50 horas", "Informes de alumno ERASMUS"));
        informes.add(new Informe(4, "Obtención de 6 créditos", "200 horas", "Investigación en laboratorio"));
        informe = new Informe();
    }*/

    public List<Informe> getInformes() {
        return bbdd.findAll();
    }

    public Actividad getActividad() {
        return actividad;
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

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public String crearInforme() {
        return "anadirInforme.xhtml";
    }

    public String verInforme(int id) {
        return "verInforme.xhtml";
    }

    public String verInformes(Actividad actividad) {
        informesid.clear();
        informesid.add(new Informe(1, "Obtención de 5 créditos", "180 horas", "Curso de montaje de ordenador"));
        /*for(Informe inf : informes){
          if(inf.getActividad().equals(actividad)){
               informesid.add(inf);
          }
        }*/
        return "verInformesId.xhtml";
    }
    
    public Integer getId() {
        return this.informe.getId();
    }

    public String getEvaluacion() {
        return this.informe.getEvaluacion();
    }

    public String getTiempo_empleado() {
        return this.informe.getTiempo_empleado();
    }

    public String getTareas_realizadas() {
        return this.informe.getTareas_realizadas();
    }

    public String ListaInformes() {
        return "listaInformes.xhtml";
    }

    public String editarInforme(int id) {
        return "editarInforme.xhtml";
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
}
