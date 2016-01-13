package br.com.dxt.execute;

import java.util.ArrayList;
import java.util.List;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.PacoteServicos;
import br.com.dxt.domain.Pessoa;
import br.com.dxt.services.PacoteServicosServices;
import br.com.dxt.services.PessoaFisicaService;

public class ExecPessoaManyToMany {

	public static void main(String[] args) {
	
		PacoteServicos pack1 = new PacoteServicos();
		pack1.tipo = "Cheque";
		
		PacoteServicos pack2 = new PacoteServicos();
		pack2.tipo = "Cartao";
		
		PacoteServicosServices pacoteServicosServices = new PacoteServicosServices();
		pack1 = pacoteServicosServices.salvar(pack1);
		pack2 = pacoteServicosServices.salvar(pack2);
		
		ArrayList<PacoteServicos> pacotes = new ArrayList<PacoteServicos>();
		pacotes.add(pack1);
		pacotes.add(pack2);

		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.packServicos = pacotes;

		PessoaFisicaService pessoaService = new PessoaFisicaService();
		pessoaService.salvar(cliente);

		List<Pessoa> list = pacoteServicosServices.buscarPessoasPorPacote("Cheque");
		System.out.println(list.get(0).nome);
	}
}
