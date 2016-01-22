package br.com.dxt.formacao.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda extends AbstractEntity {

	public Date date;
	public Double valorTotal;

	@JoinColumn(name="venda_id")
	@OneToMany(cascade={CascadeType.PERSIST,
			CascadeType.MERGE},
			orphanRemoval=true)
	public List<ItemVenda> itens = new ArrayList<ItemVenda>();

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	public Funcionario funcionario;

	@ManyToOne(fetch=FetchType.LAZY)
	public Cliente cliente;

	@Override
	public String toString() {
		return "Venda [date=" + date
				+ ", valorTotal="
				+ valorTotal + ", id="
				+ id + "]";
	}




}
