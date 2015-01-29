package com.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.DAO;
import com.model.User;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		
		String message=null;
		String resource="registration.jsp";
		if(uid==null || uid.trim().equals(""))
		{
			message="please enter ur userid";
		}
		else if(pass==null ||pass.trim().equals("")){
			message="please enter pass";
		}
		
		else{
			User user=new User();
			user.setUsername(uid);
			user.setPassword(pass);
			
			try{
				DAO.saveUser(user);
				resource="login.jsp";
				message="resistred succesfull plz login";
			}
			catch(Exception e){
				message=e.getMessage();
				
				
			}
		}
		request.setAttribute("msg",message);
		RequestDispatcher rd=request.getRequestDispatcher(resource);
		rd.forward(request, response);
	
	}


}
