package br.com.dxt.formacao.app;

import java.util.Date;

import br.com.dxt.formacao.domain.Funcionario;
import br.com.dxt.formacao.domain.Holerite;
import br.com.dxt.formacao.service.FuncionarioService;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class TesteHolerite {

	public static void main(
			String[] args) {
		Holerite h1 =
				criaHolerite(27, new Date(), 2500.0);
		Funcionario f1 =
				criaFuncionario("Walter", "123", h1);

		Holerite h2 =
				criaHolerite(10, new Date(), 2500.0);
		Funcionario f2 =
				criaFuncionario("Joao", "333", h2);

		FuncionarioService funcService = new FuncionarioService();

		funcService.salvar(f1);
		funcService.salvar(f2);

		for (Funcionario f :
				funcService.buscarQuaisRecebemDia(10))
			System.out
					.println(f.name);


		EntityManagerFactoryWrapper.close();
	}

	private static Funcionario criaFuncionario(
			String nome, String cpf,
			Holerite configHolerite) {

		Funcionario f = new Funcionario();
		f.name = nome;
		f.cpf = cpf;
		f.configHolerite = configHolerite;
		return f;
	}
	private static Holerite criaHolerite(
			Integer dia, Date dataContratacao,
			Double salario) {

		Holerite h = new Holerite();
		h.diaPagamento = dia;
		h.dataContratacao = dataContratacao;
		h.salario = salario;
		return h;
	}

}
