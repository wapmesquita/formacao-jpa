package br.com.dxt.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Investimento extends MyAbstractEntity {

	@Enumerated(EnumType.STRING)
	public TipoInvestimento tipo;

	public Investimento(TipoInvestimento tipo) {
		super();
		this.tipo = tipo;
	}

	public Investimento() {
		super();
	}

}