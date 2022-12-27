package br.com.amicis.model;

import java.util.ArrayList;

public class Perfil {

	private String bio;
	private Status status;
	private ArrayList<Perfil> amigos;
	private ArrayList<Perfil> bloqueados;
	private Usuario usuario;

	public Perfil() {
		status = new Status();
		status.setPerfil(this);
		amigos = new ArrayList<Perfil>();
		bloqueados = new ArrayList<Perfil>();
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

	public void adicionarBloqueado(Perfil bloqueado) {
		bloqueados.add(bloqueado);
	}

	public void removerBloqueado(Perfil bloqueado) {
		bloqueados.remove(bloqueado);
	}

	public Perfil getBloqueado(int posicao) {
		return bloqueados.get(posicao);
	}

	public int sizeAmigo() {
		return amigos.size();
	}
	
	public int sizeBloqueado() {
		return bloqueados.size();
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
