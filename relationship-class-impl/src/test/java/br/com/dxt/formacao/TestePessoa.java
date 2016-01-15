package br.com.dxt.formacao;

import junit.framework.TestCase;
import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.domain.PessoaFisica;
import br.com.dxt.formacao.service.PessoaService;

public abstract class TestePessoa extends TestCase {

	protected PessoaService service;

	public void testSalvarEBuscarPessoa() {
		Pessoa p = new PessoaFisica();
		p.name = "Teste";

		service.salvarPessoa(p);

		for (Pessoa pessoa : service.buscarTodasPessoas()) {
			System.out.println(pessoa);
		}

	}
}
