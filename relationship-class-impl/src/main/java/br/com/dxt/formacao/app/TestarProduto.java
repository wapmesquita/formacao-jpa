package br.com.dxt.formacao.app;

import javax.persistence.EntityManager;

import br.com.dxt.formacao.domain.Produto;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class TestarProduto {

	public static void main(
			String[] args) {
		Produto p = new Produto();
		p.codigo = "123";
		p.nome="Chocolate";
		p.precoUnitario = 10.45;

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

		EntityManagerFactoryWrapper.close();
	}

}
