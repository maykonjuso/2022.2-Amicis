package br.com.amicis.model;

import java.util.ArrayList;

public class Perfil {
	
	private Usuario usuario;
	private String bio;
	private Status status;
	private ArrayList<Seguidor> seguidores;
	private ArrayList<Seguindo> seguindo;
	
	public void adicionarSeguidor(Seguidor seguidor) {
		seguidores.add(seguidor);
	}
	public void removerSeguidor(Seguidor seguidor) {
		seguidores.remove(seguidor);
	}
	public Seguidor getSeguidor(int posicao) {
		return seguidores.get(posicao);
	}
	public void adicionarSeguindo(Seguindo seguindo) {
		this.seguindo.add(seguindo);
	}
	public void removerSeguindo(Seguindo seguindo) {
		this.seguindo.remove(seguindo);
	}
	public Seguindo getSeguindo(int posicao) {
		return this.seguindo.get(posicao);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
