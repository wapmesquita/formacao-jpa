package br.com.dxt.formacao.service;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.dxt.formacao.domain.Venda;

public class VendaService extends AbstractServiceImpl<Venda> {

	public VendaService() {
		super(Venda.class);
	}

	public List<Venda>
		buscarVendaPorCodigoProduto(String c) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT v FROM ");
		sb.append(Venda.class.getSimpleName());
		sb.append(" v INNER JOIN v.itens i");
		sb.append(" WHERE i.produto.codigo = :codigo");

		TypedQuery<Venda> qry = em.
				createQuery(sb.toString(), Venda.class);
		qry.setParameter("codigo", c);
		return qry.getResultList();
	}


}
