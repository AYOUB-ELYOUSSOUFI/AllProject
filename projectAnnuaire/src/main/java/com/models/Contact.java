package com.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="pseudo")
	private String nom;
	@Column(name="email")
	private String mail;
	@Column(name="codeProstal")
	private String codePostal;
	@Column(name="dateInscription")
	private Date dateInscription;
	@Column(name="photo")
	private String photo;
	
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Contact() {}
	public Contact(String nom, String mail, String codePostal, Date dateInscription, String photo) {
		super();
		//this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.codePostal = codePostal;
		this.dateInscription = dateInscription;
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", mail=" + mail + ", codePostal=" + codePostal
				+ ", dataInscription=" + dateInscription + ", photo=" + photo + "]";
	}
	
}
