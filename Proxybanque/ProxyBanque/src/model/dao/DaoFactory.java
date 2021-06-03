package model.dao;

import java.sql.*;
public class DaoFactory {		

	
	
	private String url="jdbc:mysql://localhost:3306/ProxyBanque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user="root";
	private String password="Khayyam021186!";
	
	;
	
	
	private DaoFactory()  {
				
	}
	
	public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, user, password);
	    }
	 
	public static DaoFactory getInstance()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		}catch (ClassNotFoundException ex) {
			System.out.println("connexion échouée :" + ex.getMessage());
		}
		
		
		DaoFactory instance = new DaoFactory();
		return instance;
	}
	
	

	public ClientDao getClientDao() {
		return new ClientDaoMysql(this);
	}

	public CompteDao getCompteDao() {
		return new CompteDaoMysql(this);
	}
	
	public ConseillerDao getConseillerDao() {
		return new ConseillerDaoMysql(this);
	}
}
	 
		
	
	

