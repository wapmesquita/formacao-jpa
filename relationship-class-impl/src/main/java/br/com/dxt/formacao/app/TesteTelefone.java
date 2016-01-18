package br.com.dxt.formacao.app;

import java.util.Date;

import br.com.dxt.formacao.domain.Funcionario;
import br.com.dxt.formacao.domain.Holerite;
import br.com.dxt.formacao.domain.Telefone;
import br.com.dxt.formacao.service.FuncionarioService;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class TesteTelefone {

	public static void main(
			String[] args) {
		Funcionario f1 = criaFuncionario1();

		Funcionario f2 = criaFuncionario2();

		FuncionarioService funcService = new FuncionarioService();

		funcService.salvar(f1);
		funcService.salvar(f2);

		for (Funcionario f : funcService
				.buscarQuaisRecebemDia(10))
			System.out.println(f.name);

		EntityManagerFactoryWrapper
				.close();
	}

	private static Funcionario criaFuncionario2() {
		Holerite h = criaHolerite(10,
				new Date(), 1500.99);
		Telefone t1 = criaTelefone(
				"19", "2111");
		Telefone t2 = criaTelefone(
				"19", "2222");
		Funcionario f = criaFuncionario(
				"Joao", "5678", h, t1, t2);
		return f;
	}

	private static Funcionario criaFuncionario1() {
		Holerite h = criaHolerite(27,
				new Date(), 2500.0);
		Telefone t1 = criaTelefone(
				"19", "1111");
		Telefone t2 = criaTelefone(
				"19", "1222");
		Funcionario f = criaFuncionario(
				"Walter", "123", h, t1, t2);
		return f;
	}

	private static Telefone criaTelefone(
			String ddd, String numero) {
		Telefone t = new Telefone();
		t.ddd = ddd;
		t.numero = numero;
		return t;
	}

	private static Funcionario criaFuncionario(
			String nome, String cpf,
			Holerite configHolerite, Telefone... telefones) {

		Funcionario f = new Funcionario();
		f.name = nome;
		f.cpf = cpf;
		f.configHolerite = configHolerite;
		for (Telefone t : telefones) {
			f.telefones.add(t);
		}
		return f;
	}

	private static Holerite criaHolerite(
			Integer dia,
			Date dataContratacao,
			Double salario) {

		Holerite h = new Holerite();
		h.diaPagamento = dia;
		h.dataContratacao = dataContratacao;
		h.salario = salario;
		return h;
	}

}
