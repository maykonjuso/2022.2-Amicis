package br.com.amicis.main;

import java.sql.SQLException;

import br.com.amicis.dao.AmigoDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Executar {

	public static void main(String[] args) throws SQLException {

		// para salvar os dados no banco

		AmigoDAO amigoDAO = new AmigoDAO();
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		Usuario usuario3 = new Usuario();
		Usuario usuario4 = new Usuario();

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		usuario1.setUsuario("maykona");
		usuario2.setUsuario("pedro");
		usuario3.setUsuario("paulo");
		usuario4.setUsuario("mauricio");
		usuario1.getPerfil().setBio("salve");
		usuario1.getPerfil().getStatus().setLocalidade("japão");

		usuario1.getPerfil().adicionarAmigo(usuario2.getPerfil());
		usuario1.getPerfil().adicionarAmigo(usuario3.getPerfil());
		usuario1.getPerfil().adicionarAmigo(usuario4.getPerfil());

		usuarioDAO.save(usuario1);
		usuarioDAO.save(usuario2);
		usuarioDAO.save(usuario3);
		usuarioDAO.save(usuario4);

		amigoDAO.save(usuario1.getPerfil());

		usuario2.getPerfil().setAmigos(amigoDAO.getAmigos(usuario1.getPerfil()));

		amigoDAO.save(usuario2.getPerfil());

		// para listar os dados no banco
//

//		for (Usuario usuario : usuarioDAO.getUsuarios()) {
//			System.out.println(usuario.getUsuario());
//		}

	}

}
