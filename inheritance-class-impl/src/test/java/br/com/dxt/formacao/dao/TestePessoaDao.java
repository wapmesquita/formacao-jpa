package br.com.dxt.formacao.dao;

import br.com.dxt.formacao.TestePessoa;
import br.com.dxt.formacao.service.dao.PessoaServiceDao;

public class TestePessoaDao extends TestePessoa {

	public TestePessoaDao() {
		super();
		service = new PessoaServiceDao();
	}

}
