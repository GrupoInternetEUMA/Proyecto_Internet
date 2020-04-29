package jsf;

import jpa.Informe;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;




@Named(value = "ModificarInforme")
@SessionScoped
public class ModificarInforme implements Serializable {

    private Informe informe;

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

    public String verInforme(int id) {
        return "editarInforme.xhtml";
    }

    public ModificarInforme() {
    }
}
