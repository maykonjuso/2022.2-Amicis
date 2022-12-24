package br.com.amicis.model;

import java.util.ArrayList;

public class Preferencia {
	
	private ArrayList<Perfil> bloqueados;
	private String idioma;
	
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public void adicionarBloqueado(Perfil bloqueado) {
		bloqueados.add(bloqueado);
	}
	public void removerBloqueado(Perfil bloqueado) {
		bloqueados.remove(bloqueado);
	}
}
