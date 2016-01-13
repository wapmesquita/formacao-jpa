package br.com.dxt.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.ForeignKey;

@Entity
@ForeignKey(name="fk_cliente_pessoafisica")
public class Cliente extends PessoaFisica {
	
	public String rg;

}
