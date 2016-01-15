package br.com.dxt.formacao.app;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.domain.PessoaFisica;
import br.com.dxt.formacao.domain.PessoaJuridica;
import br.com.dxt.formacao.service.PessoaService;
import br.com.dxt.formacao.service.jpa.PessoaServiceImpl;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class CadastroPessoa {
	public static void main(String[] args) {
		PessoaService service = new PessoaServiceImpl();
		PessoaFisica pf = new PessoaFisica();
		pf.name = "Walter";
		pf.cidade = "Campinas";
		pf.cpf = "1111111111";
		pf.rg = "1231231233";

		service.salvarPessoa(pf);

		PessoaJuridica pj = new PessoaJuridica();
		pj.name = "Dextra";
		pj.cidade = "Campinas";
		pj.cnpj = "999999999999";

		service.salvarPessoa(pj);

		for (Pessoa pessoa : service.buscarTodasPessoas()) {
			if (pessoa instanceof PessoaJuridica)
				System.out.println((PessoaJuridica)pessoa);
			else
				System.out.println((PessoaFisica)pessoa);
		}

		// Sempre lembrar de fechar a factory para não deixar a conexao com o
		// banco aberta
		EntityManagerFactoryWrapper.close();

	}

}
