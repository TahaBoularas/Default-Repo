package model.dao;

import java.util.List;

import model.Compte;

public interface CompteDao {
	
	public abstract List<Compte> listerComptesParClient(int idClient);
	public abstract int creer(Compte compte);
	public abstract boolean supprimer(int idCompte);
	public abstract Compte afficherInfo(String idCompte);

}
