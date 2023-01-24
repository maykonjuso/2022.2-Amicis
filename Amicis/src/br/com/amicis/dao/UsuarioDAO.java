package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Usuario;

public class UsuarioDAO {

	public void save(Usuario usuario) {

		String sql = "INSERT INTO usuario(nome, sobrenome, this_usuario, telefone, email, senha, dataNascimento, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getUsuario());
			pstm.setString(4, usuario.getTelefone());
			pstm.setString(5, usuario.getEmail());
			pstm.setString(6, String.valueOf(usuario.getSenha()));
			// converter util.date para sql.Date
			java.util.Date utilDate = usuario.getDataNascimeto();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			pstm.setDate(7, sqlDate);
			PerfilDAO perfilDAO = new PerfilDAO();

			usuario.setFoto("https://abs.twimg.com/sticky/default_profile_images/default_profile_normal.png");

			pstm.setString(8, usuario.getFoto());

			// executando a query

			pstm.execute();

			if (perfilDAO != null) {
				perfilDAO.save(usuario.getPerfil());
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
	// Atualizar editarPerfil
	public void updatePerfil(Usuario usuario) throws Exception {
		String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, telefone = ?, email = ? WHERE this_usuario = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getTelefone());
			pstm.setString(4, usuario.getEmail());
			pstm.setString(5, usuario.getUsuario());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Atualizar a senha Configuracoes.java
	public void updateSenha(Usuario usuario) throws Exception {
		String sql = "UPDATE usuario SET senha = ? WHERE this_usuario = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, String.valueOf(usuario.getSenha()));
			pstm.setString(2, usuario.getUsuario());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(Usuario usuario) {

		String sql = "DELETE FROM usuario WHERE id = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setInt(1, usuario.getId());

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		}

		finally {

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Usuario> getUsuarios() throws SQLException {
		String sql = "SELECT * FROM usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();
				PerfilDAO perfilDAO = new PerfilDAO();
				ConversaDAO conversaDAO = new ConversaDAO();

				usuario.setNome(rset.getString("nome"));
				usuario.setSobrenome(rset.getString("sobrenome"));
				usuario.setUsuario(rset.getString("this_usuario"));
				usuario.setFoto(rset.getString("foto"));
				usuario.setDataCadastro(rset.getDate("dataCadastro"));
				usuario.setDataCadastro(rset.getDate("dataNascimento"));
				usuario.setTelefone(rset.getString("telefone"));
				usuario.setEmail(rset.getString("email"));

				String senha = rset.getString("senha");
				char[] cs = senha.toCharArray();
				usuario.setSenha(cs);

				usuario.setPerfil(perfilDAO.getPerfil(usuario));
				usuario.getPerfil().setConversas(conversaDAO.getConversa(usuario.getPerfil()));
				usuarios.add(usuario);
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
		return usuarios;
	}

	public ResultSet autenticacaoUsuario(Usuario usuario) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			String sql = "Select * from usuario where this_usuario = ? and senha = ?";
			PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getUsuario());
			pstm.setString(2, String.valueOf(usuario.getSenha()));
			ResultSet rset = pstm.executeQuery();
			return rset;
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
			return null;
		}
	}

	public Usuario getUsuario(String nome) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE this_usuario = ?;";
		Usuario usuario = new Usuario();
		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco.
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, nome);
			rset = pstm.executeQuery();

			while (rset.next()) {
				PerfilDAO perfilDAO = new PerfilDAO();
				ConversaDAO conversaDAO = new ConversaDAO();

				usuario.setNome(rset.getString("nome"));
				usuario.setSobrenome(rset.getString("sobrenome"));
				usuario.setUsuario(rset.getString("this_usuario"));
				usuario.setFoto(rset.getString("foto"));
				usuario.setDataCadastro(rset.getDate("dataCadastro"));
				usuario.setDataNascimeto(rset.getDate("dataNascimento"));
				usuario.setTelefone(rset.getString("telefone"));
				usuario.setEmail(rset.getString("email"));

				String senha = rset.getString("senha");
				char[] cs = senha.toCharArray();
				usuario.setSenha(cs);

				usuario.setPerfil(perfilDAO.getPerfil(usuario));
				usuario.getPerfil().setConversas(conversaDAO.getConversa(usuario.getPerfil()));
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
		return usuario;
	}
}