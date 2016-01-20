package br.com.dxt.formacao.domain;

import javax.persistence.Entity;

@Entity
public class Categoria extends AbstractEntity {

	public String codigo;

	public String descricao;

}
