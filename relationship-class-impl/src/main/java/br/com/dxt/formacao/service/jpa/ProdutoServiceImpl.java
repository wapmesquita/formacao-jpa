package br.com.dxt.formacao.service.jpa;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Produto;
import br.com.dxt.formacao.domain.ProdutoSum;
import br.com.dxt.formacao.service.AbstractServiceImpl;

public class ProdutoServiceImpl
	extends AbstractServiceImpl<Produto> {

	public ProdutoServiceImpl() {
		super(Produto.class);
	}

	public Produto buscarPorCodigo(String codigo) {
		List<Produto> list =
				buscarPorFiltroSimplesIgual("codigo", codigo);
		return list.get(0);
	}

	public ProdutoSum buscarProdutoSum() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT new ");
		sb.append(ProdutoSum.class.getName());
		sb.append("(AVG(p.preco), MAX(p.preco), MIN(p.preco)) ");
		sb.append(" FROM ");
		sb.append(Produto.class.getSimpleName());
		sb.append(" p");

		TypedQuery<ProdutoSum> qry = em.createQuery(sb.toString(),
				ProdutoSum.class);
		return qry.getSingleResult();
	}

	public List<Produto> buscarPorNome(String nome) {
		String sql = "FROM " + Produto.class.getSimpleName() + " p "
				+ "WHERE UPPER(p.nome) LIKE UPPER(:paramName)";

		TypedQuery<Produto> qry = em.createQuery(sql, Produto.class);

		qry.setParameter("paramName", "%" + nome + "%");

		return qry.getResultList();
	}

};
