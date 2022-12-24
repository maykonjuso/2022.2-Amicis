package br.com.amicis.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;

public class AmigoDAO {
	
	public void save(Perfil perfil) {
		
		String sql = "INSERT INTO Amigo(amigo) VALUES (?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criado uma preparedStatement para que a query seja executada
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			for (int i = 0; i < 2; i++) {
				pstm.setString(1, perfil.getAmigo(i).getUsuario().getNome());
			}
			
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
