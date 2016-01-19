package br.com.dxt.formacao.service.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.service.AbstractServiceImpl;
import br.com.dxt.formacao.service.PessoaService;

public class PessoaServiceImpl extends
		AbstractServiceImpl<Pessoa>
		implements PessoaService {

	public PessoaServiceImpl() {
		super(Pessoa.class);
	}

	public List<Pessoa> buscarPessoaPorNome(
			String nome) {
		String sql = "FROM "
				+ Pessoa.class
						.getSimpleName()
				+ " p "
				+ "WHERE UPPER(p.name) LIKE UPPER(:paramName)";

		TypedQuery<Pessoa> qry = em
				.createQuery(sql,
						Pessoa.class);

		qry.setParameter("paramName",
				"%" + nome + "%");

		return qry.getResultList();
	}

	public Double getMediaIdade() {
		String sql = "SELECT AVG(p.age) media "
				+ " FROM "
				+ Pessoa.class
						.getSimpleName()
				+ " p ";

		TypedQuery<Double> qry = em
				.createQuery(sql,
						Double.class);

		return qry.getSingleResult();
	}

	@Override
	public Pessoa salvarPessoa(Pessoa p) {
		return salvar(p);
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		return buscarTodos();
	}

	public List<Pessoa> buscarPorDDD(String ddd) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT p ");
		sb.append(" FROM ");
		sb.append(Pessoa.class.getSimpleName());
		sb.append(" p ");
		sb.append(" INNER JOIN p.telefones t ");
		sb.append(" WHERE t.ddd = :ddd");

		TypedQuery<Pessoa> qry =
				em.createQuery(sb.toString(), Pessoa.class);
		qry.setParameter("ddd", ddd);
		return qry.getResultList();
	}

}
