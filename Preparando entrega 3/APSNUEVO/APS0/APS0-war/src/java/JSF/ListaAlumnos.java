package JSF;


import Entidades.Usuario;
import Entidades.Alumno;
import Entidades.Usuario.Rol;
import ejb.AlumnoEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ListaAlumnos")
@RequestScoped
public class ListaAlumnos implements Serializable {

    //private ArrayList<Alumno> alumnos;
   
    private Usuario usuario;
   
    private Alumno alumno = new Alumno();
    @Inject
    AlumnoEJB bbdd;
    
    @Inject
    ControlAutorizacion ctrl;
    
    public ListaAlumnos() {
        
    }
    

    /*public ListaAlumnos() {
        alumnos = new ArrayList<>();
        
        alumnos.add(new Alumno( 12345678, "David", "El Gnomo", null, "Castellano", new Date(1997, 2, 28), "prueba@uma.es", "1234", Rol.ALUMNO, "DavidGnomo", "Ing Informatica", 1231234));
        alumnos.add(new Alumno( 12312312, "Anastasia", "Sanches Cotrina", "Psicologia", "Castellano, Ingles", new Date(1998, 11, 3), "La_Anastasita_xula@uma.es", "twerk", Rol.ALUMNO, "AnaSans", "Universidad de la calle", 1234729));
        //alumnos = (ArrayList<Alumno>) BaseDeDatos.getAlumnos1();
    }*/
    
    public List<Alumno> getAlumnos() {
        return bbdd.findAll();
    }
    
    public String getAlumnoC(){
        
      for(Alumno alu : bbdd.findAll()){
           if(alu.getUsuario().equals(ctrl.getUsuario().getUsuario())){
               alumno = alu;
            }
       } 
      return "misDatos.xhtml";
     }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String crearAlumno() {
        return "anadirAlumno.xhtml";
    }

    public String home() {
        // Si no ha iniciado sesion, le lleva al login
        if (getUsuario() == null) {
            return "login.xhtml";
        }
        // Si el usuario es un ADMINISTRADOR, le lleva a la pagina a la lista de Alumnos
        if (getUsuario().getRol().equals(getUsuario().getRol().ADMINISTRADOR)) {
            return "ListaAlumnos.xhtml";
        }
        // Si el usuario es Alumno, le llevará a la página web de INDEX
        // REVISAR
        if (getUsuario().getRol().equals(getUsuario().getRol().ALUMNO)) {
            return "login.xhtml";
        }
        return null;
    }

    public String logout() {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }
    
       

    public String getTitulacion() {
        return this.alumno.getTitulacion();
    }

    public Integer getNum_expediente() {
        return this.alumno.getNum_expediente();
    }

    public Integer getDni() {
        return this.alumno.getDni();
    }

    public String getNombre() {
        return this.alumno.getNombre();
    }

    public String getApellidos() {
        return this.alumno.getApellidos();
    }

    public String getEstudios() {
        return this.alumno.getEstudios();
    }

    public String getIdioma() {
        return this.alumno.getIdioma();
    }

    public Date getFecha_nacimiento() {
        return this.alumno.getFecha_nacimiento();
    }

    public String getEmail() {
        return this.alumno.getEmail();
    }

    public String getContrasenia() {
        return this.alumno.getContrasenia();
    }

    public Rol getRol() {
        return this.alumno.getRol();
    }

    public String ListaAlumnos() {
        return "listaAlumnos.xhtml";
    }

    public String verAlumno(Alumno a) {
        alumno = a;
        return "editarAlumno.xhtml";
    }
    
    public String editar(){
        bbdd.edit(alumno);
        return "listaAlumnos.xhtml";
    }
    
    public void eliminar(Alumno a){
        bbdd.remove(a);
        
    }
    
    public String anadir(){
        alumno.setRol(Rol.ALUMNO);
        this.bbdd.create(alumno);
        this.alumno = new Alumno();
        return "listaAlumnos.xhtml";
       
    }
}
