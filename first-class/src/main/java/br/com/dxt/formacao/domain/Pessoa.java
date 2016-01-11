package br.com.dxt.formacao.domain;


public class Pessoa {

	public Integer id;

	public String name;

	public Integer age;

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + name + ", idade=" + age + "]";
	}

}
