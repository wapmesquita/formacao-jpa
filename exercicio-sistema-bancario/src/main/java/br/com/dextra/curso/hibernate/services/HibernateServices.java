package br.com.dextra.curso.hibernate.services;

import java.util.List;

import br.com.dextra.curso.hibernate.entity.ContaBancaria;
import br.com.dextra.curso.hibernate.entity.Pessoa;
import br.com.dextra.curso.hibernate.entity.PessoaFisica;

public interface HibernateServices {

	<T> T salvar(T instance);

	<T> T buscar(Class<T> clazz, Long id);

	<T> List<T> buscarTodos(Class<T> clazz);

	Pessoa salvarPessoa(Pessoa pessoa, ContaBancaria conta);

	void realizarTransacao(PessoaFisica pessoaA, PessoaFisica pessoaB, Double valor);
}

