package br.com.amicis.model;

public class Anuncio extends Publicacao {

	public Anuncio(Perfil perfil) {
		super(perfil);
	}

	private boolean anuncio;

	public boolean getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(boolean anuncio) {
		this.anuncio = anuncio;
	}

}
