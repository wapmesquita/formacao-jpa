package br.com.dxt.formacao.app;

import br.com.dxt.formacao.domain.Pessoa;
import br.com.dxt.formacao.service.PessoaService;
import br.com.dxt.formacao.service.jpa.PessoaServiceImpl;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;
import br.com.dxt.formacao.utils.Utils;

public class CadastroPessoa {
	public static void main(String[] args) {
		PessoaService service = new PessoaServiceImpl();
		Pessoa p = new Pessoa();
		p.name = Utils.getString("Digite o nome");
		p.age = Utils.getInt("Digite a idade");

		service.salvarPessoa(p);

		for (Pessoa pessoa : service.buscarTodasPessoas()) {
			System.out.println(pessoa);
		}

		// Sempre lembrar de fechar a factory para não deixar a conexao com o
		// banco aberta
		EntityManagerFactoryWrapper.close();

	}

}
