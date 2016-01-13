package br.com.dxt.formacao.service;

import java.util.List;

import br.com.dxt.formacao.domain.Pessoa;

public interface PessoaService {

	public Pessoa salvarPessoa(Pessoa p);

	public List<Pessoa> buscarTodasPessoas();

}
