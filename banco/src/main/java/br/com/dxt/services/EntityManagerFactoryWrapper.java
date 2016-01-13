package br.com.dxt.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryWrapper {

	private static final EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("hsql");
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		if (em == null || !em.isOpen()) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public static void close() {
		emf.close();
	}
	
}
