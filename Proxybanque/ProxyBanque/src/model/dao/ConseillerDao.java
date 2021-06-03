package model.dao;

import java.util.List;

import model.Conseiller;

public interface ConseillerDao {
	public abstract List<Conseiller> listerConseiller();
	public abstract boolean creer(Conseiller conseiller);
	public abstract boolean modifierInfo(Conseiller conseiller);
	public abstract boolean supprimer(Conseiller conseiller);
	public abstract Conseiller afficherInfo(String idConseiller);
}
