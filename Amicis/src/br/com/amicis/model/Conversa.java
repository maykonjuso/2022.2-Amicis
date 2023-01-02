package br.com.amicis.model;

import java.util.Date;

public class Conversa {

	private String remetente;
	private String destinatario;
	private String conteudo;
	private Date data;

	public Conversa(Perfil perfil, int amigo) {
		this.setRemetente(perfil.getUsuario().getUsuario());
		this.setDestinatario(perfil.getAmigo(amigo));
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
