package jsf;

import jpa.Usuario;
import jpa.Actividad;
import jpa.Informe;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "ListaInformes")
@SessionScoped
public class ListaInformes implements Serializable {

    private final ArrayList<Informe> informes;
    private Actividad actividad;
    private Usuario usuario;
    private Informe informe;
    private final ArrayList<Informe> informesid = new ArrayList<>();

    public ArrayList<Informe> getInformesid() {
        return informesid;
    }

    public ListaInformes() {
        informes = new ArrayList<>();
        informes.add(new Informe(1, "Obtención de 5 créditos", "180 horas", "Curso de montaje de ordenador"));
        informes.add(new Informe(2, "Obtención de 1 créditos", "30 horas", "Tareas de mantenimiento de jardinería"));
        informes.add(new Informe(3, "Obtención de 2 créditos", "50 horas", "Informes de alumno ERASMUS"));
        informes.add(new Informe(4, "Obtención de 6 créditos", "200 horas", "Investigación en laboratorio"));
        informe = new Informe();
    }

    public ArrayList<Informe> getInformes() {
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
