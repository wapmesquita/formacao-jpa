package br.com.dxt.formacao.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Produto;
import br.com.dxt.formacao.domain.ProdutoSum;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class ProdutoServiceImpl {

	private static EntityManager em = EntityManagerFactoryWrapper
			.getEntityManager();

	public Produto salvar(Produto p) {
		em.getTransaction().begin();
		if (p.id == null)
			em.persist(p);
		else
			p = em.merge(p);
		em.getTransaction().commit();
		return p;
	}

	public List<Produto> buscarTodos() {
		TypedQuery<Produto> qry = em.createQuery(
				"from " + Produto.class.getSimpleName(), Produto.class);
		return qry.getResultList();
	}

	public Produto buscarPorId(Long id) {
		try {
			return em.find(Produto.class, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public void excluir(Long id) {
		excluir(buscarPorId(id));
	}

	public void excluir(Produto p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}

	public Produto buscarPorCodigo(String codigo) {
		String sql = "FROM " + Produto.class.getSimpleName() + " p "
				+ "WHERE p.codigo = :pCodigo";
		TypedQuery<Produto> qry = em.createQuery(sql, Produto.class);
		qry.setParameter("pCodigo", codigo);

		try {
			return qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public ProdutoSum buscarProdutoSum() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT new ");
		sb.append(ProdutoSum.class.getName());
		sb.append("(AVG(p.preco), MAX(p.preco), MIN(p.preco)) ");
		sb.append(" FROM ");
		sb.append(Produto.class.getSimpleName());
		sb.append(" p");

		TypedQuery<ProdutoSum> qry = em.createQuery(sb.toString(), ProdutoSum.class);
		return qry.getSingleResult();
	}


};
