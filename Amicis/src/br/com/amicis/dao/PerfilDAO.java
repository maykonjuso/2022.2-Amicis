package br.com.amicis.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;

public class PerfilDAO {
	
	public void save(Perfil perfil) {
		
		String sql = "INSERT INTO perfil(nome, usuario, melhores_amigos, data_cadastro) VALUES (?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.
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
