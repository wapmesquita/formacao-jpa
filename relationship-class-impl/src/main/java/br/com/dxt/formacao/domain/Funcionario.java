package br.com.dxt.formacao.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends PessoaFisica {

	public String matricula;

	@JoinColumn(name="holerite_id")
	@OneToOne
	public Holerite configHolerite;
}
