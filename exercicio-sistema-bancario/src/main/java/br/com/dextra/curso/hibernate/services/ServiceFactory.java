package br.com.dextra.curso.hibernate.services;

import br.com.dextra.curso.hibernate.services.impl.HibernateServicesImpl;

public final class ServiceFactory {

	private static HibernateServices hibernateServices = new HibernateServicesImpl();
	
	private ServiceFactory() {
	}

	public static HibernateServices getHibernateService() {
		return hibernateServices;
	}
}
