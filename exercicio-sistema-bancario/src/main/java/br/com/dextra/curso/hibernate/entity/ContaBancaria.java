package br.com.dextra.curso.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContaBancaria {

	@Id
	@GeneratedValue
	private Long id;
	
	private String numero;
	
	private Double saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
