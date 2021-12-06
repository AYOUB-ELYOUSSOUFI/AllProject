package com.dao;

import java.util.List;

import com.models.Categorie;
import com.models.Produit;

public interface ProduitDao {
	
	public void addProduit(Produit produit);
	public void updateProduit(Produit produit);
	public List<Produit> listProduits();
	public List<Produit> selectProdByKeyword(String keyWord);
	public Produit getProduitById(int id);
	public void removeProduit(int id);
	
}
