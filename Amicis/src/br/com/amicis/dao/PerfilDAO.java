package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;

public class PerfilDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO perfil(status_online, relacionamento, localidade, bio) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setBoolean(1, perfil.getStatus().getOnline());
			pstm.setString(2, perfil.getStatus().getRelacionamento());
			pstm.setString(3, perfil.getStatus().getLocalidade());
			pstm.setString(4, perfil.getBio());

			// executando a query
			pstm.execute();

			System.out.println("Perfil " + perfil.getUsuario().getUsuario() + " salvo com sucesso.");

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

	public List<Perfil> getPerfil() throws SQLException {
		String sql = "SELECT * FROM perfil";
		List<Perfil> perfis = new ArrayList<Perfil>();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Perfil perfil = new Perfil();

				// recuperar o id
				perfil.setBio(rset.getString("bio"));
				perfil.getStatus().setOnline(rset.getBoolean("status_online"));
				perfil.getStatus().setLocalidade(rset.getString("localidade"));
				perfil.getStatus().setRelacionamento(rset.getString("relacionamento"));

				perfis.add(perfil);
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
		return perfis;
	}

}
