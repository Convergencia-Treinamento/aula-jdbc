package aulajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ExemploSqlInjection {

	
	private static final String PASSWORD = "123456";
	private static final String USER = "postgres";
	private static final String URL = "jdbc:postgresql:exemplojdbc";
	private static final String DRIVER = "org.postgresql.Driver";

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Login:");
			String login = scan.nextLine();
			
			System.out.print("Senha:");
			String senha = scan.nextLine();
			
//CODIGO VULNERAVEL			
//			Statement stmt = con.createStatement();
//			String sql = "select * from usuario where login = '"+login+"' and senha = '"+senha+"'";
//			System.out.println(sql);
//			ResultSet rs = stmt.executeQuery(sql);
			
			PreparedStatement pstmt = con.prepareStatement("select * from usuario where login = ? and senha = ?");
			pstmt.setString(1, login);
			pstmt.setString(2, senha);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				System.out.println("Usuario e senhas corretos. Acesso total;");
			}else {
				System.out.println("Usuario ou senha incorretos");
			}
			
		} catch(Exception e) {
			// TODO: handle finally clause
		}
		
	}
	
}
