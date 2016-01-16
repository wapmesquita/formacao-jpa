package br.com.dxt.formacao.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="PJ")
public class PessoaJuridica extends Pessoa {

	public String cnpj;

//	@Temporal(TemporalType.TIMESTAMP)
//	@Temporal(TemporalType.TIME)
	@Temporal(TemporalType.DATE)
	public Date dataFundacao;


}
