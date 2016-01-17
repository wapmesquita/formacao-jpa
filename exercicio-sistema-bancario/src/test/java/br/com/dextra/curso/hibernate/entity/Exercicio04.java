package br.com.dextra.curso.hibernate.entity;

import org.junit.Test;

import br.com.dextra.curso.hibernate.services.HibernateServices;
import br.com.dextra.curso.hibernate.services.ServiceFactory;

public class Exercicio04 {

	/**
	 * O seguinte codigo salva uma empresa. No banco de dados, a coluna tipo
	 * esta representada por um numero (que no caso desse exemplo ficou populada
	 * com zero). Altere a entidade PessoaJuridica de modo que seja gravado a
	 * "String" correspondente a enum.
	 */
	@Test
	public void teste() {
		HibernateServices servico = ServiceFactory.getHibernateService();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome("Empresa A");
		pessoaJuridica.setTipo(TipoEmpresa.SOCIEDADE_LIMITADA);

		servico.salvar(pessoaJuridica);
	}
}
