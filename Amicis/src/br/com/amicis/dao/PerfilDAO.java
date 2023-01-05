package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;
import br.com.amicis.model.Usuario;

public class PerfilDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO perfil(status_online, relacionamento, localidade, bio, usuario, termos_uso, politicas) VALUES (?, ?, ?, ?, (SELECT this_usuario FROM usuario WHERE this_usuario = ?), ?, ?);";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setBoolean(1, perfil.getStatus().getOnline());
			pstm.setString(2, perfil.getStatus().getRelacionamento());
			pstm.setString(3, perfil.getStatus().getLocalidade());
			pstm.setString(4, perfil.getBio());
			pstm.setString(5, perfil.getUsuario().getUsuario());
			pstm.setString(6, perfil.getContrato().getTermosUso());
			pstm.setString(7, perfil.getSuporte().getPoliticas());

			// executando a query
			pstm.execute();
			System.out.println("Perfil " + perfil.getUsuario().getUsuario() + " salvo com sucesso.");

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

	public Perfil getPerfil(Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM perfil WHERE usuario = ?;";
		Perfil perfil = new Perfil();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			rset = pstm.executeQuery();

			while (rset.next()) {
				AmigoDAO amigoDAO = new AmigoDAO();
				BloqueadoDAO bloqueadoDAO = new BloqueadoDAO();
				PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
				NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
				TicketDAO ticketDAO = new TicketDAO();

				perfil.setBio(rset.getString("bio"));
				perfil.getStatus().setOnline(rset.getBoolean("status_online"));
				perfil.getStatus().setLocalidade(rset.getString("localidade"));
				perfil.getStatus().setRelacionamento(rset.getString("relacionamento"));
				perfil.setThis_usuario(rset.getString("usuario"));

				perfil.setAmigos(amigoDAO.getAmigos(usuario.getPerfil()));
				perfil.setBloqueados(bloqueadoDAO.getBloqueados(usuario.getPerfil()));
				perfil.setBloqueados(bloqueadoDAO.getBloqueados(usuario.getPerfil()));
				perfil.setPublicacoes(publicacaoDAO.getPublicacoes(usuario.getPerfil()));
				perfil.setNotificacoes(notificacaoDAO.getNotificacao(usuario.getPerfil()));
				perfil.getSuporte().setTicket(ticketDAO.getTickets(usuario.getPerfil()));
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
		return perfil;
	}

	public void update(Perfil perfil) {
		String sql = "UPDATE perfil SET status_online = ?, relacionamento = ?, localidade = ?, bio = ?, termos_uso = ?, politicas = ? WHERE usuario = ?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setBoolean(1, perfil.getStatus().getOnline());
			pstm.setString(2, perfil.getStatus().getRelacionamento());
			pstm.setString(3, perfil.getStatus().getLocalidade());
			pstm.setString(4, perfil.getBio());
			pstm.setString(5, perfil.getContrato().getTermosUso());
			pstm.setString(6, perfil.getSuporte().getPoliticas());
			pstm.setString(7, perfil.getUsuario().getUsuario());

			pstm.executeUpdate();
			System.out.println("Perfil " + perfil.getUsuario().getUsuario() + " atualizado com sucesso.");

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
	public void delete(Perfil perfil) {
		String sql = "DELETE FROM perfil WHERE usuario = ?;";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, perfil.getUsuario().getUsuario());

			pstm.execute();
			System.out.println("Perfil " + perfil.getUsuario().getUsuario() + " excluído com sucesso.");

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
