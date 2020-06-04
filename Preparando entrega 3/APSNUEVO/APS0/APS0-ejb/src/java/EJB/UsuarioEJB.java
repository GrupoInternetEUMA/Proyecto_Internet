/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author josea
 */
@Stateless
public class UsuarioEJB extends AbstractEJB<Usuario> {
    
    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioEJB() {
        super(Usuario.class);
    }
    
    public Usuario comprobarContrasenia(String usuario,String contrasenia){
       try{
           Query query = em.createQuery("Select u from Usuario u where u.contrasenia = :pass and u.usuario = :user");
           query.setParameter("pass",contrasenia);
        query.setParameter("user",usuario);
        return (Usuario) query.getSingleResult();
       }catch (Exception e){
           return null;
       }
        
    }
    
}
