package br.com.dxt.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.Pessoa;
import br.com.dxt.domain.PessoaFisica;
import br.com.dxt.domain.UF;

public class PessoaFisicaService extends AbstractService<PessoaFisica> {

	public PessoaFisicaService() {
		super(PessoaFisica.class);
	}

	public List<PessoaFisica> buscarPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<PessoaFisica> query = em.createQuery("FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome", PessoaFisica.class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		return query.getResultList();
	}

	public List<Object[]> buscarArrayPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<Object[]> query = em.createQuery("SELECT p.nome, p.id FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome", Object[].class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		return query.getResultList();
	}

	public List<String> buscarNomesPorNome(String nome) {
		EntityManager em = getEm();

		TypedQuery<String> query = em.createQuery("SELECT p.nome FROM PessoaFisica p WHERE lower(p.nome) LIKE :paramNome", String.class);

		if (nome.indexOf('%') == -1) {
			nome = "%" + nome + "%";
		}

		query.setParameter("paramNome", nome.toLowerCase());

		return query.getResultList();
	}

	public List<PessoaFisica> buscarPorEstado(UF estado) {
		StringBuilder sb = new StringBuilder();
		sb.append(" FROM " + PessoaFisica.class.getSimpleName() + " p ");
		sb.append(" WHERE p.endereco.estado = :estado ");

		TypedQuery<PessoaFisica> qry = getEm().createQuery(sb.toString(), PessoaFisica.class);
		qry.setParameter("estado", estado);
		return qry.getResultList();
	}
	
	public List<PessoaFisica> buscarPorDdd(String ddd) {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT p ");
		sb.append(" FROM ").append(PessoaFisica.class.getSimpleName()).append(" p ");
		sb.append(" INNER JOIN p.telefones t ");
		sb.append(" WHERE t.ddd = :ddd ");
		System.out.println(sb.toString());

		TypedQuery<PessoaFisica> qry = getEm().createQuery(sb.toString(), PessoaFisica.class);
		qry.setParameter("ddd", ddd);
		return qry.getResultList();
	} 
	
	public List<Pessoa> buscarPessoasComInvestimentos() {
		String jpql = "SELECT p FROM Pessoa p "
			+ "JOIN FETCH p.investimentos i ORDER BY p.nome";
		TypedQuery<Pessoa> qry = getEm().createQuery(jpql, Pessoa.class);
		return qry.getResultList();
	}

}
