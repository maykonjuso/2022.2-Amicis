package br.com.amicis.model;

import java.util.ArrayList;
import java.util.Date;

public class Perfil {
	
	private String nome;
	private String usuario;
	private Date dataNascimento;
	private Date dataIngresso;
	private Boolean melhorAmigo;
	private Boolean bloqueado;
	private ArrayList<Perfil> melhoresAmigos;
	
	public Perfil() {
		melhoresAmigos = new ArrayList<Perfil>();
	}
	public void adicionarMelhorAmigo(Perfil melhorAmigo) {
		melhoresAmigos.add(melhorAmigo);
	}
	public Perfil getMelhorAmigo(int posicao) {
		return melhoresAmigos.get(posicao);
	}
	public void removerMelhorAmigo(Perfil melhorAmigo) {
		melhoresAmigos.remove(melhorAmigo);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getDataIngresso() {
		return dataIngresso;
	}
	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Boolean getMelhorAmigo() {
		return melhorAmigo;
	}
	public void setMelhorAmigo(Boolean melhorAmigo) {
		this.melhorAmigo = melhorAmigo;
	}
	public Boolean getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
}
