package br.com.dextra.curso.hibernate.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.dextra.curso.hibernate.entity.ContaBancaria;
import br.com.dextra.curso.hibernate.entity.Pessoa;
import br.com.dextra.curso.hibernate.entity.PessoaFisica;
import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.util.JPAUtils;

public class HibernateServicesImpl implements HibernateServices {

	@Override
	public <T> T salvar(T instance) {
		EntityManager em = JPAUtils.emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();

			instance = em.merge(instance);

			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			throw e;

		} finally {
			em.close();
		}

		return instance;
	}
	
	@Override
	public <T> T buscar(Class<T> clazz, Long id) {
		EntityManager em = JPAUtils.emf.createEntityManager();
		try {
			return em.find(clazz, id);
		} finally {
			em.close();
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> List<T> buscarTodos(Class<T> clazz) {
		EntityManager em = JPAUtils.emf.createEntityManager();
		try {
			StringBuffer hql = new StringBuffer();
			hql.append("from " + clazz.getSimpleName() + " venda");
			hql.append(" where 1 = 1");
			return em.createQuery(hql.toString()).getResultList();
		} finally {
			em.close();
		}
	}
	
	@Override
	public Pessoa salvarPessoa(Pessoa pessoa, ContaBancaria conta) {
		// Implemente o metodo
		return null;
	}
	
	@Override
	public void realizarTransacao(PessoaFisica pessoaA, PessoaFisica pessoaB, Double valor) {
		// Implemente o metodo
		
	}
}
