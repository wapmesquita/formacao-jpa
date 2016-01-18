package br.com.dxt.formacao.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Funcionario extends PessoaFisica {

	public String matricula;

	@OneToOne
	public Holerite configHolerite;
}
