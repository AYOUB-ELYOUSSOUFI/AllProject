package com.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.*;
import com.hibernate.HibernateUtil;
import com.models.Categorie;
import com.models.Produit;

public class ProduitDaoImp implements ProduitDao{

	private static final Logger logger = Logger.getLogger(CategorieDaoImp.class.getName());
	private final SessionFactory sessionFactory = getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionfactory();
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}

	@Override
	public void addProduit(Produit produit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(produit);
		session.getTransaction().commit();
		logger.info("Produit saved successfully, produit Deatils = " + produit);
	}

	@Override
	public void updateProduit(Produit produit) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(produit);
		session.getTransaction().commit();
		logger.info("Produit updated successfully, produit Deatils = " + produit);		
		
	}

	@Override
	public List<Produit> listProduits() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Produit> produits= session.createQuery("from produit").list();
		session.getTransaction().commit();
		return produits;
	}

	@Override
	public List<Produit> selectProdByKeyword(String keyWord) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Produit> produits= session.createQuery("from produit p where p.Categorie.nom like '%"+keyWord+"%'").list();
		session.getTransaction().commit();
		return produits;
	}

	@Override
	public Produit getProduitById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Produit produit = session.load(Produit.class, Integer.valueOf(id));
		return produit;
	}

	@Override
	public void removeProduit(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Produit produit = session.load(Produit.class, Integer.valueOf(id));
		if(produit != null) {
			session.remove(produit);
		}
		session.getTransaction().commit();
		logger.info("Produit deleted successfullt, Categorie details = " + produit);
		
	}
		
	
}
