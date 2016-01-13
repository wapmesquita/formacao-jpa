package br.com.dextra.curso.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa {

	private String cnpj;
	
	private TipoEmpresa tipo;
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoEmpresa getTipo() {
		return tipo;
	}

	public void setTipo(TipoEmpresa tipo) {
		this.tipo = tipo;
	}
}
