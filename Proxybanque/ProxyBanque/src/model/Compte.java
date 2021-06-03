package model;

import java.util.Date;

public class Compte {
	
	 private int idCompte;
	 private int idClient;
	 private Date dateOuverture;
	 private double sold;
	 private String categorieClient;
	 private String typeCarte;
	 private String typeCompte;
	 
	 
	 public Compte() {
		 
	 }


	public int getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}


	public Date getDateOuverture() {
		return dateOuverture;
	}


	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}


	public double getSold() {
		return sold;
	}


	public void setSold(float sold) {
		this.sold = sold;
	}


	public String getCategorieClient() {
		return categorieClient;
	}


	public void setCategorieClient(String categorieClient) {
		this.categorieClient = categorieClient;
	}


	public String getTypeCarte() {
		return typeCarte;
	}


	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getTypeCompte() {
		return typeCompte;
	}


	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	

}
