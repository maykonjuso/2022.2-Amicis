package br.com.amicis.main;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
	
		usuarioDAO.save(usuario);
	}
}
