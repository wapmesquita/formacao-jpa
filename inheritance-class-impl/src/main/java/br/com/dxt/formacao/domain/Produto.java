package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Long id;

	@Column(name="code", length=20, nullable=false, unique=true)
	public String codigo;

	@Column(length=300, nullable=false)
	public String nome;

	@Column(length=2000)
	public String descricao;

	@Column(name="preco", precision=12,scale=2,nullable=false)
	public Double precoUnitario;

	@Override
	public String toString() {
		return "Produtos [id=" + id + ", codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + ", preco=" + precoUnitario + "]";
	}

}
