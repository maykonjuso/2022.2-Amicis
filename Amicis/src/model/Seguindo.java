package model;

import java.util.ArrayList;
import java.util.Date;

public class Seguindo {
	private ArrayList<Perfil> seguindo;
	private Date tempoSeguindo;
	
	public void adicionarSeguindo(Perfil seguindo) {
		this.seguindo.add(seguindo);
	}
	
	public void removerSeguindo(Perfil seguindo) {
		this.seguindo.remove(seguindo);
	}
	
	public int sizeSeguindo() {
		return this.seguindo.size();
	}
	
	public Perfil getSeguindo(int posicao) {
		return seguindo.get(posicao);
	}
	
	public Date getTempoSeguindo() {
		return tempoSeguindo;
	}

	public void setTempoSeguindo(Date tempoSeguindo) {
		this.tempoSeguindo = tempoSeguindo;
	}

	public boolean deixarSeguir() {
		
	}
	
	public boolean bloquear() {
		
	}
}
