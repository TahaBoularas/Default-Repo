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
import model.dao.ConseillerDao;
import model.dao.DaoFactory;



public class authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ConseillerDao conseillerDao;
 
    public authentification() {
        super();
    }
    
    
    public void init() throws ServletException {
    	
        DaoFactory daoFactory = DaoFactory.getInstance();
        
        this.conseillerDao = daoFactory.getConseillerDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)request.getUserPrincipal().getName();
		session.setAttribute("Utilisateur", conseillerDao.afficherInfo(username));
		session.setAttribute("Username", username);
		response.sendRedirect(request.getContextPath() + "/gestion/listeClient");
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
	}

}
