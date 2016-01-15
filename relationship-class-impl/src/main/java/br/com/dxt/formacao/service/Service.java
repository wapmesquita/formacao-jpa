package br.com.dxt.formacao.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.dxt.formacao.domain.AbstractEntity;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class Service<T extends AbstractEntity> implements AbstractService<T> {

	private Class<T> clazz;

	public Service(Class<T> clazz) {
		this.clazz = clazz;
	}

	protected EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

	@Override
	public T buscarPorId(Object id) {
		try {
			return em.find(clazz, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<T> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> buscarPorFiltroSimplesIgual(String field, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T salvar(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(T entity) {
		// TODO Auto-generated method stub

	}
}
