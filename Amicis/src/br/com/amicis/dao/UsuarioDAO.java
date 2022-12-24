package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Usuario;

public class UsuarioDAO {
	
	public void save(Usuario usuario) {
		
		String sql = "INSERT INTO usuario(nome, sobrenome, this_usuario, data_cadastro, data_nascimento, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
			pstm.setDate(4, new Date(usuario.getDataCadastro().getTime()));
			pstm.setDate(5, new Date(usuario.getDataNascimeto().getTime()));
			pstm.setString(6, usuario.getTelefone());
			pstm.setString(7, usuario.getEmail());
			pstm.setString(8, usuario.getSenha());
			
			// executando a query
			pstm.execute();
			
			System.out.println("Conexão realizada com sucesso.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if(pstm!=null) {
				pstm.close();
			}
			if (conn!=null) {
				conn.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
