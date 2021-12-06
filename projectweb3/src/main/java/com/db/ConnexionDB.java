package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {
	private Connection connection;
	private Statement statement;
	protected ResultSet result;

	public ConnexionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/messagrie","root","");
			statement = connection.createStatement();
		} catch (ClassNotFoundException ex) {
			System.err.println("Probleme de pilote");
		} catch (SQLException ex) {
			System.err.println("Bose de donnees non trouvéé ou requete incorrect");
		}
	}

	public void Lire(String req) {
		try {
			result = statement.executeQuery(req);
		} catch (SQLException ex) {
			System.err.println("Requete incorrect : " + req);
		}
	}

	public void miseAjour(String req) {
		try {
			statement.executeUpdate(req);
		} catch (Exception e) {
			System.err.println("Requete incorrect : " + req);
		}
	}

	public boolean suivant() {
		try {
			return result.next();
		} catch (SQLException e) {
			return false;
		}
	}

	public void arret() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Erreur sur l'arret de la connection à la base de donnees.");
		}
	}
}
