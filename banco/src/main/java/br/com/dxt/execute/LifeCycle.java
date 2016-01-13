package br.com.dxt.execute;

import javax.persistence.EntityManager;

import br.com.dxt.domain.Cliente;
import br.com.dxt.services.EntityManagerFactoryWrapper;

public class LifeCycle {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactoryWrapper.getEntityManagerFactory().createEntityManager();

		Cliente clienteTransient = new Cliente();
		clienteTransient.cpf = "cpf";
		clienteTransient.nome = "Cliente";

		em.getTransaction().begin();
		em.persist(clienteTransient);
		em.getTransaction().commit();

		Cliente clienteDetached = new Cliente();
		clienteDetached.id = 1L;
		clienteDetached.cpf = "rg";
		clienteDetached.nome = "aaa";

		em.getTransaction().begin();
		clienteDetached = em.merge(clienteDetached);
		em.getTransaction().commit();

		em.close();

		// todas as instancias passam a ser detached

		em = EntityManagerFactoryWrapper.getEntityManagerFactory().createEntityManager();
		//em.remove(clienteDetached);

		Cliente cliente = em.find(Cliente.class, 1L); // gerenciado

		em.getTransaction().begin();
		em.remove(cliente); // removed
		em.getTransaction().commit();
	}

}
