package br.com.dextra.curso.hibernate.entity;

import org.junit.Test;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio05 {

	/**
	 * Por simplicidade, vamos supor que uma pessoa tenha somente uma
	 * contaBancaria (OneToOne)
	 * 
	 * Crie o relacionamento entre Pessoa e ContaBancaria (bi-direcional).
	 * 
	 * Implemente o metodo salvarPessoa que se encontra na classe
	 * HibernateServiceImpl, de modo que quando este teste unitario for
	 * executado a contaBancaria esteja associada a pessoa
	 */
	@Test
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaFisica pessoa = new PessoaFisica();
		pessoa.setNome("Nome da pessoa");
		pessoa.setCpf("111.111.111-11");

		ContaBancaria conta = new ContaBancaria();
		conta.setNumero("0001");

		servico.salvarPessoa(pessoa, conta);
	}
}
