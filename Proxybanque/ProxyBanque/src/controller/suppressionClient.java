package controller;

import java.io.IOException;

import java.sql.*;
import java.util.*;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.Compte;
import model.CompteCourant;
import model.CompteEpargne;
import model.Conseiller;
import model.dao.ClientDao;
import model.dao.CompteDao;
import model.dao.ConseillerDao;
import model.dao.DaoFactory;



public class suppressionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ClientDao clientDao;
       private CompteDao compteDao;
       int idClient;
       int idCompte;
 
    public suppressionClient() {
        super();
        
    }
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        this.compteDao = daoFactory.getCompteDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idClient=Integer.parseInt(request.getParameter("radioClient"));
		request.setAttribute("client", clientDao.afficherInfo(idClient));
		request.setAttribute("comptes", compteDao.listerComptesParClient(idClient));
		request.setAttribute("message", "Etes-vous sûr(e) de vouloir supprimer le client et les comptes associés ?");
		this.getServletContext().getRequestDispatcher("/WEB-INF/suppressionClient.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		idClient=Integer.parseInt(request.getParameter("idClient"));
		idCompte=Integer.parseInt(request.getParameter("idCompte"));
		clientDao.supprimer(idClient);
		compteDao.supprimer(idCompte);
		request.setAttribute("message", "Le client et les comptes associés ont été supprimés");
		this.getServletContext().getRequestDispatcher("/WEB-INF/suppressionClient.jsp").forward(request, response);
	}

}
