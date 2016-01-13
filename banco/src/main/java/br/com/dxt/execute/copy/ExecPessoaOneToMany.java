package br.com.dxt.execute.copy;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Endereco;
import br.com.dxt.domain.Telefone;
import br.com.dxt.domain.UF;

public class ExecPessoaOneToMany {
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.cidade = "Campinas";
		endereco.estado = UF.SP;

		Telefone residencial = new Telefone("19", "11111111");
		Telefone celular = new Telefone("11", "911111111");

		ArrayList<Telefone> listTelefones = new ArrayList<Telefone>();
		listTelefones.add(celular);
		listTelefones.add(residencial);

		Cliente cliente = new Cliente();
		cliente.telefones = listTelefones;
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.endereco = endereco;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsql");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
//		for (Telefone t : listTelefones) {
//			em.persist(t);
//		}
//		em.persist(endereco);
		em.persist(cliente);
		em.getTransaction().commit();
		
		String jpql = "SELECT c FROM " + Cliente.class.getSimpleName() + 
				" c INNER JOIN c.telefones t WHERE t.ddd = :ddd";
		TypedQuery<Cliente> qry = em.createQuery(jpql, Cliente.class);
		qry.setParameter("ddd", "19");
		for (Cliente c : qry.getResultList())
			for (Telefone t : c.telefones)
				System.out.println(t.telefone);
		emf.close();

	}
}
