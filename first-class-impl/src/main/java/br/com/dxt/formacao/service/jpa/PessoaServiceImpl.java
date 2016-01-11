package br.com.dxt.formacao.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.service.PessoaService;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class PessoaServiceImpl implements PessoaService {

	@Override
	public Pessoa salvarPessoa(Pessoa p) {
		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

		return p;
	}

	@Override
	public List<Pessoa> buscarTodasPessoas() {
		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

		TypedQuery<Pessoa> qry =
				em.createQuery("from Pessoa",
						Pessoa.class);
		return qry.getResultList();
	}

}
