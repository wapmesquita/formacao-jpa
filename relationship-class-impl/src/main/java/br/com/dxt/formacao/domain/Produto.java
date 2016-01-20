package br.com.dxt.formacao.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_produtos")
public class Produto extends AbstractEntity {

	@Column(name="code", length=20, nullable=false, unique=true)
	public String codigo;

	@Column(length=300, nullable=false)
	public String nome;

	@Column(length=2000)
	public String descricao;

	@Column(name="preco", precision=12,scale=2,nullable=false)
	public Double precoUnitario;

	@ManyToMany
	public List<Categoria> categorias = new ArrayList<>();

	@Override
	public String toString() {
		return "Produtos [id=" + id + ", codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + ", preco=" + precoUnitario + "]";
	}

}
