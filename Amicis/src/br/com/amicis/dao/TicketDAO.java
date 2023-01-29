package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Ticket;
import br.com.amicis.model.Usuario;

public class TicketDAO {

	//Criacao do ticket
	public void save(Ticket ticket){
		//inserir

		String sql = "INSERT INTO ticket(usuario, conteudo, severidade, protocolo) VALUES ((SELECT this_usuario FROM usuario WHERE this_usuario = ?), ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, ticket.getUsuario());
			
			pstm.setString(2, ticket.getConteudo());
			
			pstm.setString(3, ticket.getSeveridade());
			
			pstm.setDouble(4, ticket.getProtocolo());

			pstm.execute();

		}catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Leitura dos dados do ticket
	public ArrayList<Ticket> getTickets(Usuario usuario){
		String sql	= "SELECT * FROM ticket WHERE usuario = ?";

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Ticket ticket = new Ticket(usuario);

				ticket.setStatus(rset.getString("status"));
				ticket.setProtocolo(rset.getInt("protocolo"));
				ticket.setConteudo(rset.getString("conteudo"));
				ticket.setData(rset.getDate("data"));
				ticket.setSeveridade(rset.getString("severidade"));
				tickets.add(ticket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if(rset != null) {
					rset.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tickets;
	}
	
	public void update(Ticket ticket) {
		String sql = "UPDATE ticket SET status = ?, severidade = ?, conteudo = ? WHERE protocolo = ?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, ticket.getStatus());
			pstm.setString(2, ticket.getSeveridade());
			pstm.setString(3, ticket.getConteudo());
			pstm.setDouble(4, ticket.getProtocolo());
			
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
	public void delete(Ticket ticket) {
		String sql = "DELETE FROM ticket WHERE protocolo = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, ticket.getUsuario());
			pstm.setDouble(2, ticket.getProtocolo());
			
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