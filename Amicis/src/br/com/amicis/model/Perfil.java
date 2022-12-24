package br.com.amicis.model;
import java.util.*;

public class Perfil {
	
	private String nome;
	private String usuario;
	private Date dataNascimento;
	private Date dataIngresso;
	private Boolean melhorAmigo;
	private ArrayList<Perfil> melhoresAmigos;
	private Foto foto;
	
	public Perfil() {
		melhoresAmigos = new ArrayList<Perfil>();
	}
	
	public void adicionarMelhorAmigo(Perfil melhorAmigo) {
		melhoresAmigos.add(melhorAmigo);
	}
	public Perfil getMelhorAmigo(int posicao) {
		return melhoresAmigos.get(posicao);
	}
	public void removerMelhorAmigo(Perfil melhorAmigo) {
		melhoresAmigos.remove(melhorAmigo);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getDataIngresso() {
		return dataIngresso;
	}
	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	
	public boolean pedirParaSeguir() {
		
	}
	
	public boolean deixarDeSeguir() {
		
	}
	
	public boolean mudarStatus() {
		
	}
	
	public boolean adicionarMelhorAmigo() {
		
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getMelhorAmigo() {
		return melhorAmigo;
	}

	public void setMelhorAmigo(Boolean melhorAmigo) {
		this.melhorAmigo = melhorAmigo;
	}
}
