package br.com.dxt.validator;

import java.io.Serializable;

public class ErroValidacao implements Serializable {

	private static final long serialVersionUID = -4290527038849737540L;

	private String field;

	private String[] args;

	private String code;

	private String type = "error";

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String... label) {
		this.args = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
