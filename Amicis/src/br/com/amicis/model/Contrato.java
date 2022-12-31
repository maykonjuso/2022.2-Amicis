package br.com.amicis.model;

import java.util.Date;

public class Contrato {

	private String termosUso;
	private Date dataValidade;

	public String getTermosUso() {
		return termosUso;
	}

	public void setTermosUso(String termosUso) {
		this.termosUso = termosUso;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
}
