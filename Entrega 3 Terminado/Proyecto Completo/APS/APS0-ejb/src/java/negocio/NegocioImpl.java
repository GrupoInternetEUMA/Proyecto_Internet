/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Entidades.Usuario;
import excepciones.APSException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francis
 */
@Stateless
public class NegocioImpl implements Negocio {

    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;

    @Override
    public void compruebaLogin(Usuario u) throws APSException {
        Usuario usu = em.find(Usuario.class, u.getUsuario());
     
        if (usu == null) {
            throw new APSException("No existe el Usuario");
        }

        if (!usu.getContrasenia().equals(u.getContrasenia())) {
            throw new APSException("Contraseña Incorrecta");
        }
    }

    @Override
    public Usuario refrescarUsuario(Usuario u) throws APSException {
        compruebaLogin(u);
        Usuario usu = em.find(Usuario.class, u.getUsuario());
        System.out.println(usu.toString());
        em.refresh(usu);
        return usu;    }

}
