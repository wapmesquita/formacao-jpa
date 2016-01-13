package br.com.dxt.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name="fk_funcionario_pessoafisica")
public class Funcionario extends PessoaFisica {

	public String matricula;

}
