package br.com.amicis.model;

import java.util.Date;

public class Conversa {

	private Mensagem remetente;
	private Mensagem destinatario;
	private Date data;

	public Mensagem getRemetente() {
		return remetente;
	}

	public void setRemetente(Mensagem remetente) {
		this.remetente = remetente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Mensagem getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Mensagem destinatario) {
		this.destinatario = destinatario;
	}
}
