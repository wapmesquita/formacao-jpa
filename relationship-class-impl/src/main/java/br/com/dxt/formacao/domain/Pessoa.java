package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="tipo")
public abstract class Pessoa extends AbstractEntity {

	@Column(name="nome")
	public String name;

	@Embedded
	public Endereco endereco;

	public String telefone;


}
