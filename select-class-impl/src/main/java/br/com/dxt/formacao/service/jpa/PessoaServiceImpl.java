package br.com.dxt.formacao.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.service.PessoaService;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class PessoaServiceImpl implements PessoaService {

	private static EntityManager em = EntityManagerFactoryWrapper
			.getEntityManager();

	@Override
	public Pessoa salvarPessoa(Pessoa p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

		return p;
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		TypedQuery<Pessoa> qry = em.createQuery(
				"from " + Pessoa.class.getSimpleName(), Pessoa.class);
		return qry.getResultList();
	}

	public Pessoa buscarPorId(Long id) {
		try {
			return em.find(Pessoa.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void excluir(Long id) {
		excluir(buscarPorId(id));
	}

	public void excluir(Pessoa p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}

	public List<Pessoa> buscarPessoaPorNome(String nome) {
		String sql = "FROM " + Pessoa.class.getSimpleName() + " p "
				+ "WHERE UPPER(p.name) LIKE UPPER(:paramName)";

		TypedQuery<Pessoa> qry = em.createQuery(sql, Pessoa.class);

		qry.setParameter("paramName", "%" + nome + "%");

		return qry.getResultList();
	}

	public Double getMediaIdade() {
		String sql = "SELECT AVG(p.age) media " + " FROM "
				+ Pessoa.class.getSimpleName() + " p ";

		TypedQuery<Double> qry = em.createQuery(sql, Double.class);

		return qry.getSingleResult();
	}

}
