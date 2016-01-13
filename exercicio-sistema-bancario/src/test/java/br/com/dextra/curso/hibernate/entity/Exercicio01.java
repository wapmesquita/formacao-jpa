package br.com.dextra.curso.hibernate.entity;

import org.junit.Test;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio01 {

	/**
	 * O seguinte teste falha, pois existem problemas (mais de um) no mapeamento das
	 * entidades.
	 * 
	 * Altere as entidades de modo que o teste execute sem apresentar erros.
	 */
	@Test
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaFisica pessoaFisica = new PessoaFisica();
		pessoaFisica.setNome("Andrei");
		pessoaFisica.setCpf("111.111.111-11");

		servico.salvar(pessoaFisica);
	}
}
