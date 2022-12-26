package br.com.amicis.model;

import java.util.ArrayList;

public class ConversaDireta {

	private Perfil perfilFixado;
	private ArrayList<Perfil> amigos;
	private ArrayList<Grupo> grupos;

	public void adicionarAmigos(Perfil amigo) {
		amigos.add(amigo);
	}

	public void removerAmigos(Perfil amigo) {
		amigos.remove(amigo);
	}

	public Perfil getAmigos(int posicao) {
		return amigos.get(posicao);
	}

	public void adicionarGrupos(Grupo grupo) {
		grupos.add(grupo);
	}

	public void removerGrupo(Grupo grupo) {
		grupos.remove(grupo);
	}

	public Grupo getGrupo(int posicao) {
		return grupos.get(posicao);
	}

	public Perfil getPerfilFixada() {
		return perfilFixado;
	}

	public void setPerfilFixada(Perfil perfilFixado) {
		this.perfilFixado = perfilFixado;
	}

	public int sizeConversas() {
		return amigos.size() + grupos.size();
	}
}
