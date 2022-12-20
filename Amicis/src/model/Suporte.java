package model;

import java.util.ArrayList;

public class Suporte {
	private ArrayList<Ticket> tickets;
	private String politicas;
	
	public void adicionarTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void removerTicket(Ticket ticket) {
		tickets.remove(ticket);
	}
	
	public int sizeTicket() {
		return tickets.size();
	}
	
	public Ticket getTicket(int posicao) {
		return tickets.get(posicao);
	}
	
	public String getPoliticas() {
		return politicas;
	}

	public void setPoliticas(String politicas) {
		this.politicas = politicas;
	}

	public boolean criarTicket() {
		
	}
	
	public boolean editarTicket() {
		
	}
	
	public boolean excluirTicket() {
		
	}
}
