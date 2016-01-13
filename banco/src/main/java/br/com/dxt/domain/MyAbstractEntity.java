package br.com.dxt.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MyAbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

}