package controller;

import java.io.IOException;

import java.sql.*;
import java.util.*;


import javax.servlet.*;
import javax.servlet.http.*;
import model.*;
import model.dao.*;


public class creationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ClientDao clientDao;
       private CompteDao compteDao;
      
 
    public creationClient() {
        super();
        
    }
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        this.compteDao = daoFactory.getCompteDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationClient.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Conseiller conseiller =(Conseiller) session.getAttribute("Utilisateur");
		
		Client client= new Client(0,
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("adresse"),
				request.getParameter("cp"),
				request.getParameter("ville"),
				request.getParameter("email"),
				request.getParameter("telephone"));
		int idClient =clientDao.creer(client, conseiller.getId());
		client.setId(idClient);
		
		String typeCompte=(String)request.getParameter("typeCompte");
		Compte compte=new Compte();
		
		if(typeCompte.equals("courant"))
			{
				compte=new CompteCourant();
			}
		else if (typeCompte.equals("epargne"))
			{
				compte= new CompteEpargne();
			}
		compte.setCategorieClient((String)request.getParameter("categorieClient"));
		compte.setTypeCompte(typeCompte);
		
		if (!request.getParameter("typeCarte").equals("aucune")) {
		compte.setTypeCarte(request.getParameter("typeCarte"));
		}
		
		compte.setIdClient(client.getId());
		int idCompte=(compteDao.creer(compte));
		compte.setIdCompte(idCompte);
		request.setAttribute("compte", compte);
		request.setAttribute("typeCompte", typeCompte);
		request.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationClientConfirmation.jsp").forward(request, response);
	}

}
