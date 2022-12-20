package model;

import java.util.ArrayList;
import java.util.Date;

public class Seguidor {
	private ArrayList<Perfil> seguidores;
	private Date tempoSeguindo;
	
	public Seguidor() {
		seguidores = new ArrayList<Perfil>();
	}
	
	public void adicionarSeguidor(Perfil seguidor) {
		seguidores.add(seguidor);
	}
	
	public void removerSeguidor(Perfil seguidor) {
		seguidores.remove(seguidor);
	}
	
	public Date getTempoSeguindo() {
		return tempoSeguindo;
	}

	public void setTempoSeguindo(Date tempoSeguindo) {
		this.tempoSeguindo = tempoSeguindo;
	}

	public boolean removerSeguidor() {
		
	}
	
	public boolean bloquear() {
		
	}
	
	public boolean seguir() {
		
	}
}
