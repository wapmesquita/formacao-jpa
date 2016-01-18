package br.com.dxt.formacao.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue(value="PF")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class PessoaFisica extends Pessoa {

	public String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	public Date dataNascimento;

	public String rg;

	public String celular;

	@Embedded
	@AttributeOverrides(
			{
				@AttributeOverride(
						name="logradouro",
						column=@Column(
								name="end_com_logradouro"
								)
				),
				@AttributeOverride(
						name="uf",
						column=@Column(
								name="end_com_uf"
								)
				)
			}
	)
	public Endereco enderecoComercial;

}
