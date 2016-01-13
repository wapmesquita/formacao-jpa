package br.com.dxt.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.dxt.services.EntityManagerFactoryWrapper;

public class ExecReadOnly {

	public static void main(String[] args) {
		EntityManagerFactory emf = EntityManagerFactoryWrapper.getEntityManagerFactory();
		EntityManager em1 = emf.createEntityManager();

		PessoaReadOnly p = new PessoaReadOnly();
		p.nome = "joao";

		System.out.println("->> persist pessoa");
		em1.getTransaction().begin();
		em1.persist(p);
		em1.getTransaction().commit();

		System.out.println("->> consulta pessoa");
		System.out.println(em1.find(PessoaReadOnly.class, p.id).nome);

		System.out.println("->> novo entity manager");
		EntityManager em2 = emf.createEntityManager();

		System.out.println("->> consulta pessoa com novo em");
		PessoaReadOnly pessoa = em2.find(PessoaReadOnly.class, p.id);
		System.out.println(pessoa.nome);

		System.out.println("->> atualiza pessoa");
		pessoa.nome = "mario";
		em2.getTransaction().begin();
		em2.merge(pessoa);
		em2.getTransaction().commit();
	}
}
