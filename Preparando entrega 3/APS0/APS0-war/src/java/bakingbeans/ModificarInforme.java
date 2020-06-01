package bakingbeans;

import Entidades.Informe;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelos.InformeF;

@Named(value = "ModificarInforme")
@SessionScoped
public class ModificarInforme implements Serializable {

    @EJB
    private InformeF informeFacade;
    private Informe informe = new Informe();

    public Informe getInforme() {
        return informe;
    }
    
    public List<Informe> findAll(){
        return this.informeFacade.findAll();
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

    public ModificarInforme() {
    }
}
