package br.com.amicis.model;

import java.util.ArrayList;
import java.util.Date;

public class Publicacao {
	
	private int id;
	private Perfil perfil;
	private ArrayList<Publicacao> respostas;
	private String usuario;
	private String conteudo;
	private Date data;
	private ArrayList<String> coracoes;
	private String foto;

	public Publicacao(Perfil perfil) {
		this.setUsuario(perfil.getThis_usuario());
		this.setPerfil(perfil);
		respostas = new ArrayList<Publicacao>();
		coracoes = new ArrayList<String>();
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Publicacao> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<Publicacao> respostas) {
		this.respostas = respostas;
	}
	
	public void adicionarResposta(Publicacao publicacao) {
		respostas.add(publicacao);
	}
	public void removerResposta(Publicacao publicacao) {
		respostas.remove(publicacao);
	}
	public Publicacao getResposta(int posicao) {
		return respostas.get(posicao);
	}
	public int sizeRespostas() {
		return respostas.size();
	}

	public ArrayList<String> getCoracoes() {
		return coracoes;
	}

	public void setCoracoes(ArrayList<String> coracoes) {
		this.coracoes = coracoes;
	}
	
	public void adicionarCoracao(String nome) {
		coracoes.add(nome);
	}
	public void removerCoracao(String nome) {
		coracoes.remove(nome);
	}
	public String getCoracao(int posicao) {
		return coracoes.get(posicao);
	}
	
	
	public int sizeCoracoes() {
		return coracoes.size();
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}

