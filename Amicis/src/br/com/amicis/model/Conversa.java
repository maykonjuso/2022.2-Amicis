package br.com.amicis.model;

public class Conversa {

	private Mensagem remetente;
	private Mensagem destinatario;

	public Mensagem getRemetente() {
		return remetente;
	}

	public void setRemetente(Mensagem remetente) {
		this.remetente = remetente;
	}

	public Mensagem getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Mensagem destinatario) {
		this.destinatario = destinatario;
	}
}
