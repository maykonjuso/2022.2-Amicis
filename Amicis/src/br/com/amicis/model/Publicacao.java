package br.com.amicis.model;

import java.util.Date;

public class Publicacao {

	private Perfil perfil;
	private String usuario;
	private String conteudo;
	private Date data;
	private int coracao;

	public Publicacao(Perfil perfil) {
		this.setUsuario(perfil.getThis_usuario());
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCoracao() {
		return coracao;
	}

	public void setCoracao(int coracao) {
		this.coracao = coracao;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
