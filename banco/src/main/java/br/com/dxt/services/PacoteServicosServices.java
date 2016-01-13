package br.com.dxt.services;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dxt.domain.PacoteServicos;
import br.com.dxt.domain.Pessoa;

public class PacoteServicosServices extends AbstractService<PacoteServicos> {

	public PacoteServicosServices() {
		super(PacoteServicos.class);
	}

	public List<Pessoa> buscarPessoasPorPacote(String tipoPacote) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT p ");
		sb.append(" FROM " + Pessoa.class.getSimpleName() + " p ");
		sb.append(" INNER JOIN p.packServicos pack ");
		sb.append(" WHERE pack.tipo = :pacote ");

		TypedQuery<Pessoa> qry = getEm().createQuery(sb.toString(), Pessoa.class);
		qry.setParameter("pacote", tipoPacote);
		return qry.getResultList();
		
	}
}
