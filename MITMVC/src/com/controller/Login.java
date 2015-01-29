package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.data.DAO;
import com.data.DataException;
import com.model.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String message=null;
		String resource="login.jsp";
		if(uid==null||uid.trim().equals("")){
			message="Please enter UID";
		}
		else if(pass==null||pass.trim().equals(""))
		{
			message="Please enter password";
	}
		else{
			try{
				User user=DAO.getUser(uid,pass);
				resource="welcome.jsp";
				request.getSession().setAttribute("user",user);
			}
			catch(DataException e){
				message=e.getMessage();
			}
		}
request.setAttribute("msg",message);
RequestDispatcher rd=request.getRequestDispatcher(resource);
rd.forward(request, response);
}
}
