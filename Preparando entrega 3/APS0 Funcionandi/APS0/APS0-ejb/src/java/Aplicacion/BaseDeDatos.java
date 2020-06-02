/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import Entidades.Alumno;
import Entidades.Usuario;
import Entidades.Usuario.Rol;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Antonio
 */
@Stateless
public class BaseDeDatos implements BaseDeDatosLocal {
    
    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;
    
  public List<Alumno> getAlumnos(){
      ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
      alumnos.add(new Alumno( 12345678, "David", "El Gnomo", null, "Castellano", new Date(1997, 2, 28), "prueba@uma.es", "1234", Rol.ALUMNO, "DavidGnomo", "Ing Informatica", 1231234));
      alumnos.add(new Alumno( 12312312, "Anastasia", "Sanches Cotrina", "Psicologia", "Castellano, Ingles", new Date(1998, 11, 3), "La_Anastasita_xula@uma.es", "twerk", Rol.ALUMNO, "AnaSans", "Universidad de la calle", 1234729));
      em.persist(new Alumno( 12345678, "David", "El Gnomo", null, "Castellano", new Date(1997, 2, 28), "prueba@uma.es", "1234", Rol.ALUMNO, "DavidGnomo", "Ing Informatica", 1231234));
      //crea alumnos
      return alumnos;
  }
  
  public List<Alumno> getAlumnos1(){
      
      Query query = em.createQuery("Select a from Alumno a");
      return query.getResultList();
  }
  
  public void crearUsario(Usuario u) {
      em.persist(u);
  }
  
  public void editarUsario(Usuario u) {
      em.persist(em.merge(u));
  }
  
  public void borrarUsario(Usuario u) {
      em.remove(u);
  }
}
