package br.com.amicis.model;

import java.util.Date;

public class Mensagem {


	private int Id;
	private int id_conversa;
    private String foto;
    private String usuario;
    private String conteudo;
    private Date date;
    
    public Mensagem(Usuario usuario, Conversa conversa) {
    	this.setUsuario(usuario.getUsuario());
    	this.setFoto(usuario.getFoto());
    	this.setId_conversa(conversa.getId());
    }
    
    public int getId_conversa() {
		return id_conversa;
	}

	public void setId_conversa(int id_publicacao) {
		this.id_conversa = id_publicacao;
	}

	public String getFoto() {
    	return foto;
    }
    
    public void setFoto(String foto) {
    	this.foto = foto;
    }
    
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
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