package br.com.amicis.model;

import java.util.ArrayList;

public class Perfil {

	private Usuario usuario;
	private String this_usuario;
	private String bio;
	private Status status;
	private Notificacao notificacao;
	private Conversa conversa;
	private Contrato contrato;
	private Suporte suporte;
	private ArrayList<Publicacao> publicacoes;
	private ArrayList<String> amigos;
	private ArrayList<String> bloqueados;

	public Perfil() {
		status = new Status();
		status.setPerfil(this);
		notificacao = new Notificacao();
		notificacao.setPerfil(this);
		conversa = new Conversa();
		contrato = new Contrato();
		suporte = new Suporte();
		amigos = new ArrayList<String>();
		bloqueados = new ArrayList<String>();
		publicacoes = new ArrayList<Publicacao>();
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public Conversa getConversaDireta() {
		return conversa;
	}

	public void setConversaDireta(Conversa conversa) {
		this.conversa = conversa;
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
		if (sizeAmigos() == 0) {
			return null;
		}
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
		if (sizeAmigos() == 0) {
			return null;
		}
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

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Suporte getSuporte() {
		return suporte;
	}

	public void setSuporte(Suporte suporte) {
		this.suporte = suporte;
	}

	public String getThis_usuario() {
		return this_usuario;
	}

	public void setThis_usuario(String this_usuario) {
		this.this_usuario = this_usuario;
	}

	public ArrayList<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(ArrayList<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

	public void adicionarPublicacao(Publicacao publicacao) {
		publicacoes.add(publicacao);
	}

	public void removerPublicacao(Publicacao publicacao) {
		publicacoes.remove(publicacao);
	}

	public int sizePublicacao() {
		return publicacoes.size();
	}

	public Publicacao getPublicacao(int posicao) {
		return publicacoes.get(posicao);
	}

}
