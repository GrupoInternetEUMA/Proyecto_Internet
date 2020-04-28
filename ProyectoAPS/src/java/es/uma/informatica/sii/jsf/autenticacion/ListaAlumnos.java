/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.jsf.autenticacion;

import es.uma.informatica.sii.acoes.Usuario;
import es.uma.informatica.sii.acoes.Alumno;

import  es.uma.informatica.sii.acoes.Usuario.Rol;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;


/**
 *
 * @author Enriquito
 */

@Named(value = "ListaAlumnos")
@SessionScoped
public class ListaAlumnos implements Serializable{
    
    private ArrayList<Alumno> alumnos;
    private Usuario usuario;
    private Alumno alumno;
    
    public ListaAlumnos() {
        alumnos = new ArrayList<>();
        
        alumnos.add(new Alumno(000001, 12345678, "David", "El Gnomo", null, "Castellano", new Date(1997, 2, 28), "prueba@uma.es", "1234", Rol.ALUMNO,"DavidGnomo", "Ing Informatica", 1231234));
        alumnos.add(new Alumno(000002, 12312312, "Anastasia", "Sanches Cotrina", "Psicologia", "Castellano, Ingles", new Date(1998, 11, 3), "La_Anastasita_xula@uma.es", "twerk", Rol.ALUMNO,"AnaSans", "Universidad de la calle", 1234729));
    }
    
    
    
     public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     
     public Usuario getUsuario() {
        return usuario;
    } 
     
    public ArrayList<Alumno> getAlumnos(){
        return alumnos;
    }
    
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    public Alumno getAlumno() {
        return alumno;
    }
    
    public String crearAlumno(){
        return "anadirAlumno.xhtml";
    }
    
    
    public String home() {
        
        // Si no ha iniciado sesion, le lleva al login
        if(getUsuario()==null){
            return "login.xhtml";
        }
        
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if(getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)){
            return "ListaAlumnos.xhtml";
        }
        
        // Si el usuario es SOCIO, le llevará a la página web de INDEX
        // REVISAR
        if(getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)){
            return "login.xhtml";
        }
        
        return null;
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
}
