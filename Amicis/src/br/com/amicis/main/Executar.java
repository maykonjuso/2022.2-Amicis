package br.com.amicis.main;

import br.com.amicis.dao.AmigoDAO;
import br.com.amicis.dao.PerfilDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Executar {

	public static void main(String[] args) {
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuario1.setUsuario("maykon");
		usuario2.setUsuario("pedro");
		usuario3.setUsuario("paulo");
		usuario1.getPerfil().setBio("salve");
		usuario1.getPerfil().getStatus().setLocalidade("japão");
		
		AmigoDAO amigoDAO = new AmigoDAO();
		
		usuario1.getPerfil().adicionarAmigo(usuario2.getPerfil());
		usuario1.getPerfil().adicionarAmigo(usuario3.getPerfil());
		
		usuarioDAO.save(usuario1);
		usuarioDAO.save(usuario2);
		usuarioDAO.save(usuario3);
		
		amigoDAO.save(usuario1.getPerfil());
	}

}
