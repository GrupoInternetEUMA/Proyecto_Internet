package jpa;

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

        em.close();
        emf.close();
    }

}
