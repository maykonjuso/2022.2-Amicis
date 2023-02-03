package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Conversa;
import br.com.amicis.model.Mensagem;
import br.com.amicis.model.Usuario;

public class MensagemDAO {

	public void save(Mensagem mensagem) {

		String sql = "INSERT INTO mensagem(usuario, foto, id_conversa, texto) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT foto FROM usuario WHERE this_usuario = ?), ?, ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, mensagem.getUsuario());
			pstm.setString(2, mensagem.getUsuario());
			pstm.setInt(3, mensagem.getId_conversa());
			pstm.setString(4, mensagem.getConteudo());
			
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

	public ArrayList<Mensagem> getMensagens(Usuario usuario, Conversa conversa) throws SQLException {
		String sql = "SELECT * FROM mensagem WHERE id_conversa = ? ORDER BY data ASC;";

		ArrayList<Mensagem> mensagens = new ArrayList<Mensagem>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, conversa.getId());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Mensagem mensagem = new Mensagem(usuario, conversa);

				mensagem.setId(rset.getInt("id"));
				mensagem.setConteudo(rset.getString("texto"));
				mensagem.setDate(rset.getDate("data"));
				mensagem.setFoto(rset.getString("foto"));

				mensagens.add(mensagem);
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
		return mensagens;
	}

	public void delete(Mensagem mensagem) {
		String sql = "DELETE FROM mensagem WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, mensagem.getId());

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
