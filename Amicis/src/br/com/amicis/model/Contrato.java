package br.com.amicis.model;

import java.util.Date;

public class Contrato {
	
	private String termosUso;
	private String politicas;
	private Date dataValidade;
	
	public String getTermosUso() {
		return termosUso;
	}
	public void setTermosUso(String termosUso) {
		this.termosUso = termosUso;
	}
	public String getPoliticas() {
		return politicas;
	}
	public void setPoliticas(String politicas) {
		this.politicas = politicas;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
}
