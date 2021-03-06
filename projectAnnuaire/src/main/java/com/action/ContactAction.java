package com.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.dao.IDao;
import com.models.Contact;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ContactImpIDao;

public class ContactAction extends ActionSupport implements ServletRequestAware, SessionAware {
	private static final long serialVersionUID = 1L;

	private ArrayList<Contact> listContact = new ArrayList<>();
	private int id;
	private String nom;
	private String mail;
	private String codePostal;
	private Date dateInscription;
	private int idDelete;
	private File photo;
	private String photoContentType;
	private String photoFileName;
	private HttpServletRequest servletRequest;
	private Map<String, Object> maSession;

	public ArrayList<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(ArrayList<Contact> listContact) {
		this.listContact = listContact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public int getIdDelete() {
		return idDelete;
	}

	public void setIdDelete(int idDelete) {
		this.idDelete = idDelete;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public Map<String, Object> getMaSession() {
		return maSession;
	}

	public void setMaSession(Map<String, Object> maSession) {
		this.maSession = maSession;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.maSession = session;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

	public String lister() {
		ContactImpIDao cs = new ContactImpIDao();
		listContact = (ArrayList<Contact>) cs.listContact();
		return "success";
	}

	public String saisir() {
		return "success";
	}

	public String enregistrer() {
		Contact contact = new Contact();
		contact.setNom(nom);
		contact.setMail(mail);
		contact.setCodePostal(codePostal);
		contact.setDateInscription(dateInscription);
		ContactImpIDao ct = new ContactImpIDao();
		if (!ct.addContact(contact)) {
			System.out.println("hello");
			return INPUT;
		}
		String destPath;
		destPath = servletRequest.getSession().getServletContext().getRealPath("/");
		destPath += "photos\\";
		System.out.println(servletRequest);
		System.out.println("*************\nSrc file name : " + photo);
		System.out.println("Dst File name : " + destPath + photoFileName + "\n*********");
		try {
			File folder = new File(destPath);
			File destFile = File.createTempFile(Integer.toString(contact.getId()) + "_",
					"." + photoContentType.substring(photoContentType.indexOf("/") + 1), folder);
			System.out.println("*********\n generated name : " + destFile);
			System.out.println("*********\n ContentType : " + photoContentType);
			contact.setPhoto(destFile.getName());
			FileUtils.copyFile(photo, destFile);
			ct.updateContact(contact);
			System.out.println("Photo uploaded at = " + destFile + "/" + photoFileName);
			return lister();
		} catch (Exception e) {
			System.out.println("Upload error \n" + e);
			e.printStackTrace();
			return ERROR;
		}

	}

	public String supprimer() {
		IDao da = new ContactImpIDao();
		da.removeContact(idDelete);
		return lister();
	}

}
