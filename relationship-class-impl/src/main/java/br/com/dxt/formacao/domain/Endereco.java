package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(length=300)
	public String logradouro;

	@Column(length=2)
	public String uf;

}
