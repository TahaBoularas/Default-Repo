package model;

public class Client extends Personne {
	
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	
	public Client() {



}public Client(int id , String nom , String prenom , String adresse , String cp , String ville , String email , String telephone) {

	setId(id);
	setNom(nom);
	setPrenom(prenom);
	setAdresse(adresse);
	setCp(cp);
	setVille(ville);
	setEmail(email);
	setTelephone(telephone);


}
	
	public void attribuerCompteCourant(CompteCourant compteCourant) {
		this.compteCourant=compteCourant;
	}

	public void attribuerCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne=compteEpargne;
	}
}
