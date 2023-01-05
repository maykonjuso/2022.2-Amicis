package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Usuario;

public class UsuarioDAO {

	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuario(nome, sobrenome, this_usuario, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getUsuario());
			pstm.setString(4, usuario.getTelefone());
			pstm.setString(5, usuario.getEmail());
			pstm.setString(6, String.valueOf(usuario.getSenha()));

			PerfilDAO perfilDAO = new PerfilDAO();

			// executando a query

			pstm.execute();
			System.out.println("Usuário " + usuario.getUsuario() + " salvo com sucesso.");

			if (perfilDAO != null) {
				perfilDAO.save(usuario.getPerfil());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> getUsuarios() throws SQLException {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();
				PerfilDAO perfilDAO = new PerfilDAO();
				ConversaDAO conversaDAO = new ConversaDAO();

				usuario.setNome(rset.getString("nome"));
				usuario.setSobrenome(rset.getString("sobrenome"));
				usuario.setUsuario(rset.getString("this_usuario"));
				usuario.setDataCadastro(rset.getDate("dataCadastro"));
				usuario.setDataCadastro(rset.getDate("dataNascimento"));
				usuario.setTelefone(rset.getString("telefone"));
				usuario.setEmail(rset.getString("email"));
				
				String senha = rset.getString("senha");
				char [] cs = senha.toCharArray();
				usuario.setSenha(cs);
				
				usuario.setPerfil(perfilDAO.getPerfil(usuario));
				usuario.getPerfil().setConversas(conversaDAO.getConversa(usuario.getPerfil()));
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rset != null) {
					rset.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
}
