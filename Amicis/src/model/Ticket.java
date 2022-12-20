package model;

import java.util.Date;

public class Ticket {
	private Date data;
	private double protocolo;
	private String status;
	private String severidade;
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(double protocolo) {
		this.protocolo = protocolo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeveridade() {
		return severidade;
	}

	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}

	public boolean enviar() {
		
	}
}
