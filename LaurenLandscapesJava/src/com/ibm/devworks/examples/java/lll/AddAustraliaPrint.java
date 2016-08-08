package com.ibm.devworks.examples.java.lll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class AddAustraliaPrint {
	private static final String PERSISTENCE_UNIT = "LaurenLandscapesJava";
	private static EntityManagerFactory factory;
	public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	    EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		List<Print> prints = em.createQuery("SELECT p FROM Print p ORDER BY p.id").getResultList();
		
		for(Print print : prints ) {
			if (print.getTitle().equals("Australia")) {
				print.setQuan(3);
				em.persist(print);
				break;
			}		
		}
		
		em.getTransaction().commit();
		em.close();

	}

}
