package br.com.dxt.services;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dxt.domain.Agencia;
import br.com.dxt.domain.Pessoa;

public class AgenciaService extends AbstractService<Agencia> {

	public AgenciaService() {
		super(Agencia.class);
	}

	public List<Pessoa> buscarClientesPorAgencia(Long id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" FROM " + Pessoa.class.getSimpleName() + " p ");
		sb.append(" WHERE p.agencia.id = :id ");

		TypedQuery<Pessoa> qry = getEm().createQuery(sb.toString(), Pessoa.class);
		qry.setParameter("id", id);
		return qry.getResultList();
	}
}
