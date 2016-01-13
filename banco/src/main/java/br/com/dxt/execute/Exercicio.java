package br.com.dxt.execute;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dxt.domain.Agencia;
import br.com.dxt.domain.Cliente;
import br.com.dxt.domain.Investimento;
import br.com.dxt.domain.TipoInvestimento;
import br.com.dxt.services.EntityManagerFactoryWrapper;
import br.com.dxt.validator.ErroValidacao;
import br.com.dxt.validator.ValidacaoUtils;

public class Exercicio {

	public static void main(String[] args) {
		Investimento acoes = new Investimento(TipoInvestimento.ACOES);
		Investimento cdb = new Investimento(TipoInvestimento.CDB);
		Investimento poupanca = new Investimento(TipoInvestimento.POUPANCA);

		Agencia agencia = new Agencia();
		agencia.cod_agencia = 123;
		agencia.nome_gerente = "joao";

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
		em.getTransaction().begin();
		em.persist(acoes);
		em.persist(cdb);
		em.persist(poupanca);
		em.persist(agencia);
		em.getTransaction().commit();

		cadastrarCliente(agencia, "cliente 1", "", TipoInvestimento.ACOES, TipoInvestimento.POUPANCA);
		cadastrarCliente(agencia, "cliente 2", "222.222.222-11", TipoInvestimento.CDB, TipoInvestimento.POUPANCA);
		cadastrarCliente(agencia, "cliente 3", "333.333.333-11", TipoInvestimento.ACOES, TipoInvestimento.CDB);
		cadastrarCliente(agencia, "cliente 4", "444.444.444-11", TipoInvestimento.ACOES);
		cadastrarCliente(agencia, "cliente 5", "555.555.555-11", TipoInvestimento.POUPANCA);

		for (String s : buscarNomesDeClientesPorInvestimento(TipoInvestimento.POUPANCA)) {
			System.out.println(s);
		}

		System.out.println("Lazy");
		em.close();

		System.out.println("buscando cliente");
		em = EntityManagerFactoryWrapper.getEntityManager();
		Cliente c = em.find(Cliente.class, 1l);

		TypedQuery<Cliente> qry = em.createQuery("select c from Cliente c " + "JOIN FETCH c.investimentos i WHERE c.id = 1L", Cliente.class);
		c = qry.getSingleResult();

		em.close();

		System.out.println("listando investimento");
		for (Investimento i : c.investimentos) {
			System.out.println(i.tipo);
		}

	}

	private static void cadastrarCliente(Agencia agencia, String nome, String cpf, TipoInvestimento... tiposInvestimentos) {
		Cliente cliente = new Cliente();
		cliente.agencia = agencia;
		cliente.nome = nome;
		cliente.cpf = cpf;
		cliente.investimentos = getInvestimentos(tiposInvestimentos);
		
		List<ErroValidacao> valida = ValidacaoUtils.valida(cliente, "cpf");
		if (valida != null && valida.size() > 0) {
			throw new RuntimeException(valida.get(0).getCode());
		}

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	private static List<Investimento> getInvestimentos(TipoInvestimento... tipos) {
		List<Investimento> retorno = new ArrayList<Investimento>();

		EntityManager em = EntityManagerFactoryWrapper.getEntityManager();
		em.getTransaction().begin();

		for (TipoInvestimento tipo : tipos) {
			Investimento investimento = new Investimento(tipo);

			em.persist(investimento);
			retorno.add(investimento);
		}

		em.getTransaction().commit();

		return retorno;
	}

	private static List<String> buscarNomesDeClientesPorInvestimento(TipoInvestimento tipo) {
		String jpql = "SELECT p.nome FROM tbl_pessoa p " + "INNER JOIN p.investimentos i WHERE i.tipo = :tipo";
		TypedQuery<String> qry = EntityManagerFactoryWrapper.getEntityManager().createQuery(jpql, String.class);
		qry.setParameter("tipo", tipo);
		return qry.getResultList();
	}
}
