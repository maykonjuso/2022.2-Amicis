package model;

import java.util.ArrayList;
import java.util.Date;

public class Amigo {

	private Perfil perfil;
	private Date tempoAmizadeDate;
	private ArrayList<Amigo> amigosComums;
	
	public Amigo() {
		amigosComums = new ArrayList<Amigo>();
	}
	
	public void adicionarAmigosComuns(Amigo amigo) {
		amigosComums.add(amigo);
	}
	
	public void removerAmigosComuns(Amigo amigo) {
		amigosComums.remove(amigo);
	}
	
	public Amigo getAmigosComuns(int posicao) {
		return amigosComums.get(posicao);
	}
	
	public int qtdAmigosComuns() {
		return amigosComums.size();
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Date getTempoAmizadeDate() {
		return tempoAmizadeDate;
	}

	public void setTempoAmizadeDate(Date tempoAmizadeDate) {
		this.tempoAmizadeDate = tempoAmizadeDate;
	}

	public boolean enviarMensagem() {
		
	}
	
	public boolean responderMensagem() {
		
	}
}
