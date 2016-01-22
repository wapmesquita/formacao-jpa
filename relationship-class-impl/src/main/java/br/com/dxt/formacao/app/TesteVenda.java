package br.com.dxt.formacao.app;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hsqldb.util.DatabaseManagerSwing;

import br.com.dxt.formacao.domain.Cliente;
import br.com.dxt.formacao.domain.Funcionario;
import br.com.dxt.formacao.domain.Holerite;
import br.com.dxt.formacao.domain.ItemVenda;
import br.com.dxt.formacao.domain.Produto;
import br.com.dxt.formacao.domain.Telefone;
import br.com.dxt.formacao.domain.Venda;
import br.com.dxt.formacao.service.AbstractServiceImpl;
import br.com.dxt.formacao.service.FuncionarioService;
import br.com.dxt.formacao.service.VendaService;
import br.com.dxt.formacao.service.jpa.PessoaServiceImpl;
import br.com.dxt.formacao.utils.EntityManagerFactoryWrapper;

public class TesteVenda {

	public static void main(
			String[] args) {
		Funcionario f1 = criaFuncionario1();

		Funcionario f2 = criaFuncionario2();

		FuncionarioService funcService = new FuncionarioService();

		funcService.salvar(f1);
		funcService.salvar(f2);

		Cliente c1 = criarCliente("Mario");

		PessoaServiceImpl pessoaService = new PessoaServiceImpl();
		pessoaService.salvar(c1);

		cadastraProdutos();

		Venda v1 = cadastrarVenda(f1, c1);

		VendaService vs = new VendaService();

		List<Venda> vendas = vs.
				buscarVendaPorCodigoProduto("123");
		System.out
				.println(vendas);

		EntityManagerFactoryWrapper.close();

		System.out
				.println(vendas.get(0).funcionario);
	}

	private static void cadastraProdutos() {

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();

		em.getTransaction().begin();
		Produto p = new Produto();
		p.codigo = "123";
		p.nome="Chocolate";
		p.precoUnitario = 10.45;
		em.persist(p);
		em.getTransaction().commit();

		em.getTransaction().begin();
		p = new Produto();
		p.codigo = "4346";
		p.nome="Leite";
		p.precoUnitario = 2.45;
		em.persist(p);
		em.getTransaction().commit();

		em.getTransaction().begin();
		p = new Produto();
		p.codigo = "24543";
		p.nome="Arroz";
		p.precoUnitario = 13.0;
		em.persist(p);
		em.getTransaction().commit();

		em.getTransaction().begin();
		p = new Produto();
		p.codigo = "128743";
		p.nome="Feijao";
		p.precoUnitario = 7.12;
		em.persist(p);

		em.getTransaction().commit();

		em.close();
	}

	private static Venda cadastrarVenda(Funcionario funcionario, Cliente cliente) {
		AbstractServiceImpl<Produto> produtoService = new AbstractServiceImpl<Produto>(Produto.class);
		List<Produto> produtos = produtoService.buscarTodos();

		Venda v = new Venda();
		v.date = new Date();
		v.funcionario = funcionario;
		v.cliente = cliente;

		ItemVenda iv = new ItemVenda();
		iv.produto = produtos.get(0);
		iv.quantidade = 3;
		iv.valorTotal = iv.quantidade * iv.produto.precoUnitario;
		v.itens.add(iv);

		iv = new ItemVenda();
		iv.produto = produtos.get(1);
		iv.quantidade = 2;
		iv.valorTotal = iv.quantidade * iv.produto.precoUnitario;
		v.itens.add(iv);

		AbstractServiceImpl<Venda> vendaService = new AbstractServiceImpl<Venda>(Venda.class);
		vendaService.salvar(v);
		return v;
	}

	private static Cliente criarCliente(String nome) {
		Cliente c = new Cliente();
		c.name = nome;
		return c;
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
			Holerite configHolerite,
			Telefone... telefones) {

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
