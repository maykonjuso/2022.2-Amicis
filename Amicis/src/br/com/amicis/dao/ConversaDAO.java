package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Conversa;
import br.com.amicis.model.Perfil;

public class ConversaDAO {

	public void save(Conversa conversa) {

		String sql = "INSERT INTO conversa(remetente, destinatario, texto) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?), ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, conversa.getRemetente());
			pstm.setString(2, conversa.getDestinatario());
			pstm.setString(3, conversa.getConteudo());

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

	public ArrayList<Conversa> getConversa(Perfil perfil) throws SQLException {
		String sql = "SELECT * FROM conversa WHERE remetente = ? and destinatario = ?";

		ArrayList<Conversa> conversas = new ArrayList<Conversa>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			for (int i = 0; i < perfil.sizeAmigos(); i++) {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setString(1, perfil.getThis_usuario());

				pstm.setString(2, perfil.getAmigo(i));

				rset = pstm.executeQuery();

				while (rset.next()) {

					Conversa conversa = new Conversa(perfil, i);
					conversa.setConteudo(rset.getString("texto"));
					conversa.setData(rset.getDate("data"));

					conversas.add(conversa);
				}
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
		return conversas;

	}
}
