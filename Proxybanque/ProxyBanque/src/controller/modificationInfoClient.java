package controller;

import java.io.IOException;

import java.sql.*;
import java.util.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.dao.ClientDao;
import model.dao.DaoFactory;



public class modificationInfoClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDao clientDao;
	int idClient;
       
 
    public modificationInfoClient() {
        super();
        
    }

    public void init() throws ServletException {
    	
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(true);
		if (request.getParameter("modifierInformation")!=null && request.getParameter("modifierInformation").equals("true")) {
			Client client = (Client) session.getAttribute("nouveauClient");
			clientDao.modifierInfo(client);
			session.removeAttribute("nouveaClient");
			session.removeAttribute("client");	
			request.setAttribute("message","Vos modifications ont été prises en compte");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modificationInfoClientConfirmation.jsp").forward(request, response);
			
		}
		else if(request.getParameter("modifierInformation")!=null && request.getParameter("modifierInformation").equals("false")){
			
			session.removeAttribute("nouveauClient");
			this.getServletContext().getRequestDispatcher("/WEB-INF/modificationInfoClient.jsp").forward(request, response);
			
		}
		
		else {
			
			idClient=Integer.parseInt(request.getParameter("radioClient"));
			session.setAttribute("client", clientDao.afficherInfo(idClient));
			this.getServletContext().getRequestDispatcher("/WEB-INF/modificationInfoClient.jsp").forward(request, response);
		
		}
		
	}
		
	
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		HttpSession session= request.getSession(true);
			
		
		
		HashMap<String, String> infosModifiees = new HashMap<String, String>();
		idClient=Integer.parseInt(request.getParameter("id"));	
		//le nom est dans champ disabled pas de modification possible
		String nom=  request.getParameter("ancienNom");
		
		
		//comparaison des String entrés avec ceux récuperés de la base de données si differents et non nuls 
		String prenom=null;
		if(!((String)request.getParameter("prenom")).isEmpty() 
			&&	!((String)request.getParameter("prenom")).equals((String)request.getParameter("ancienPrenom")))
					{prenom=request.getParameter("prenom"); infosModifiees.put("Prenom",prenom);}
		else 	{prenom =request.getParameter("ancienPrenom");}	
		
		String adresse=null;
		if(!((String)request.getParameter("adresse")).isEmpty()
		&&	!((String)request.getParameter("adresse")).equals((String)request.getParameter("ancienneAdresse")))
				{adresse=request.getParameter("adresse"); infosModifiees.put("Adresse",adresse);}
		else 	{adresse =request.getParameter("ancienneAdresse");}
		
		String cp=null;
		if(!((String)request.getParameter("cp")).isEmpty() 
				&&	!((String)request.getParameter("cp")).equals((String)request.getParameter("ancienCp"))) 
						{cp=request.getParameter("cp"); infosModifiees.put("Cp",cp);}
		else 			{cp =request.getParameter("ancienCp");}					
		
		String ville=null;
		if(!((String)request.getParameter("ville")).isEmpty() 
				&&	!((String)request.getParameter("ville")).equals((String)request.getParameter("ancienneVille")))  
						{ville=request.getParameter("ville"); infosModifiees.put("Ville",ville);}
		else 			{ville =request.getParameter("ancienneVille");}
		
		String email=null;
		if(!((String)request.getParameter("email")).isEmpty() 
				&&	!((String)request.getParameter("email")).equals((String)request.getParameter("ancienEmail")))
						{email=request.getParameter("email"); infosModifiees.put("Email",email);}
		else 			{email=request.getParameter("ancienEmail");}
		
		String telephone=null;
		if(!((String)request.getParameter("telephone")).isEmpty() 
				&&	!((String)request.getParameter("telephone")).equals((String)request.getParameter("ancienTelephone")))
						{telephone=request.getParameter("telephone"); infosModifiees.put("Telephone",telephone);}
		else 				{telephone=request.getParameter("ancienTelephone");}							
		
		
		Client nouveauClient= new Client(idClient,nom,prenom,adresse,cp,ville,email,telephone);
		session.setAttribute("nouveauClient",nouveauClient);
		request.setAttribute("infosModifiees",infosModifiees);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modificationInfoClientConfirmation.jsp").forward(request, response);
		}
		

}
