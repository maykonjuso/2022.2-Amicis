package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Publicacao;

public class RespostaDAO {

	public void save(Publicacao publicacao) {

		String sql = "INSERT INTO resposta(id_publicacao, usuario, texto) VALUES ((SELECT id FROM publicacao WHERE id = ?), (SELECT usuario FROM perfil WHERE usuario = ?), ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, publicacao.getId());
			pstm.setString(2, publicacao.getUsuario());
			pstm.setString(3, publicacao.getConteudo());
			
			CoracaoDAO coracaoDAO = new CoracaoDAO();
			coracaoDAO.save(publicacao);
			
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

	public ArrayList<Publicacao> getRespostas(Publicacao publicacao) throws SQLException {
		String sql = "SELECT * FROM resposta WHERE usuario = ?;";

		ArrayList<Publicacao> Respostas = new ArrayList<Publicacao>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, publicacao.getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Publicacao resposta = new Publicacao(publicacao.getPerfil());
				resposta.setId(rset.getInt("id"));
				resposta.setConteudo(rset.getString("texto"));

				CoracaoDAO coracaoDAO = new CoracaoDAO();
				publicacao.setCoracoes(coracaoDAO.getCoracoes(publicacao));
				
				Respostas.add(resposta);
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
		return Respostas;
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
