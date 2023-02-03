package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Notificacao;
import br.com.amicis.model.Usuario;

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

	public ArrayList<Notificacao> getNotificacao(Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM notificacao WHERE usuario = ?;";

		ArrayList<Notificacao> notificacoes = new ArrayList<Notificacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {
				Notificacao notificacao = new Notificacao(usuario.getPerfil());
				notificacao.setId(rset.getInt("id"));
				notificacao.setUsuario(rset.getString("usuario"));
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

	public void update(Notificacao notificacao) {
		String sql = "UPDATE notificacao SET conteudo = ? WHERE usuario = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, notificacao.getConteudo());
			pstm.setString(2, notificacao.getUsuario());

			pstm.executeUpdate();

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

	public void delete(Notificacao notificacao) {
		String sql = "DELETE FROM notificacao WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, notificacao.getId());
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
}
