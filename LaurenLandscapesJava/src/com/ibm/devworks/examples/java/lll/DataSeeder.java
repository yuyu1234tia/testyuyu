package com.ibm.devworks.examples.java.lll;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.eclipse.persistence.config.PersistenceUnitProperties;


public class DataSeeder {
	private static final String PERSISTENCE_UNIT = "LaurenLandscapesJava";
	private static EntityManagerFactory factory;
	public static void main(String[] args) {
		
		
	    Map<String, String> propertiesMap = new HashMap<String, String>();

	    propertiesMap.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.DROP_AND_CREATE);
	    propertiesMap.put(PersistenceUnitProperties.DDL_GENERATION_MODE, PersistenceUnitProperties.DDL_BOTH_GENERATION); 
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, propertiesMap);
	    EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Print print = new Print();
		print.setDescription("Lauren's husband took this spectacular photo when they visited Antarctica in December of 2012. This is one of our hot sellers, so it rarely goes on sale.");
		print.setTitle("Antarctica");
		print.setImgsrc("penguin.jpg");
		print.setPrice(100);
		print.setQuan(6);
		em.persist(print);
		
		print = new Print();
		print.setDescription("Lauren loves this photo even though she wasn't present when the photo was taken. Her husband took this photo on a guy's weekend in Alaska.");
		print.setTitle("Alaska");
		print.setImgsrc("alaska.jpg");
		print.setPrice(75);
		print.setQuan(1);
		em.persist(print);

		print = new Print();
		print.setDescription("This photo is another one of Lauren's favorites! Her husband took these photos of the Sydney Opera House in 2011.");
		print.setTitle("Australia");
		print.setImgsrc("sydney.jpg");
		print.setPrice(100);
		print.setQuan(0);
		em.persist(print);

		
		em.getTransaction().commit();
		em.close();

	}

}
