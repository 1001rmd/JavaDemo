package main;

//This class will handle all data transfer to the SQL database

import java.sql.*;

public class DB {

	private final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost:3306/test";
	
	public boolean connect() {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, "root", "toor");
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM orders");
			
			while(r.next()) {
				System.out.println(r.getString(1) + " " + r.getString(2) + " " + r.getString(3));
			}
			
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
}
