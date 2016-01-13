package br.com.dxt.formacao.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryWrapper {

	private static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("hsql");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}

}
