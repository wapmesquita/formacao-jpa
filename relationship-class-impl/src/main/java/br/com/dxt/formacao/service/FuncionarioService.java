package br.com.dxt.formacao.service;

import br.com.dxt.formacao.domain.Funcionario;

public class FuncionarioService extends AbstractServiceImpl<Funcionario> {

	public FuncionarioService() {
		super(Funcionario.class);
	}

	@Override
	public Funcionario salvar(
			Funcionario f) {
		em.getTransaction().begin();

		if (f.configHolerite != null) {
			if (f.configHolerite.id != null)
				f.configHolerite = em.merge(f.configHolerite);
			else
				em.persist(f.configHolerite);
		}

		if (f.id != null)
			f = em.merge(f);
		else
			em.persist(f);

		em.getTransaction().commit();
		return f;
	}

}
