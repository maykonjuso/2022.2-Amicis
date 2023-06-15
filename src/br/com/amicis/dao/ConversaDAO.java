package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Conversa;
import br.com.amicis.model.Usuario;

public class ConversaDAO {

	public void save(Conversa conversa) {

		String sql = "INSERT INTO conversa(remetente, destinatario) VALUES ((SELECT usuario FROM perfil WHERE usuario = ?),"
				+ " (SELECT usuario FROM perfil WHERE usuario = ?));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, conversa.getPerfil().getUsuario());
			pstm.setString(2, conversa.getAmigo().getUsuario());
			
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

	public void delete(int id) {
	
		String sql = "DELETE FROM conversa WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, id);
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

	
	public Conversa getConversaUnica(Usuario usuario, Usuario amigo) throws SQLException {
		String sql = "SELECT * FROM conversa WHERE remetente = ? and destinatario = ?";
		Conversa conversa = new Conversa(usuario, amigo);					
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, usuario.getUsuario());
				pstm.setString(2, amigo.getUsuario());
				rset = pstm.executeQuery();
				while (rset.next()) {
					conversa.setPerfil(usuario);
					conversa.setAmigo(amigo);
					conversa.setId(rset.getInt("id"));
					MensagemDAO mensagemDAO = new MensagemDAO();
					conversa.setMensagens(mensagemDAO.getMensagens(usuario, conversa));
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
		return conversa;
	}
	
	public List<Conversa> getConversas(Usuario usuario, Usuario amigo) throws SQLException {
		String sql = "SELECT * FROM conversa WHERE remetente = ? and destinatario = ?";
		List<Conversa> conversas = new ArrayList<Conversa>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, usuario.getUsuario());
				pstm.setString(2, amigo.getUsuario());
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					Conversa conversa = new Conversa(usuario, amigo);					
					conversa.setPerfil(usuario);
					conversa.setAmigo(amigo);
					conversa.setId(rset.getInt("id"));
					MensagemDAO mensagemDAO = new MensagemDAO();
					conversa.setMensagens(mensagemDAO.getMensagens(usuario, conversa));
					conversas.add(conversa);
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
