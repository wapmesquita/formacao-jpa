package br.com.dxt.cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.dxt.services.EntityManagerFactoryWrapper;

public class ExecNRW {

	public static void main(String[] args) {
		EntityManagerFactory emf = EntityManagerFactoryWrapper.getEntityManagerFactory();
		EntityManager em1 = emf.createEntityManager();

		PessoaNRW p = new PessoaNRW();
		p.nome = "joao";

		System.out.println("->> persist pessoa");
		em1.getTransaction().begin();
		em1.persist(p);
		em1.getTransaction().commit();

		System.out.println("->> consulta pessoa");
		System.out.println(em1.find(PessoaNRW.class, p.id).nome);

		System.out.println("->> novo entity manager");
		EntityManager em2 = emf.createEntityManager();

		System.out.println("->> consulta pessoa com segundo em");
		PessoaNRW pessoa = em2.find(PessoaNRW.class, p.id);
		System.out.println(pessoa.nome);

		System.out.println("->> consulta pessoa com terceiro em");
		EntityManager em3 = emf.createEntityManager();
		PessoaNRW p3 = em3.find(PessoaNRW.class, p.id);
		System.out.println(p3.nome);

		System.out.println("->> atualiza pessoa");
		pessoa.nome = "mario";
		em2.getTransaction().begin();
		em2.merge(pessoa);
		em2.getTransaction().commit();

		System.out.println("->> consulta pessoa com segundo em");
		System.out.println(em2.find(PessoaNRW.class, p.id).nome);

		System.out.println("->> consulta pessoa com primeiro em");
		System.out.println(em1.find(PessoaNRW.class, p.id).nome);
		
		System.out.println("->> consulta pessoa com terceiro em");
		System.out.println(em3.find(PessoaNRW.class, p.id).nome);
	}
}
