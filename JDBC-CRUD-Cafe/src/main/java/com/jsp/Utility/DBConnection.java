package com.jsp.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static String url="jdbc:mysql://localhost:3306/jdbc_crud_cafe";
	static String username="root";
	static String password="root";
	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}