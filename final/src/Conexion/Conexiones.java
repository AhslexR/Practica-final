package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexiones {
	
	public static Connection getConnection() {
		
		java.sql.Connection conexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcshop", "root", "root");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conexion;
	}	
		
}