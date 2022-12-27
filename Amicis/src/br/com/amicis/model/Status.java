package br.com.amicis.model;

public class Status {

	private boolean online;
	private String relacionamento;
	private String localidade;
	private Perfil perfil;
	
	

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public boolean getOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
}
