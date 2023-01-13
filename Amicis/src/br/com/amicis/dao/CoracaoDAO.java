package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Publicacao;

public class CoracaoDAO {

	public void save(Publicacao publicacao) {

		String sql = "INSERT INTO amigos(id, amigo) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?), (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			for (int i = 0; i < publicacao.sizeCoracoes(); i++) {
				// Criar uma conexão com o banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				// Criado uma preparedStatement para que a query seja executada

				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setInt(1, publicacao.getId());
				pstm.setString(2, publicacao.getCoracao(i));

				// executando a query
				pstm.execute();
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

	public ArrayList<String> getCoracoes(Publicacao publicacao) throws SQLException {
		String sql = "SELECT amigo FROM coracoes WHERE id_publicacao = ?;";

		ArrayList<String> coracoes = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, publicacao.getId());
			rset = pstm.executeQuery();

			while (rset.next()) {
				coracoes.add(rset.getString("amigo"));
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
		return coracoes;
	}
	
	public void delete(Publicacao publicacao, Perfil perfil) {
		
		String sql = "DELETE FROM coracoes WHERE id = ? AND amigo = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, publicacao.getId());
			pstm.setString(2, perfil.getThis_usuario());
			
			pstm.execute();
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
