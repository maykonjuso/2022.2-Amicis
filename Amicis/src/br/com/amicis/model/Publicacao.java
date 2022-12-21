package br.com.amicis.model;
import java.util.Date;
public class Publicacao {
	
	private Perfil perfil;
	private String conteudo;
	private Date data;
	private boolean melhoresAmigos;
	private boolean coracao;
	
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isMelhoresAmigos() {
		return melhoresAmigos;
	}
	public void setMelhoresAmigos(boolean melhoresAmigos) {
		this.melhoresAmigos = melhoresAmigos;
	}
	
	public void colocarCoracao() {
		coracao = true;
	}
	
	public void retirarCoracao() {
		coracao = false;
	}
	
	public boolean enviar() {
		
	}
	
	public void excluir() {
		
	}
}
