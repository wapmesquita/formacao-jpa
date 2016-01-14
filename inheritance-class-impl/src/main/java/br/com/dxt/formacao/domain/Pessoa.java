package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
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

	public String endereco;

	public String cidade;

	@Column(length=2)
	public String uf;

	public String telefone;

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", name=" + name + ", endereco=" + endereco
				+ ", cidade=" + cidade + ", uf=" + uf + ", telefone="
				+ telefone + "]";
	}



}
