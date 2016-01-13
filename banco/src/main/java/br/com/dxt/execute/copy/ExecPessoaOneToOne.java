package br.com.dxt.execute.copy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.Agencia;
import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Endereco;
import br.com.dxt.domain.UF;

public class ExecPessoaOneToOne {

	public static void main(String[] args) {
		Agencia ag = new Agencia();
		ag.cod_agencia = 1234;

		Endereco endereco = new Endereco();
		endereco.cidade = "Campinas";
		endereco.estado = UF.SP;

		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.endereco = endereco;
		cliente.agencia = ag;

		Cliente cliente2 = new Cliente();
		cliente2.nome = "Joao";
		cliente2.cpf = "cpf2";
		cliente2.rg = "rg2";
		cliente2.agencia = ag;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsql");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(ag);
		em.persist(endereco);
		em.persist(cliente);
		em.persist(cliente2);
		em.getTransaction().commit();

		Cliente pessoaEncontrada = em.find(Cliente.class, 1L);

		System.out.println(pessoaEncontrada.nome);
		System.out.println(pessoaEncontrada.endereco.cidade);

		String jpql = "SELECT c FROM " + Cliente.class.getSimpleName() + " c WHERE c.endereco.estado = :UF";
		TypedQuery<Cliente> qry = em.createQuery(jpql, Cliente.class);
		qry.setParameter("UF", UF.SP);
		System.out.println(qry.getSingleResult().endereco.cidade);

		jpql = "SELECT c FROM " + Cliente.class.getSimpleName() + " c WHERE c.agencia.cod_agencia = :cod";
		qry = em.createQuery(jpql, Cliente.class);
		qry.setParameter("cod", 405);
	}
}
