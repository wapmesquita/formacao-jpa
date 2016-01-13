package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends MyAbstractEntity {

	public Telefone() {
	}
	
	public Telefone(String ddd, String telefone) {
		this.ddd = ddd;
		this.telefone = telefone;
	}

	public String ddd;

	@Column(nullable=false)
	public String telefone;

}
