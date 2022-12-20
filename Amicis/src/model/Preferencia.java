package model;

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
	
	public void adicionarBloqueado(Perfil perfil) {
		bloqueados.add(perfil);
	}
	public void removerBloqueado(Perfil perfil) {
		bloqueados.remove(perfil);
	}
}
