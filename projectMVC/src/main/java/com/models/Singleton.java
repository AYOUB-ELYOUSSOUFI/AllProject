package com.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
	
	private static Connection instance;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");
		} catch (Exception e) {
			System.out.println("Problème de connexion");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return instance;
	}
}
