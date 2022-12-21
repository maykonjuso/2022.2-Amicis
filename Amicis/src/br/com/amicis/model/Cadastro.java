package br.com.amicis.model;

import java.util.Date;

public class Cadastro {
	
	private String nome;
	private String usuarioString;
	private Date dataNascimeto;
	private String telefone;
	private Date dataIngresso;
	private String senha;
	private Contrato contrato;
	
	public Cadastro() {
		contrato = new Contrato();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuarioString() {
		return usuarioString;
	}
	public void setUsuarioString(String usuarioString) {
		this.usuarioString = usuarioString;
	}
	public Date getDataNascimeto() {
		return dataNascimeto;
	}
	public void setDataNascimeto(Date dataNascimeto) {
		this.dataNascimeto = dataNascimeto;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getDataIngresso() {
		return dataIngresso;
	}
	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
}
