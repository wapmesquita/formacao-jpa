package br.com.dxt.formacao.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Holerite extends AbstractEntity {

	@Temporal(TemporalType.DATE)
	public Date dataContratacao;

	public Double salario;

	public Integer diaPagamento;

}
