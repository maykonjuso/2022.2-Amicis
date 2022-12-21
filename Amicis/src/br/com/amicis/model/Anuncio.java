package br.com.amicis.model;

public class Anuncio {
	
	private Perfil anunciante;
	private Publicacao publicacao;
	
	public Perfil getAnunciante() {
		return anunciante;
	}
	public void setAnunciante(Perfil anunciante) {
		this.anunciante = anunciante;
	}
	public Publicacao getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
}
