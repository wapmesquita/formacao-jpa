package br.com.dxt.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dxt.services.EntityManagerFactoryWrapper;

public class ExecReadWrite {

	public static void main(String[] args) {
		EntityManagerFactory emf = EntityManagerFactoryWrapper.getEntityManagerFactory();
		EntityManager em1 = emf.createEntityManager();

		PessoaReadWrite p = new PessoaReadWrite();
		p.nome = "joao";

		System.out.println("->> persist pessoa");
		em1.getTransaction().begin();
		em1.persist(p);
		em1.getTransaction().commit();

		System.out.println("->> consulta pessoa");
		System.out.println(em1.find(PessoaReadWrite.class, p.id).nome);

		System.out.println("->> novo entity manager");
		EntityManager em2 = emf.createEntityManager();

		System.out.println("->> consulta pessoa com segundo em");
		PessoaReadWrite pessoa = em2.find(PessoaReadWrite.class, p.id);
		System.out.println(pessoa.nome);

		System.out.println("->> consulta pessoa com terceiro em");
		EntityManager em3 = emf.createEntityManager();
		PessoaReadWrite p3 = em3.find(PessoaReadWrite.class, p.id);
		System.out.println(p3.nome);

		emf = Persistence.createEntityManagerFactory("hsql");
		EntityManager em4 = emf.createEntityManager();
		System.out.println("->> consulta pessoa com quarto em");
		System.out.println(em4.find(PessoaReadWrite.class, p.id).nome);

		System.out.println("->> atualiza pessoa");
		pessoa.nome = "mario";
		em2.getTransaction().begin();
		em2.merge(pessoa);
		em2.getTransaction().commit();

		System.out.println("->> consulta pessoa com quarto em");
		System.out.println(em4.find(PessoaReadWrite.class, p.id).nome);

	}
}
