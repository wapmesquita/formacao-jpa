package br.com.dxt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class PacoteServicos extends MyAbstractEntity {

	@Column
	public String tipo;
	
	@Transient
	public String ble;

}
