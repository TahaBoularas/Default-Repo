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



public class listeClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ClientDao clientDao;
       
 
    public listeClients() {
        super();
        
    }
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.clientDao = daoFactory.getClientDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("Username");
		
		request.setAttribute("Liste", clientDao.listerClientsParConseiller(username));
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeClient.jsp").forward(request, response);
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
	}

}
