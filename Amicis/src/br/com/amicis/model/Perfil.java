package br.com.amicis.model;

import java.util.ArrayList;

public class Perfil {
	
	private String bio;
	private Status status;
	private ArrayList<String> amigos;
	private ArrayList<String> bloqueados;
	private String this_usuario;
	private Usuario usuario;

	public Perfil() {
		status = new Status();
		status.setPerfil(this);
		
		amigos = new ArrayList<String>();
	}
	
	public void adicionarAmigo(Perfil amigo) {
		amigos.add(amigo.getUsuario().getUsuario());
	}
	
	public void removerAmigo(Perfil amigo) {
		amigos.remove(amigo.getUsuario().getUsuario());
	}
	
	public int sizeAmigos() {
		return amigos.size();
	}
	
	public String getAmigo(int posicao) {
		return amigos.get(posicao);
	}
	
	public ArrayList<String> getAmigos() {
		return amigos;
	}
	public void setAmigos(ArrayList<String> amigos) {
		this.amigos = amigos;
	}
	
	public ArrayList<String> getBloqueados() {
		return bloqueados;
	}
	public void setBloqueados(ArrayList<String> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
	public void adicionarBloquueado(Perfil bloqueado) {
		bloqueados.add(bloqueado.getUsuario().getUsuario());
	}
	
	public void removerBloqueado(Perfil bloqueado) {
		bloqueados.remove(bloqueado.getUsuario().getUsuario());
	}
	
	public int sizeBloqueados() {
		return bloqueados.size();
	}
	
	public String getBloqueado(int posicao) {
		return bloqueados.get(posicao);
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

	public String getThis_usuario() {
		return this_usuario;
	}

	public void setThis_usuario(String this_usuario) {
		this.this_usuario = this_usuario;
	}
}
