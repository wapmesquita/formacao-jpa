package br.com.dxt.formacao.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class AbstractEntity {

	@Id
	@GenericGenerator(name = "bli",
	strategy = "sequence",
	parameters = {
			@org.hibernate.annotations.Parameter(
					name = "seq_bli",
					value = "seq_bli")
			}
	)
	@GeneratedValue(generator = "bli")
	public Long id;

}