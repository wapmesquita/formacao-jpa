package br.com.dxt.execute;

import java.util.List;

import br.com.dxt.domain.Agencia;
import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Pessoa;
import br.com.dxt.services.AgenciaService;
import br.com.dxt.services.PessoaFisicaService;

public class ExecPessoaManyToOne {

	public static void main(String[] args) {
		Agencia ag = new Agencia();
		ag.nome_gerente = "JOAO";

		AgenciaService agenciaService = new AgenciaService();
		ag = agenciaService.salvar(ag);

		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.agencia = ag;

		PessoaFisicaService pessoaService = new PessoaFisicaService();
		pessoaService.salvar(cliente);

		List<Pessoa> list = agenciaService.buscarClientesPorAgencia(ag.id);
		System.out.println(list.get(0).nome);

	}

}
