package model;

import java.sql.Date;
import java.util.ArrayList;

public class Grupo {
	
	private ArrayList<Perfil> integrantes;
	private Date dataCriacao;
	
	
	public void setIntegrantes(Perfil perfil) {
		integrantes.add(perfil);
	}
	public Perfil getIntegrante(int posicao) {
	return integrantes.get(posicao);
	
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	

}
