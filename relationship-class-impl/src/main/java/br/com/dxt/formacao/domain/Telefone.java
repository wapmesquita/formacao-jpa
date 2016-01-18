package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends AbstractEntity {

	@Column(length=2)
	public String ddd;

	public String numero;

}
