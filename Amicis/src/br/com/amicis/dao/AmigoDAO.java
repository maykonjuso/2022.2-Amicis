package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Usuario;

public class AmigoDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO amigos(perfil, amigo) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			for (int i = 0; i < perfil.sizeAmigos(); i++) {
				// Criar uma conexão com o banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				// Criado uma preparedStatement para que a query seja executada

				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setString(1, perfil.getUsuario().getUsuario());
				pstm.setString(2, perfil.getAmigo(i));

				// executando a query
				pstm.execute();

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
	
	public void saveIndividual(Usuario usuarioPrincipal, Usuario amigo) {

		String sql = "INSERT INTO amigos(perfil, amigo) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, usuarioPrincipal.getUsuario());
			pstm.setString(2, amigo.getUsuario());

			// executando a query
			pstm.execute();
			
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

	public ArrayList<String> getAmigos(Perfil perfil) throws SQLException {
		String sql = "SELECT amigo FROM amigos WHERE perfil = ?;";

		ArrayList<String> amigos = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {
				amigos.add(rset.getString("amigo"));
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
		return amigos;
	}
	
	public List<Usuario> getAmigosPerfil(Usuario usuario) throws SQLException {
		String sql = "SELECT amigo FROM amigos WHERE perfil = ?;";

		List<Usuario> amigos = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				amigos.add(usuarioDAO.getUsuario(rset.getString("amigo")));		
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
		return amigos;
	}

	
	public void delete(Usuario perfil, Usuario amigo) {

		String sql = "DELETE FROM amigos WHERE perfil = ? AND amigo = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, perfil.getUsuario());
			pstm.setString(2, amigo.getUsuario());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
