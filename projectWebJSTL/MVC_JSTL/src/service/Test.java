package service;

import java.util.List;

import dao.CategorieDAO;
import model.Categorie;

public class Test{

	public static void main(String[] args) {
		CategorieDAO catDAO = new CategorieDAOImpl();
		List<Categorie> lesCateg;
		Categorie uneCategorie;
		lesCateg= catDAO.listCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
		
		uneCategorie = new Categorie();
		uneCategorie.setNom("Nouvelle Categorie");
		uneCategorie.setDescription("Nouvelle Categorie");
		catDAO.addCategorie(uneCategorie);
		
		lesCateg= catDAO.listCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
		
		uneCategorie = catDAO.getCategorieById(2);
		uneCategorie.setDescription("Boitier Tower Big or Slim");
		catDAO.updateCategorie(uneCategorie);
		
		lesCateg= catDAO.listCategories();
		System.out.println("List of all Categories (_"+lesCateg.size()+"_)");
		lesCateg.stream().forEach(e -> System.out.println(e));
	}

}
