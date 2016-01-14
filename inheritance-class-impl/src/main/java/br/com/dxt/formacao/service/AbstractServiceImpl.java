package br.com.dxt.formacao.service;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.AbstractEntity;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {

	private Class<T> clazz;
	protected EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

	public AbstractServiceImpl(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	protected EntityManager getEm() {
		return this.em ;
	}

	public T buscarPorId(Object id) {
		return getEm().find(clazz, id);
	}

	public List<T> buscarTodos() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("FROM ");
		stringBuilder.append(clazz.getSimpleName());
		stringBuilder.append(" t");
		String jpql = stringBuilder.toString();
		TypedQuery<T> qry = getEm().createQuery(jpql, clazz);
		try {
			return qry.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	public List<T> buscarPorFiltroSimplesIgual(String field, Object value) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("FROM ");
		stringBuilder.append(clazz.getSimpleName());
		stringBuilder.append(" t WHERE t.");
		stringBuilder.append(field);
		stringBuilder.append(" = :value");
		String jpql = stringBuilder.toString();
		TypedQuery<T> qry = getEm().createQuery(jpql, clazz);
		qry.setParameter("value", value);
		try {
			return qry.getResultList();
		} catch (NoResultException e) {
			return Collections.emptyList();
		}
	}

	public T salvar(T entity) {
		EntityManager em = getEm();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		if (entity.id == null) {
			em.persist(entity);
		} else {
			entity = em.merge(entity);
		}
		transaction.commit();
		return entity;
	}

	public void remove(T entity) {
		EntityManager em = getEm();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(entity);
		transaction.commit();
	}
}