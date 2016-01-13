package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name="fk_pessoajuridica_pessoa")
public class PessoaJuridica extends Pessoa {

	@Column(nullable=false)
	public String cpnj;
	
}
