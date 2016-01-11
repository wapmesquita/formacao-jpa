package br.com.dxt.formacao.jpa;

import br.com.dxt.formacao.TestePessoa;
import br.com.dxt.formacao.service.jpa.PessoaServiceImpl;

public class TestePessoaJPA extends TestePessoa {

	public TestePessoaJPA() {
		super();
		service = new PessoaServiceImpl();
	}

}
