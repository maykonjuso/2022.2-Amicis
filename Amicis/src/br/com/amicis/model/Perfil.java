package br.com.amicis.model;

import java.util.ArrayList;

public class Perfil {
	
	private String bio;
	private Status status;
	private ArrayList<Perfil> amigos;
	private Usuario usuario;
	
	
	
	public Perfil() {
		amigos = new ArrayList<Perfil>();
	}
	
	public void adicionarAmigo(Perfil amigo) {
		amigos.add(amigo);
	}
	public void removerAmigo(Perfil amigo) {
		amigos.remove(amigo);
	}
	public Perfil getAmigo(int posicao) {
		return amigos.get(posicao);
	}
	public int sizeAmigo() {
		return amigos.size();
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
