package com.message;

import java.sql.SQLException;

import com.db.ConnexionDB;

public class ListeMessages extends ConnexionDB{
	
	public ListeMessages(int idPersonne) {
		Lire("SELECT * FROM message WHERE idPersonne = "+idPersonne);
	}
	
	public String sujet() {
		try {
			return result.getString("sujet");
		} catch (SQLException e) {
			return "";
		}
	}
	
	public String texte() {
		try {
			return result.getString("texte");
		} catch (SQLException e) {
			return "";
		}
	}
}
