package model.dao;

import java.sql.*;
import java.util.*;

import model.Client;
import model.Conseiller;

public class ConseillerDaoMysql implements ConseillerDao {

	private DaoFactory daoFactory;
	
	public ConseillerDaoMysql(DaoFactory daoFactory) {
		
		this.daoFactory=daoFactory;
		
	}

	@Override
	public List<Conseiller> listerConseiller() {
		List<Conseiller> listeConseillers =new ArrayList<Conseiller>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from conseiller ;");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id_conseiller");
				String nom=resultSet.getString("nom");
				String prenom=resultSet.getString("prenom");
				String adresse=resultSet.getString("adresse");
				String cp =resultSet.getString("cp");
				String ville=resultSet.getString("ville");
				String email=resultSet.getString("email");
				String telephone=resultSet.getString("telephone");
				
				Conseiller conseiller=new Conseiller();
				conseiller.setId(id);
				conseiller.setNom(nom);
				conseiller.setPrenom(prenom);
				conseiller.setAdresse(adresse);
				conseiller.setCp(cp);
				conseiller.setVille(ville);
				conseiller.setEmail(email);
				conseiller.setTelephone(telephone);
								
				listeConseillers.add(conseiller);
				
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return listeConseillers;
	}

	@Override
	public boolean creer(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierInfo(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(Conseiller conseiller) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Conseiller afficherInfo(String idConseiller) {
		
		Conseiller conseiller=new Conseiller();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from conseiller where id_conseiller=" +idConseiller+ " ;");
		
			while(resultSet.next()) {
				int id = resultSet.getInt("id_conseiller");
				String nom=resultSet.getString("nom");
				String prenom=resultSet.getString("prenom");
				String adresse=resultSet.getString("adresse");
				String cp =resultSet.getString("cp");
				String ville=resultSet.getString("ville");
				String email=resultSet.getString("email");
				String telephone=resultSet.getString("tel");
				
				conseiller.setId(id);
				conseiller.setNom(nom);
				conseiller.setPrenom(prenom);
				conseiller.setAdresse(adresse);
				conseiller.setCp(cp);
				conseiller.setVille(ville);
				conseiller.setEmail(email);
				conseiller.setTelephone(telephone);
			}
	}catch (SQLException e) {
        e.printStackTrace();
    }
		return conseiller;
    }

	}


