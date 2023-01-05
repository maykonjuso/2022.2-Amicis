package br.com.amicis.model;

import java.util.Date;

public class Usuario {
	
	private Perfil perfil;
	private String nome;
	private String sobrenome;
	private String usuario;
	private Date dataCadastro;
	private Date dataNascimeto;
	private String telefone;
	private String email;
	private Contrato contrato;
	private char[] senha;

	public Usuario() {
		perfil = new Perfil();
		perfil.setUsuario(this);
		perfil.setThis_usuario(this.getUsuario());
		contrato = new Contrato();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] cs) {
		this.senha = cs;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
