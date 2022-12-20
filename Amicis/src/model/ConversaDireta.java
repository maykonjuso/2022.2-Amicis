package model;

import java.util.ArrayList;

public class ConversaDireta {
	
	private Perfil conversaFixada;
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
	
	public int sizeConversas() {
		return amigos.size() + grupos.size();
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
	
	public Perfil getConversaFixada() {
		return conversaFixada;
	}

	public void setConversaFixada(Perfil conversaFixada) {
		this.conversaFixada = conversaFixada;
	}
	
	public boolean responder() {
		
	}
	
	public boolean apagarConversa() {
		
	}
	
	public boolean novaConversa() {
		
	}
	public boolean criarGrupo(){
		
	}
}
