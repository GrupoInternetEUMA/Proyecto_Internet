/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Solicitud_Actividad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josea
 */
@Stateless
public class SolicitudEJB extends AbstractEJB<Solicitud_Actividad>{
    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudEJB() {
        super(Solicitud_Actividad.class);
    }
}
