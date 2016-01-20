package br.com.dxt.formacao.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends AbstractEntity {
	
	@ManyToOne(optional=false)
	public Produto produto;
	
	public Integer quantidade;
	
	public Double valorTotal;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemVenda [produto=");
		builder.append(produto);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", valorTotal=");
		builder.append(valorTotal);
		builder.append(", id=");
		builder.append(id);
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
}
