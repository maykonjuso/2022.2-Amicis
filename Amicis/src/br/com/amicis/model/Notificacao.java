package br.com.amicis.model;

import java.util.Date;

public class Notificacao {
	private String nome;
	private Date dataNoficacao;
	private String conteudo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	private boolean apagar() {
		
	}
}
