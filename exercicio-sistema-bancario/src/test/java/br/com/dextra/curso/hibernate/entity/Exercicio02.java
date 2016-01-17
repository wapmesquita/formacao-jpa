package br.com.dextra.curso.hibernate.entity;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio02 {

	/**
	 * Quando este teste eh executado, o hibernate cria tres tabelas: Pessoa,
	 * PessoaFisica e PessoaJuridica.
	 * 
	 * Altere as entidades de modo que as tabelas geradas sejam: tbl_pessoa,
	 * tbl_pessoaFisica e tbl_pessoaJuridica
	 */
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaFisica p1 = new PessoaFisica();
		p1.setNome("Andrei da Silva");
		p1.setCpf("111.111.111-11");
		p1 = servico.salvar(p1);
	}
}
