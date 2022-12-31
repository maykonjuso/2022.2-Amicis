package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Notificacao;
import br.com.amicis.model.Perfil;

public class NotificacaoDAO {

	public void save(Notificacao notificacao) {

		String sql = "INSERT INTO notificacao(usuario, conteudo) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, notificacao.getUsuario());
			pstm.setString(2, notificacao.getConteudo());
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

	public ArrayList<Notificacao> getNotificacao(Perfil perfil) throws SQLException {
		String sql = "SELECT * FROM notificacao WHERE usuario = ?;";

		ArrayList<Notificacao> notificacoes = new ArrayList<Notificacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Notificacao notificacao = new Notificacao(perfil);

				notificacao.setConteudo(rset.getString("conteudo"));
				notificacao.setDataNoficacao(rset.getDate("data"));

				notificacoes.add(notificacao);
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
		return notificacoes;
	}

}
