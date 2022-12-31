package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Publicacao;

public class PublicacaoDAO {

	public void save(Publicacao publicacao) {

		String sql = "INSERT INTO publicacao(usuario, texto, coracao) VALUES ((SELECT usuario FROM perfil WHERE usuario = (?)), ?, ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, publicacao.getUsuario());
			pstm.setString(2, publicacao.getConteudo());
			pstm.setInt(3, publicacao.getCoracao());
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

	public ArrayList<Publicacao> getPublicacoes(Perfil perfil) throws SQLException {
		String sql = "SELECT * FROM publicacao WHERE usuario = ?;";

		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Publicacao publicacao = new Publicacao(perfil);

				publicacao.setConteudo(rset.getString("texto"));
				publicacao.setCoracao(rset.getInt("coracao"));

				publicacoes.add(publicacao);
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
		return publicacoes;
	}

}
