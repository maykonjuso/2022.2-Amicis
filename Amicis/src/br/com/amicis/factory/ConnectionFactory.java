package br.com.amicis.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	// Definindo o nome do usuário MySQL
	private static final String USERNAME = "root";
	
	// Definindo qual será a senha do banco
	private static final String PASSWORD = "Banco123";
	
	// Definindo qual será o caminho para o banco de dados porta e nome.
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Amicis";
	
	// conexão com o banco
	public static Connection createConnectionToMySQL() throws Exception {
		
		// faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		// cria conexão com o banco
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	} 

	public static void main(String[] args) throws Exception {
		// Recuperar a conexão com o banco se já existir
		Connection con = createConnectionToMySQL();
		
		// Testar se a conexão é nula
		if(con!=null) {
			// Caso não seja nula, ele fecha a anterior.
			System.out.println("Conexão realizada com sucesso. ");
			con.close();
		}
	}
}
