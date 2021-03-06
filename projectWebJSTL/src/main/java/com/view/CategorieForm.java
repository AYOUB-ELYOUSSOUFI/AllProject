package com.view;

import java.util.List;

import com.models.Categorie;

public class CategorieForm {
	
	private long idCat;
	private String motCle="";
	private String nomCat;
	private String description;
	private List<Categorie> LesCategories;
	
	public long getIdCat() {
		return idCat;
	}
	public void setIdCat(long idCat) {
		this.idCat = idCat;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Categorie> getLesCategories() {
		return LesCategories;
	}
	public void setLesCategories(List<Categorie> lesCategories) {
		this.LesCategories = lesCategories;
	}
	
	public CategorieForm() {}
}
