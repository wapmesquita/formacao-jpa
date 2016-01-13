package br.com.dxt.cache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PessoaReadWrite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	public String nome;

}
