package br.senac.pi.orlando;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_tempoedinheiro",
				"root", "Generation32");
	
	}
	public static void main(String[] args) throws Exception {
		connect();
		System.out.println("Conectado!");
	}
	
}
