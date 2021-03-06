package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Catalogue {

	public Catalogue() {}
	
	public void addCategorie(String titreCat, String description) {
        Connection conn = Singleton.getConnection();
        String req = "insert into categorie (titre,description) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, titreCat);
            ps.setString(2, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : " + e);
            e.printStackTrace();
        }
    }

    public void deleteCategorie(long idCat) {
        Connection conn = Singleton.getConnection();
        String req = "delete from categorie where idCategorie=?";
        try {
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setLong(1, idCat);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : " + e);
            e.printStackTrace();
        }
    }

    public ArrayList<Categorie> selectAll() {
        String requete = "select * from categorie";
        return selectCategories(requete);
    }

    public ArrayList<Categorie> selectById(String keyword) {
        String requete = "select * from categorie where titre like '%" + keyword + "%'";
        return selectCategories(requete);
    }

    private ArrayList<Categorie> selectCategories(String requete) {
        Connection conn = Singleton.getConnection();
        ArrayList<Categorie> lesCat = new ArrayList<>();
        Categorie cat = null;
        try {
            PreparedStatement ps = conn.prepareStatement(requete);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cat = new Categorie();
                cat.setIdCat(Long.valueOf(rs.getLong("idCategorie")));
                cat.setTitre(rs.getString("titre"));
                cat.setDesignation(rs.getString("description"));
                lesCat.add(cat);
            }
        } catch (SQLException e) {
            System.out.println("Erreur d'insertion : " + e);
            e.printStackTrace();
        }
        return lesCat;
    }


}
