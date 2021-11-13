package lv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private static Connection conexao = null;
	
	public static Connection getDbConnection() throws ClassNotFoundException {
		
		if (conexao != null) {
			return conexao;	
		}
		else {
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/ftt","root","12345678");
				//conexao = DriverManager.getConnection("jdbc:mysql://localhost/ftt","root","12345678");  João
				//conexao = DriverManager.getConnection("jdbc:mysql://localhost/ftt","root","12345678");  Vinicius
				//conexao = DriverManager.getConnection("jdbc:mysql://localhost/ftt","root","12345678");  Caio
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;	
	}

}
