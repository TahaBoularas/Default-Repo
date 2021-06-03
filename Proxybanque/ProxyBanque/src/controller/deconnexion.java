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



public class deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
      
 
    public deconnexion() {
        super();
        
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session != null)
			
		    session.invalidate();
		
		   response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		this.getServletContext().getRequestDispatcher("/home.html").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
