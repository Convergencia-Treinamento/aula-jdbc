package aulajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploInsert {

	public static void inserir() throws ClassNotFoundException, ExceptionJdbc{
		Class.forName("org.postgresql.Driver");
		
		try (Connection con = DriverManager.getConnection("jdbc:postgresql:exemplojdbc", "postgres", "123456")){
			
			Statement stmt = con.createStatement();
			stmt.executeQuery("insert into contato (telefone) values ('3232-1212')");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionJdbc();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			inserir();
		} catch (ExceptionJdbc e) {
			e.printStackTrace();
		}
	}

}
