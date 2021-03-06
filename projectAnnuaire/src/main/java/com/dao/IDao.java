package com.dao;

import java.util.List;

import com.models.Contact;

public interface IDao {
	
	public boolean addContact(Contact contact);
	public void updateContact(Contact contact);
	public List<Contact> listContact();
	public List<Contact> selectContactByKeyword(String keyWord);
	public Contact getContactById(int id);
	public void removeContact(int id);

}
