package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDaoMysql implements ClientDao{
	
	private DaoFactory daoFactory;
	
	public ClientDaoMysql(DaoFactory daoFactory) {
		
		this.daoFactory=daoFactory;
		
	}

	
	@Override
	public int creer(Client client,int idConseiller) {
		String requeteSql=new String("INSERT into client  (nom, prenom , adresse, cp , ville , email , telephone,conseiller) values (?,?,?,?,?,?,?,? )");
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int idClient=-1;
		
		try {
			connection=daoFactory.getConnection();
			preparedStatement=connection.prepareStatement(requeteSql,Statement.RETURN_GENERATED_KEYS	);
			preparedStatement.setString(1,client.getNom());
			preparedStatement.setString(2,client.getPrenom());
			preparedStatement.setString(3,client.getAdresse());
			preparedStatement.setString(4,client.getCp());
			preparedStatement.setString(5,client.getVille());
			preparedStatement.setString(6,client.getEmail());
			preparedStatement.setString(7,client.getTelephone());
			preparedStatement.setInt(8,idConseiller);
			
			
			preparedStatement.executeUpdate();
			ResultSet resultSet=preparedStatement.getGeneratedKeys();
			
			if(resultSet.next()){
				idClient=resultSet.getInt(1);
			}
		
	}catch (SQLException e) {
        e.printStackTrace();
    }
		return idClient;
	}

	@Override
	public boolean modifierInfo(Client client) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=daoFactory.getConnection();
			preparedStatement=connection.prepareStatement("UPDATE client SET prenom = ? , adresse = ?, cp = ? , ville = ?, email = ?, telephone = ? where id_client = ? ;");
			preparedStatement.setString(1,client.getPrenom());
			preparedStatement.setString(2,client.getAdresse());
			preparedStatement.setString(3,client.getCp());
			preparedStatement.setString(4,client.getVille());
			preparedStatement.setString(5,client.getEmail());
			preparedStatement.setString(6,client.getTelephone());
			preparedStatement.setInt(7,client.getId());
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean supprimer(int idClient) {
		Connection connection=null;
		Statement statement=null;
		boolean status=false;
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			statement.executeUpdate("delete from client where id_client="+idClient+";");
			status=true;
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return status;
	}

	@Override
	public Client afficherInfo(int idClient) {
		Client client=new Client();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from client where id_client=" +idClient+ " ;");
		
			while(resultSet.next()) {
				int id = resultSet.getInt("id_client");
				String nom=resultSet.getString("nom");
				String prenom=resultSet.getString("prenom");
				String adresse=resultSet.getString("adresse");
				String cp =resultSet.getString("cp");
				String ville=resultSet.getString("ville");
				String email=resultSet.getString("email");
				String telephone=resultSet.getString("telephone");
				
				client.setId(id);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setAdresse(adresse);
				client.setCp(cp);
				client.setVille(ville);
				client.setEmail(email);
				client.setTelephone(telephone);
			}
	}catch (SQLException e) {
        e.printStackTrace();
    }
		return client;
    }

	@Override
	public List<Client> listerClientsParConseiller(String idConseiller) {
		List<Client> listClients =new ArrayList<Client>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from client where conseiller="+idConseiller+" ;");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id_client");
				String nom=resultSet.getString("nom");
				String prenom=resultSet.getString("prenom");
				String adresse=resultSet.getString("adresse");
				String cp =resultSet.getString("cp");
				String ville=resultSet.getString("ville");
				String email=resultSet.getString("email");
				String telephone=resultSet.getString("telephone");
				
				Client client=new Client();
				client.setId(id);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setAdresse(adresse);
				client.setCp(cp);
				client.setVille(ville);
				client.setEmail(email);
				client.setTelephone(telephone);
								
				listClients.add(client);
				
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		return listClients;
	}

}
