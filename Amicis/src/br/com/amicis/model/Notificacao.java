package br.com.amicis.model;

import java.util.Date;

public class Notificacao {

	private Perfil perfil;
	private Date dataNoficacao;
	private String conteudo;

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Date getDataNoficacao() {
		return dataNoficacao;
	}

	public void setDataNoficacao(Date dataNoficacao) {
		this.dataNoficacao = dataNoficacao;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
