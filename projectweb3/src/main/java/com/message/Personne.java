package com.message;

import com.db.ConnexionDB;

public class Personne extends ConnexionDB {
	private String nom;
	private String prenom;
	private String motDePass;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.toUpperCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1, prenom.length()).toLowerCase();
	}

	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public Personne() {
	}

	public boolean enregister() {
		if(existedeja()) {
			return false;
		}else {
			miseAjour("INSERT INTO personne (nom,prenom,motDePass) values ('"+nom+"','"+prenom+"','"+motDePass+"')");
			return true;
		}
	}
	public boolean existedeja() {
		Lire("SELECT * FROM personne WHERE nom = '" + nom + "' AND prenom = '" + prenom + "'");
		return suivant();
	}

}
