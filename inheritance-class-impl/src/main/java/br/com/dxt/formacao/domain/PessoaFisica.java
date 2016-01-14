package br.com.dxt.formacao.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="PF")
public class PessoaFisica extends Pessoa {

	public String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	public Date dataNascimento;

	public String rg;

	public String celular;

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", rg=" + rg + ", celular=" + celular
				+ ", id=" + id + ", name=" + name + ", endereco=" + endereco
				+ ", cidade=" + cidade + ", uf=" + uf + ", telefone="
				+ telefone + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}


}
