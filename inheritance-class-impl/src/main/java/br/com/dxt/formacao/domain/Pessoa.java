package br.com.dxt.formacao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public Integer id;

	@Column()
	public String name;

	@Column(name="idade")
	public Integer age;

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + name + ", idade=" + age + "]";
	}

}
