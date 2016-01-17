package br.com.dextra.curso.hibernate.entity;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio06 {

	/**
	 * Crie uma entidade chamada TransacaoBancaria. Essa entidade vai
	 * representar uma transacao de valor entre duas contas (conta origem, conta
	 * destino, dataEHora e valor).
	 * 
	 * Apos isso, implemente o metodo realizarTransacao que se encontra na
	 * classe HibernateServicesImpl de modo que ao executar este teste:
	 * 
	 * 1. Exista um registro na tabela TransacaoBancaria representando a
	 * transacao
	 * 
	 * 2. A contaBancaria da pessoaA esteja com 900
	 * 
	 * 3. A contaBancaria da pessoaB esteja com 1100
	 */
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaFisica pessoaA = new PessoaFisica();
		pessoaA.setNome("PessoaA");
		pessoaA.setCpf("111.111.111-11");

		ContaBancaria contaA = new ContaBancaria();
		contaA.setSaldo(1000.0);
		Long idPessoaA = servico.salvarPessoa(pessoaA, contaA).getId();

		PessoaFisica pessoaB = new PessoaFisica();
		pessoaB.setNome("PessoaB");
		pessoaB.setCpf("222.222.222-22");

		ContaBancaria contaB = new ContaBancaria();
		contaB.setSaldo(1000.0);
		Long idPessoaB = servico.salvarPessoa(pessoaB, contaB).getId();

		pessoaA = servico.buscar(PessoaFisica.class, idPessoaA);
		pessoaB = servico.buscar(PessoaFisica.class, idPessoaB);
		
		servico.realizarTransacao(pessoaA, pessoaB, 100.0);
	}
}
