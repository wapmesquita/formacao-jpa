package br.com.dxt.execute;

import javax.persistence.EntityManager;

import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.DocumentosGerais;
import br.com.dxt.domain.Investimento;
import br.com.dxt.domain.TipoInvestimento;
import br.com.dxt.services.EntityManagerFactoryWrapper;
import br.com.dxt.services.PessoaFisicaService;

public class ExecPessoaBidirecional {

	public static void main(String[] args) {
		DocumentosGerais docs = new DocumentosGerais();
		docs.reservista="reservista";
		
		Cliente cliente = new Cliente();
		cliente.nome = "Walter";
		cliente.cpf = "cpf";
		cliente.rg = "rg";
		cliente.docs = docs;

		PessoaFisicaService pessoaService = new PessoaFisicaService();
		pessoaService.salvar(cliente);

		Investimento i1 = new Investimento();
		i1.tipo = TipoInvestimento.POUPANCA;
		//i1.pessoa = cliente;

		Investimento i2 = new Investimento();
		i2.tipo = TipoInvestimento.CDB;
		//i2.pessoa = cliente;

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
		em.getTransaction().begin();
		em.persist(i1);
		em.persist(i2);
		em.getTransaction().commit();
		em.close();

		Cliente pessoaEncontrada = (Cliente) pessoaService.buscarPorId(cliente.id);
		System.out.println(pessoaEncontrada.nome);
		em = EntityManagerFactoryWrapper.getEntityManager();
		pessoaEncontrada.investimentos.size();
		em.close();

		System.out.println(pessoaEncontrada.investimentos.get(0).tipo);
		System.out.println(pessoaEncontrada.investimentos.get(1).tipo);


	}
}
