package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Conversa;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Usuario;

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
	
	public void update(Conversa conversa) {
		
		String sql = "UPDATE conversa SET remetente = ?, destinatario = ?, texto = ? WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			pstm.setString(1, conversa.getRemetente());
			pstm.setString(2, conversa.getDestinatario());
			pstm.setString(3, conversa.getConteudo());
			pstm.setInt(4, conversa.getId());
			
			pstm.execute();
			
		}
		
		catch (Exception e) {
			
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

	public ArrayList<Conversa> getConversa(Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM conversa WHERE remetente = ? and destinatario = ?";

		ArrayList<Conversa> conversas = new ArrayList<Conversa>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			for (int i = 0; i < usuario.getPerfil().sizeAmigos(); i++) {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setString(1, usuario.getPerfil().getThis_usuario());

				pstm.setString(2, usuario.getPerfil().getAmigo(i));

				rset = pstm.executeQuery();

				while (rset.next()) {
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					
					Usuario amigo = usuarioDAO.getUsuario(usuario.getPerfil().getAmigo(i));
					
					Conversa conversa = new Conversa(usuario, amigo);
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
