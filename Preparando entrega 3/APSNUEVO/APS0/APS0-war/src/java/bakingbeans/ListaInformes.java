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
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaInformes")
@RequestScoped
public class ListaInformes implements Serializable {

    
    @Inject
    private InformeEJB bbdd;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    private ArrayList<Informe> informes;
    private Actividad actividad;
    private Usuario usuario;
    private Informe informe = new Informe();
    private Actividad actividad_inf;
    
    

    public ListaInformes() {
        informes = new ArrayList<>();
       
    }

    
    public List<Informe> getInformes() {
        return bbdd.findAll();
    }
    public List<Informe> getInformesA(){
        return informes;
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

    public String verInforme(Informe i) {
        return "verInforme.xhtml";
    }

    public String verInformes(Actividad actividad) {
        /*informes.clear();
        informes.add(new Informe(1, "Obtención de 5 créditos", "180 horas", "Curso de montaje de ordenador"));*/
        actividad_inf = new Actividad();
        actividad_inf = actividad;
        informes = new ArrayList<>();
        for(Informe inf : bbdd.findAll()){
          if(inf.getActividad().getId().equals(actividad.getId())){
               informes.add(inf);
          }
        }
        
        return "verInformesId.xhtml";
    }

    public Actividad getActividad_inf() {
        return actividad_inf;
    }

    public void setActividad_inf(Actividad actividad_inf) {
        this.actividad_inf = actividad_inf;
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

    public String editarInforme(Informe i) {
        informe = i;
        return "editarInforme.xhtml";
    }

    public String anadir(){  // Pasar parámetros del login
       this.bbdd.create(this.informe);
       this.informe = new Informe();
       return "listaInformes.xhtml";
    }

    public String editar(){  // Pasar parámetros del login
        bbdd.edit(this.informe);
        return "verInformesId.xhtml";
    }

    public void eliminar(Informe i){  // Pasar parámetros del login
        bbdd.remove(i);
    }

    public InformeEJB getBbdd() {
        return bbdd;
    }

    public void setBbdd(InformeEJB bbdd) {
        this.bbdd = bbdd;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
}
