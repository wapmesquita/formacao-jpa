package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String logradouro;

	@Column(nullable = false)
	public String cidade;

	@Enumerated(EnumType.STRING)
	public UF estado;

}
