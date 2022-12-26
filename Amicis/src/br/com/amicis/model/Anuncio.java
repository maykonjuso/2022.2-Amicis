package br.com.amicis.model;

public class Anuncio {

	private Usuario anunciante;
	private Publicacao publicacao;

	public Anuncio() {
		anunciante = new Usuario();
		publicacao = new Publicacao();
	}

	public Usuario getAnunciante() {
		return anunciante;
	}

	public void setAnunciante(Usuario anunciante) {
		this.anunciante = anunciante;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
}
