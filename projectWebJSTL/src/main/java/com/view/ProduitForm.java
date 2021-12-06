package com.view;

import java.util.List;

import com.models.Categorie;
import com.models.Produit;

public class ProduitForm {
	private long id;
	private String motClePr;
	private String description;
	private double prix;
	private int quantite;
	private int srd;
	private List<Produit> LesProduits;
	private List<Categorie> lesCategories;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMotClePr() {
		return motClePr;
	}
	public void setMotClePr(String motClePr) {
		this.motClePr = motClePr;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getSrd() {
		return srd;
	}
	public void setSrd(int srd) {
		this.srd = srd;
	}
	public List<Produit> getLesProduits() {
		return LesProduits;
	}
	public void setLesProduits(List<Produit> lesProduits) {
		LesProduits = lesProduits;
	}
	public List<Categorie> getLesCategories() {
		return lesCategories;
	}
	public void setLesCategories(List<Categorie> lesCategories) {
		this.lesCategories = lesCategories;
	}
	
	
}
