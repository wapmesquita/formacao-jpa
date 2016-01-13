package br.com.dxt.execute.copy;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.PacoteServicos;

public class ExecPessoaManyToMany {

	public static void main(String[] args) {
	
		PacoteServicos pack1 = new PacoteServicos();
		pack1.tipo = "Cheque";
		
		PacoteServicos pack2 = new PacoteServicos();
		pack2.tipo = "Cartao";

		ArrayList<PacoteServicos> pacotes = new ArrayList<PacoteServicos>();
		pacotes.add(pack1);
		pacotes.add(pack2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsql");
		EntityManager em = emf.createEntityManager();

		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.packServicos = pacotes;
		
		em.getTransaction().begin();
		for (PacoteServicos p : pacotes) {
			em.persist(p);
		}
		em.persist(cliente);
		em.getTransaction().commit();
		
		String jpql = "SELECT c FROM " + Cliente.class.getSimpleName() + 
				" c INNER JOIN c.packServicos p WHERE p.tipo = :tipo";
		TypedQuery<Cliente> qry = em.createQuery(jpql, Cliente.class);
		qry.setParameter("tipo", "Cheque");
		for (Cliente c : qry.getResultList())
			for (PacoteServicos p : c.packServicos)
				System.out.println(p.tipo);
		emf.close();


	}
}
