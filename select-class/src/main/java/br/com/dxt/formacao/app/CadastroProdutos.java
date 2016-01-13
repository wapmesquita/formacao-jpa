package br.com.dxt.formacao.app;

//import br.com.dxt.formacao.domain.Produto;
//import br.com.dxt.formacao.service.jpa.ProdutoServiceImpl;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;
import br.com.dxt.formacao.utils.Utils;

public class CadastroProdutos {

	public static void main(String[] args) {
		//Descomentar codigo e implementar solucao
		/*
		ProdutoServiceImpl service = new ProdutoServiceImpl();

		while (Utils.confirm("Cadastrar produto")) {
			Produto p = new Produto();
			p.codigo = Utils.getString("Digite o codigo");
			p.nome = Utils.getString("Digite o nome");
			p.descricao = Utils.getString("Digite a descricao");
			boolean ok = true;
			do {
				try {
					p.precoUnitario = Double.parseDouble(Utils
							.getString("Digite o preco"));
					ok = true;
				} catch (NumberFormatException e) {
					System.out.println("Preco informado incorreto");
					ok = false;
				}
			} while (ok == false);
			service.salvar(p);
		}

		for (Produto produto : service.buscarTodos()) {
			System.out.println(produto);
		}

		while (Utils.confirm("Consultar por codigo")) {
			String codigo = Utils.getString("Digite o codigo para consulta");
			System.out.println(service.buscarPorCodigo(codigo));
		}

		while (Utils.confirm("Excluir")) {
			long id = Long.parseLong(Utils
					.getString("Digite o id do produto para excluir"));
			if (id != 0) {
				service.excluir(id);
			}
		}

		for (Produto produto : service.buscarTodos()) {
			System.out.println(produto);
		}

		// fechar a conexao aqui
		EntityManagerFactoryWrapper.close();
		*/
	}
}