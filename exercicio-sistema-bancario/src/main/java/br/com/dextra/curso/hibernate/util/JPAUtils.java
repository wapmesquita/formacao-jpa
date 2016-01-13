package br.com.dextra.curso.hibernate.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class JPAUtils {

	public final static EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("hsql");
	}
}
