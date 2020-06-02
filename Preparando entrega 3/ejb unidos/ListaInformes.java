package bakingbeans;

import Entidades.Usuario;
import Entidades.Actividad;
import Entidades.Informe;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import modelos.InformeF;

@Named(value = "ListaInformes")
@SessionScoped
public class ListaInformes implements Serializable {

    @EJB
    private InformeF informeFacade;
    private Informe informe = new Informe();
    private Actividad actividad;
    private Usuario usuario;
    private final ArrayList<Informe> informesid = new ArrayList<>();

    public ArrayList<Informe> getInformesid() {
        return informesid;
    }

    public ListaInformes() {
        
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

    public String anadir() {
        this.informeFacade.create(this.informe);
        this.informe = new Informe();
        return "anadirInforme.xhtml";
    }

    public String editar() {
        this.informe = informe;
        return "editarInforme.xhtml";
    }

    public void eliminar() {
        this.informeFacade.remove(informe);
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

}
