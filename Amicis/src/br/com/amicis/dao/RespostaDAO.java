package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Publicacao;
import br.com.amicis.model.Usuario;

public class RespostaDAO {

	public void save(Publicacao publicacao, Publicacao resposta) {

		String sql = "INSERT INTO resposta(usuario, foto, id_publicacao, texto) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT foto FROM usuario WHERE this_usuario = ?), ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, resposta.getUsuario());
			pstm.setString(2, resposta.getUsuario());
			pstm.setInt(3, publicacao.getId());
			pstm.setString(4, resposta.getConteudo());

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

	public void update(Publicacao publicacao) {
		String sql = "UPDATE resposta SET texto = ? WHERE id = ?;";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, publicacao.getConteudo());

			pstm.setInt(2, publicacao.getId());

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

	public ArrayList<Publicacao> getRespostaData(Publicacao publicacao) throws SQLException {
		String sql = "SELECT * FROM resposta WHERE id_publicacao = ? ORDER BY data DESC;";

		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, publicacao.getId());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Usuario usuario1 = new Usuario();

				Publicacao resposta = new Publicacao(usuario1.getPerfil());

				resposta.setId(rset.getInt("id"));
				resposta.setUsuario(rset.getString("usuario"));
				resposta.setFoto(rset.getString("foto"));
				resposta.setConteudo(rset.getString("texto"));
				resposta.setData(rset.getDate("data"));

				publicacoes.add(resposta);
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

	public void delete(int id) {
		String sql = "DELETE FROM publicacao WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);

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
