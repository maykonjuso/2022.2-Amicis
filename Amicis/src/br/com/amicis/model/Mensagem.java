package br.com.amicis.model;

import java.util.Date;

public class Mensagem {

    private int Id;
    private Usuario usuario;
    private String conteudo;
    private Date date;
    
    public Mensagem(Usuario usuario) {
    	this.setUsuario(usuario);
    }
    
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}