package negocio;


import Entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josea
 */
@Stateless
public class UsuariosEJBImpl implements UsuariosEJB{
    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;
   
    @Override         
    public List<Usuario> findAll(){
            Query query = em.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
    }
    
    @Override
    public void insertar(Usuario u){
        em.persist(u);
    }
    
    @Override
    public void editar(Usuario u){
        em.merge(u);
    }
    
    @Override
    public void borrar(Usuario u){
        em.remove(em.merge(u));
    }
}
