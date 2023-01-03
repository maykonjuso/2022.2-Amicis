package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Ticket;

public class TicketDAO {

	//Criacao do ticket
	public void save(Ticket ticket){
		//inserir

		String sql = "INSERT INTO ticket(usuario, status, protocolo, severidade) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, ticket.getUsuario());
			pstm.setString(2, ticket.getStatus());
			pstm.setDouble(3, ticket.getProtocolo());
			pstm.setString(4, ticket.getSeveridade());

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
	public ArrayList<Ticket> getTickets(Perfil perfil){
		String sql	= "SELECT * FROM ticket WHERE usuario = ?";

		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {

				Ticket ticket = new Ticket(perfil);

				ticket.setStatus(rset.getString("status"));
				ticket.setProtocolo(rset.getDouble("protocolo"));
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
}