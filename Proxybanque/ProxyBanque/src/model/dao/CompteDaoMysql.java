package model.dao;

import java.sql.*;
import java.util.Date;
import java.util.*;


import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;

/*id_compte              | int(32)     | NO   | PRI | NULL    | auto_increment |
| client                 | int(32)     | NO   |     | NULL    |                |
| type_compte            | varchar(32) | NO   |     | NULL    |                |
| date_ouverture         | timestamp   | NO   |     | NULL    |                |
| taux_remuneration      | float       | YES  |     | NULL    |                |
| autorisation_decouvert | float       | YES  |     | NULL    |                |
| type_carte             | varchar(32) | YES  |     | NULL    |                |
| categorie_client       | varchar(32) | NO   |     | NULL*/


public class CompteDaoMysql implements CompteDao {
	
	private DaoFactory daoFactory;
	
	public CompteDaoMysql (DaoFactory daoFactory) {
		this.daoFactory=daoFactory;
	}
/* renvoi la liste des comptes d'un client a partir de l'id client*/
	@Override
	public List<Compte> listerComptesParClient(int idClient) {
		String requeteSql=new String("SELECT * from compte where client="+idClient+" ;");
		List<Compte> listeComptes =new ArrayList<Compte>();
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(requeteSql);
			
			while(resultSet.next()) {
				int idCompte = resultSet.getInt("id_compte");
				int client = resultSet.getInt("client");
				String type_compte=resultSet.getString("type_compte");
				Date dateOuverture = resultSet.getTimestamp("date_ouverture");
				Float taux_remuneration=resultSet.getFloat("taux_remuneration");
				Float autorisation_decouvert =resultSet.getFloat("autorisation_decouvert");
				String type_carte=resultSet.getString("type_carte");
				String categorie_client=resultSet.getString("categorie_client");
				
				Compte compte =new Compte();
				
				if (type_compte.equals("courant"))
					{ compte =new CompteCourant();
					((CompteCourant) compte).setAutorisationDecouvert(autorisation_decouvert);
					compte.setTypeCompte(type_compte);
					
					}
				else
					{ compte=new CompteEpargne();
					((CompteEpargne) compte).setTauxRemuneration(taux_remuneration);
					compte.setTypeCompte(type_compte);
					}
				compte.setIdCompte(idCompte);
				compte.setIdClient(client);
				compte.setCategorieClient(categorie_client);
				compte.setTypeCarte(type_carte);
				compte.setDateOuverture(dateOuverture);
				
								
				listeComptes.add(compte);
				
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		
		return listeComptes;
	}
	

	@Override
	public int creer(Compte compte) {
		String requeteSql=new String("INSERT into compte  (client ,type_compte, taux_remuneration, autorisation_decouvert, type_carte,categorie_client) values (?,?,?,?,?,?)")	;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int idClient=-1;
		
		try {
			connection=daoFactory.getConnection();
			preparedStatement=connection.prepareStatement(requeteSql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,compte.getIdClient());
			preparedStatement.setString(2,compte instanceof CompteCourant?"courant":"epargne");
			
			if (compte instanceof CompteEpargne) { 
				preparedStatement.setFloat(3,((CompteEpargne) compte).getTauxRemuneration());
			}
			else {
				preparedStatement.setNull(3,Types.FLOAT);
			}
			if (compte instanceof CompteCourant) {
				
				preparedStatement.setFloat(4,((CompteCourant) compte).getAutorisationDecouvert());
			}
			
			else {
				preparedStatement.setNull(4,Types.FLOAT);
		
			}
			if (compte.getTypeCarte()==null) {
				preparedStatement.setNull(5,Types.VARCHAR);
			}
			else {
				preparedStatement.setString(5,compte.getTypeCarte());
			}
			
			preparedStatement.setString(6,compte.getCategorieClient());
			
			
			
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
	public boolean supprimer(int idCompte) {
		String requeteSql=new String("delete from client where id_compte="+idCompte+";");
		Connection connection=null;
		Statement statement=null;
		boolean status=false;
		try {
			connection=daoFactory.getConnection();
			statement=connection.createStatement();
			statement.executeUpdate(requeteSql);
			status=true;
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
		return status;
	}

	

	@Override
	public Compte afficherInfo(String idCompte) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
