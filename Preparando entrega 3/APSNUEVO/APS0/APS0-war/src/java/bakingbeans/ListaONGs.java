package bakingbeans;


import Entidades.ONG;
import Entidades.Usuario;
import Entidades.Usuario.Rol;
import ejb.ONGEJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


/**
 *
 * @author JosÃ© Antonio Bravo Gonzalez
 */
@Named(value = "ListaONGs")
@RequestScoped
public class ListaONGs implements Serializable {
    
    public String getONGC(){
        
      for(ONG ong : bbdd.findAll()){
           if(ong.getUsuario().equals(ctrl.getUsuario().getUsuario())){
               this.ong = ong;
               
           }
       } 
      return "misDatos.xhtml";
     }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ONG getOng() {
        return ong;
    }

    public void setOng(ONG ong) {
        this.ong = ong;
    }

    public ONGEJB getBbdd() {
        return bbdd;
    }

    public void setBbdd(ONGEJB bbdd) {
        this.bbdd = bbdd;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }

   private Usuario usuario;
    private ONG ong = new ONG();
    
    @Inject
    ONGEJB bbdd;
    @Inject
    ControlAutorizacion ctrl;
    

    public ListaONGs() {
        
    }

    public List<ONG> getONGs(){
        return this.bbdd.findAll();
    }

    public ONG getONG() {
        return ong;
    }

    public void setONG(ONG ong) {
        this.ong = ong;
    }
    
    

    public String getNombre() {
        return this.ong.getNombre();
    }

    public String getDescripcion() {
        return this.ong.getDescripcion();
    }

    public String getEmail() {
        return this.ong.getEmail();
    }

    public Integer getTelefono() {
        return this.ong.getTelefono();
    }

    public String getDireccion() {
        return this.ong.getDireccion();
    }

    public String getPais() {
        return this.ong.getPais();
    }

    public String getContrasenia() {
        return this.ong.getContrasenia();
    }

    public String ListaONGs() {
        return "listaONGs.xhtml";
    }

    public String verONG(ONG a) {
        this.ong = a;
        return "editarONG.xhtml";
    }

    public String anadir() {
       this.ong.setRol(Rol.ONG);
        this.bbdd.create(ong);
        this.ong = new ONG();
        return "listaONGs.xhtml";
    }
    public String crearONG() {
        return "anadirONG.xhtml";
    }

    public String editar() {
        
        bbdd.edit(this.ong);
        return "listaONGs.xhtml";
    }

    public void eliminar(ONG a) {
        bbdd.remove(a);
    }

    public String crearInforme() {
        return "anadirInforme.xhtml";
    }

}
