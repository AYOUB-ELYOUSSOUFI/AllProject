package com.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.IDao;
import com.hibernate.HibernateUtil;
import com.models.Contact;

public class ContactImpIDao implements IDao {

	private static final Logger logger = Logger.getLogger(ContactImpIDao.class.getName());
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not create SessionFactory", e);
			throw new IllegalStateException("Could not create SessionFactory");
		}
	}

	@Override
	public boolean addContact(Contact contact) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(contact);
			session.getTransaction().commit();
			logger.info("Contact Addes successfully, Contact deatils : " + contact);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public void updateContact(Contact contact) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.update(contact);
		session.getTransaction().commit();
		logger.info("Contact updated successfuly, Contact details : " + contact);
	}

	@Override
	public List<Contact> listContact() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Contact> contacts = session.createQuery("from Contact").list();
		session.getTransaction().commit();
		return contacts;
	}

	@Override
	public List<Contact> selectContactByKeyword(String keyWord) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<Contact> contacts = session.createQuery("from Contact c where c.nom like '%" + keyWord + "%'").list();
		session.getTransaction().commit();
		return contacts;
	}

	@Override
	public Contact getContactById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Contact contact = session.load(Contact.class, Integer.valueOf(id));
		session.getTransaction().commit();
		return contact;
	}

	@Override
	public void removeContact(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		Contact contact = session.load(Contact.class, Integer.valueOf(id));
		if (contact != null) {
			session.remove(contact);
		}
		session.getTransaction().commit();
		logger.info("Contact deleted successfullt, Contact details = " + contact);
	}

}
