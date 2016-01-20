package br.com.dxt.formacao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda extends AbstractEntity {
	
	public Date date;
	public Double valorTotal;

	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval=true)
	public List<ItemVenda> itens = new ArrayList<ItemVenda>();
	
	@ManyToOne
	public Funcionario funcionario;
	
	@ManyToOne
	public Cliente cliente;

	@Override
	public String toString() {
		return "Venda [date=" + date + ", valorTotal=" + valorTotal
				+ ", itens=" + itens + ", funcionario=" + funcionario
				+ ", cliente=" + cliente + ", id=" + id + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
