package br.com.dxt.formacao.app;

import javax.persistence.EntityManager;

import br.com.dxt.formacao.domain.Funcionario;
import br.com.dxt.formacao.domain.PessoaFisica;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class LifeCycle {

	public static void main(
			String[] args) {
		EntityManager em = EntityManagerFactoryWrapper
				.getEntityManagerFactory()
				.createEntityManager();

		PessoaFisica pessoaTransient = new Funcionario();
		pessoaTransient.cpf = "cpf";
		pessoaTransient.name = "PessoaFisica";

		em.getTransaction().begin();
		em.persist(pessoaTransient);
		em.getTransaction().commit();
		System.out
				.println(pessoaTransient.id);

		PessoaFisica pessoaDetached = new Funcionario();
		pessoaDetached.id = 1L;
		pessoaDetached.cpf = "rg";
		pessoaDetached.name = "aaa";

		em.getTransaction().begin();
		pessoaDetached = em
				.merge(pessoaDetached);
		em.getTransaction().commit();

		em.close();

		// todas as instancias passam a ser detached

		em = EntityManagerFactoryWrapper
				.getEntityManagerFactory()
				.createEntityManager();
		// em.remove(pessoaDetached);

		PessoaFisica pessoa = em.find(
				PessoaFisica.class, 1L); // gerenciado

		em.getTransaction().begin();
		em.remove(pessoa); // removed
		em.getTransaction().commit();
	}

}
