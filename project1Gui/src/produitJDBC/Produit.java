package produitJDBC;

import java.util.Objects;

public class Produit {
	
	private int code;
	private String designation;
	private double prix;
	private int quantite;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	
	public Produit() {
		
	}
	public Produit(int code, String designation, double prix, int quantite) {
		super();
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
	}
		
	@Override
	public String toString() {
		return code + "-" + designation + "-" + prix + "-" + quantite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, designation, prix, quantite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return code == other.code && Objects.equals(designation, other.designation)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix) && quantite == other.quantite;
	}
	
	

}
