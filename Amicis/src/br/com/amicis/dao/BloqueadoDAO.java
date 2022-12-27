package br.com.amicis.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import br.com.amicis.factory.ConnectionFactory;
import br.com.amicis.model.Perfil;

public class BloqueadoDAO {

	public void save(Perfil perfil) {

		String sql = "INSERT INTO amigo(id_perfil, id_bloqueado) VALUES ((SELECT id FROM usuario WHERE nome = (?)), (SELECT id FROM usuario WHERE nome = (?)));";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			for (int i = 0; i < perfil.sizeBloqueado(); i++) {

				// Criar uma conexão com o banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				// Criado uma preparedStatement para que a query seja executada

				pstm = (PreparedStatement) conn.prepareStatement(sql);

				pstm.setString(1, perfil.getUsuario().getUsuario());
				pstm.setString(2, perfil.getBloqueado(i).getUsuario().getUsuario());

				// executando a query
				pstm.execute();

				System.out.println(perfil.getUsuario().getUsuario() + " bloqueou "
						+ perfil.getBloqueado(i).getUsuario().getUsuario() + " com sucesso.");

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
}
