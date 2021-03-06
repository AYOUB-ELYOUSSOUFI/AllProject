package com.view;

import java.util.ArrayList;


import com.models.Categorie;

public class CategorieForm {
	private Long idCategorie;
	private String motCle = "";
	private String nomCategorie;
	private String description;
	private ArrayList<Categorie> lesCategories = new ArrayList<>();
	
	
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Categorie> getLesCategories() {
		return lesCategories;
	}
	public void setLesCategories(ArrayList<Categorie> lesCategories) {
		this.lesCategories = lesCategories;
	}
	
	public CategorieForm() {}
}
