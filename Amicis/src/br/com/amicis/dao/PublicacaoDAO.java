package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Publicacao;
import br.com.amicis.model.Usuario;

public class PublicacaoDAO {

	public void save(Publicacao publicacao) {

		String sql = "INSERT INTO publicacao(usuario, texto, foto) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), ?, (SELECT foto FROM usuario WHERE this_usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, publicacao.getUsuario());
			pstm.setString(2, publicacao.getConteudo());
			pstm.setString(3, publicacao.getUsuario());
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
			pstm.setString(1, perfil.getThis_usuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Publicacao publicacao = new Publicacao(perfil);

				publicacao.setId(rset.getInt("id"));

				publicacao.setConteudo(rset.getString("texto"));
				publicacao.setData(rset.getDate("data"));
				publicacao.setFoto(rset.getString("foto"));
				RespostaDAO respostaDAO = new RespostaDAO();
				publicacao.setRespostas(respostaDAO.getRespostaData(publicacao));

				CoracaoDAO coracaoDAO = new CoracaoDAO();
				publicacao.setCoracoes(coracaoDAO.getCoracoes(publicacao));

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

	public ArrayList<Publicacao> getPublicacoesData() throws SQLException {
		String sql = "SELECT * FROM publicacao ORDER BY data DESC;";

		ArrayList<Publicacao> publicacoes = new ArrayList<Publicacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario1 = new Usuario();

				Publicacao publicacao = new Publicacao(usuario1.getPerfil());

				publicacao.setId(rset.getInt("id"));
				publicacao.setUsuario(rset.getString("usuario"));
				publicacao.setFoto(rset.getString("foto"));
				publicacao.setConteudo(rset.getString("texto"));
				publicacao.setData(rset.getDate("data"));

				RespostaDAO respostaDAO = new RespostaDAO();
				publicacao.setRespostas(respostaDAO.getRespostaData(publicacao));

				CoracaoDAO coracaoDAO = new CoracaoDAO();
				publicacao.setCoracoes(coracaoDAO.getCoracoes(publicacao));

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

	public void update(Publicacao publicacao) {
		String sql = "UPDATE publicacao SET texto = ? WHERE id = ?;";

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

	public void delete(Publicacao publicacao) {
		String sql = "DELETE FROM publicacao WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, publicacao.getId());

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
