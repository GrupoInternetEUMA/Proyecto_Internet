/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import Entidades.Alumno;
import Entidades.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josea
 */
@Stateless
public class AlumnoEJB extends AbstractEJB<Alumno> {
    @PersistenceContext(unitName = "APS0-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoEJB() {
        super(Alumno.class);
    }
    
}