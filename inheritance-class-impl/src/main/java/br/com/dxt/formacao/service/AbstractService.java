package br.com.dxt.formacao.service;

import java.util.List;

import br.com.dxt.formacao.domain.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {

	public abstract T buscarPorId(Object id);

	public abstract List<T> buscarTodos();

	public abstract List<T> buscarPorFiltroSimplesIgual(String field,
			Object value);

	public abstract T salvar(T entity);

	public abstract void remove(T entity);

}