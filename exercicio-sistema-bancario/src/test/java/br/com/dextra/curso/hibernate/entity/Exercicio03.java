package br.com.dextra.curso.hibernate.entity;

import javax.persistence.PersistenceException;

import org.junit.Test;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio03 {

	/**
	 * Este teste inclui duas pessoas com o mesmo CPF.
	 * 
	 * Altere as entidades de modo que nao seja possivel inserir duas pessoas
	 * (fisica) com o mesmo cpf
	 */
	@Test(expected=PersistenceException.class)
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaFisica p1 = new PessoaFisica();
		p1.setNome("Andrei da Silva");
		p1.setCpf("111.111.111-11");
		p1 = servico.salvar(p1);

		PessoaFisica p2 = new PessoaFisica();
		p2.setNome("Andrei Silva");
		p2.setCpf("111.111.111-11");

		p2 = servico.salvar(p2);
	}
}
