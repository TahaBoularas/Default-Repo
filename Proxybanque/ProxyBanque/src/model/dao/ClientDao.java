package model.dao;

import java.util.List;
import model.Client;

public interface ClientDao {
	
	public abstract List<Client> listerClientsParConseiller(String idConseiller);
	public abstract int creer(Client client, int idConseiller);
	public abstract boolean modifierInfo(Client client);
	public abstract boolean supprimer(int idClient);
	public abstract Client afficherInfo(int id);
}
