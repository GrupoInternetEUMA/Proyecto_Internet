/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import es.uma.informatica.sii.acoes.*;



/**
 *
 * @author Antonio
 */

@Named(value = "ListaInformes")
@SessionScoped
public class listaInformes implements Serializable {
    private final ArrayList<Informe> informes;
    private Actividad actividad;
    private Usuario usuario;
    private Informe informe;

    public listaInformes(){
        informes = new ArrayList<>();
        informes.add(new Informe(1,"Obtención de 5 créditos","180 horas","Curso de montaje de ordenador"));
        informes.add(new Informe(2,"Obtención de 1 créditos","30 horas","Tareas de mantenimiento de jardinería"));
        informes.add(new Informe(3,"Obtención de 2 créditos","50 horas","Informes de alumno ERASMUS"));
        informes.add(new Informe(4,"Obtención de 6 créditos","200 horas","Investigación en laboratorio"));
        informe = new Informe();
    }
    public ArrayList<Informe> getInformes(){
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

    public String crearInforme(){
        return "insertarInforme.xhtml";
    }

}