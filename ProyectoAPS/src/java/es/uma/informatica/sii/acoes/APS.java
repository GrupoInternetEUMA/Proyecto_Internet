package es.uma.informatica.sii.acoes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author
 */
public class APS {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("APSUP");
        EntityManager em = emf.createEntityManager();
        /*
        EntityTransaction tx = em.getTransaction();
        Ninos nino1 = new Ninos();
        nino1.setNombre("Pepe");
        nino1.setApellidos("Lopez");;
        tx.begin();
        em.persist(nino1);
        tx.commit();*/

        em.close();
        emf.close();
    }

}
