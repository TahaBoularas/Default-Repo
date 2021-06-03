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



public class ouvertureCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ClientDao clientDao;
      
 
    public ouvertureCompte() {
        super();
        
    }
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationClient.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
	}

}
