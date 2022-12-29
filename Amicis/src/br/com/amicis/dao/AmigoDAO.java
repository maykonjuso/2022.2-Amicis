package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;

public class AmigoDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO amigos(perfil, amigo) VALUES ((SELECT this_usuario FROM usuario WHERE this_usuario = (?)), (SELECT this_usuario FROM usuario WHERE this_usuario = (?)));";
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

				System.out.println(perfil.getUsuario().getUsuario() + " fez amizade com "
						+ perfil.getAmigo(i) + " com sucesso.");
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

	public ArrayList<String> getAmigos(Perfil perfil) throws SQLException {
		String sql = "SELECT amigo FROM amigos WHERE perfil = ?;";
		
		ArrayList<String> amigos = new ArrayList<String>();
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

}
