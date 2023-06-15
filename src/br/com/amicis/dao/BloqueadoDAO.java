package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Usuario;

public class BloqueadoDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO bloqueados(perfil, bloqueado) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			for (int i = 0; i < perfil.sizeBloqueados(); i++) {
				// Criar uma conexão com o banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				// Criado uma preparedStatement para que a query seja executada

				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setString(1, perfil.getUsuario().getUsuario());
				pstm.setString(2, perfil.getBloqueado(i));

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
	
	
	public void saveIndividual(Usuario usuarioPrincipal, Usuario bloqueado) {

		String sql = "INSERT INTO bloqueados(perfil, bloqueado) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, usuarioPrincipal.getUsuario());
			pstm.setString(2, bloqueado.getUsuario());

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
	
	public ArrayList<String> getBloqueados(Perfil perfil) throws SQLException {
		String sql = "SELECT bloqueado FROM bloqueados WHERE perfil = ?;";

		ArrayList<String> bloqueados = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {
				bloqueados.add(rset.getString("bloqueado"));
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
		return bloqueados;
	}

	public void delete(Usuario perfil, Usuario bloqueado) {

		String sql = "DELETE FROM bloqueados WHERE perfil = ? AND bloqueado = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, perfil.getUsuario());
			pstm.setString(2, bloqueado.getUsuario());

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
