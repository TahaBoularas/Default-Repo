package model;

import java.util.Map;

/** 
 * Classe Personne
 * @author bmtah
 *
 */

public abstract class Personne {
	

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String ville;
	private String cp;
	private String Telephone;
	
	
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
	public Client setAll(Client client,Map<String,String> infosModifiees){
		
		for (Map.Entry<String,String> info : infosModifiees.entrySet()) {
			switch (info.getKey()) {
			
			case "id":
				client.setId(Integer.parseInt(info.getValue()));
				break;
			case "nom":
				client.setNom(info.getValue());
				break;
			case "prenom":
				client.setPrenom(info.getValue());
				break;
			case "email":
				client.setEmail(info.getValue());
				break;
			case "adresse":
				client.setAdresse(info.getValue());
				break;
			case "ville":
				client.setVille(info.getValue());
				break;
			case "cp":
				client.setCp(info.getValue());
				break;
				
			default:
				break;
			}
		}
		return client;
		
		
	}
	
	

}
