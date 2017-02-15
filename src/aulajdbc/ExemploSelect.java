package aulajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExemploSelect {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("org.postgresql.Driver");
		
		try (Connection con = DriverManager.getConnection("jdbc:postgresql:exemplojdbc", "postgres", "123456")) {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from contato");
			while(rs.next()){
				System.out.printf("%5d %-20s %-20s\n", rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
