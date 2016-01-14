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

	@Override
	public String toString() {
		return "PessoaJuridica [cnpj=" + cnpj + ", dataFundacao="
				+ dataFundacao + ", id=" + id + ", name=" + name
				+ ", endereco=" + endereco + ", cidade=" + cidade + ", uf="
				+ uf + ", telefone=" + telefone + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
