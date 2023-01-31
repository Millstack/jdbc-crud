package com.jsp.ConnectionTest;

import java.sql.Connection;

import com.jsp.Utility.DBConnection;

public class ConnectionTest {
	
	public static void main(String[] args) {

		Connection con = DBConnection.getConnection();
		if(con != null) {
			System.out.println("connection started");
		} else System.out.println("connection failed");
	}
}
