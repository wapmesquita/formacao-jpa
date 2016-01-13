package br.com.dxt.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Agencia extends MyAbstractEntity implements Serializable {

	private static final long serialVersionUID = 2950038338349370660L;
	public String nome_gerente;
	public Integer cod_agencia;

}
