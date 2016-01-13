package br.com.dxt.formacao.service;

import java.util.List;

import br.com.dxt.formacao.domain.AbstractEntity;

public interface AbstractService<T> {

	public abstract T buscarPorId(Object id);

	public abstract List<T> buscarTodos();

	public abstract List<T> buscarPorFiltroSimplesIgual(String field,
			Object value);

	public abstract <E extends AbstractEntity> E salvar(E entity);

	public abstract <E extends AbstractEntity> E remove(E entity);

}