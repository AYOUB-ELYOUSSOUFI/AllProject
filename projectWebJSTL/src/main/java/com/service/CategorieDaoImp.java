package com.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.CategorieDao;
import com.hibernate.HibernateUtil;
import com.models.Categorie;

public class CategorieDaoImp implements CategorieDao{
	
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
	public void addCategorie(Categorie categorie) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		logger.info("Categorie saved successfully, categorie Deatils = " + categorie);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(categorie);
		session.getTransaction().commit();
		logger.info("Categorie saved successfully, categorie Deatils = " + categorie);
		
	}

	@Override
	public List<Categorie> listCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Categorie> categories = session.createQuery("from Categorie").list();
		session.getTransaction().commit();
		return categories;
	}

	@Override
	public List<Categorie> selectCatByKeyword(String keyWord) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Categorie> categorieList = session.createQuery("from Categorie c where c.nom like '%"+keyWord+"%'").list(); 
		session.getTransaction().commit();
		return categorieList;
	}

	@Override
	public Categorie getCategorieById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Categorie categorie = session.load(Categorie.class, Integer.valueOf(id));
		session.getTransaction().commit(); 
		return categorie;
	}

	@Override
	public void removeCategorie(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Categorie categorie = session.load(Categorie.class, Integer.valueOf(id));
		if(categorie != null) {
			session.remove(categorie);
		}
		session.getTransaction().commit();
		logger.info("Categorie deleted successfullt, Categorie details = " + categorie);
		
	}

}
