package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ViewProducaoDiaria")
public class ViewProducaoDiaria {

	@Id
	public Long id;
	
	@Column(name="peca_produzida")
	public String peca;
	
	@Column(name="quantidade")
	public Long qntd;
	
}
