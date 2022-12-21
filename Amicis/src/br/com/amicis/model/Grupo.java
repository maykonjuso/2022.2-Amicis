package br.com.amicis.model;

import java.sql.Date;
import java.util.ArrayList;

public class Grupo {
	
	private ArrayList<Perfil> integrantes;
	private Date dataCriacao;
	
	public void setIntegrantes(Perfil perfil) {
		integrantes.add(perfil);
	}
	
	public void removeIntegrantes(Perfil perfil) {
		integrantes.remove(perfil);
	}
	
	public Perfil getIntegrantes(int posicao) {
		return integrantes.get(posicao);
	}
	
	public int sizeIntegrantes() {
		return integrantes.size();
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	

}
