package br.com.clientes.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nome do usu�rio do MySQL
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "dtrpu98m";
	
	//Caminho do database, porta
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/clientes";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}

	public static void main(String[] args) throws Exception {
		
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			System.out.println("Conex�o obtida com sucesso");
			con.close();
		}
	}


}
