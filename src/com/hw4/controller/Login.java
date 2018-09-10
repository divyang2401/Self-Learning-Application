package com.hw4.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw4.model.LoginDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Login(){
	super();	
	}
	
	     
	    /*public static byte[] getSalt() throws NoSuchAlgorithmException{
	    	
	    	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    	byte[] salt = new byte[16];
	    	sr.nextBytes(salt);
	    	return salt;
	    	  }*/
	
	
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  LoginDao dao = new LoginDao();
	  System.out.println("going for password");
	  String uname= request.getParameter("uname");
	  String pass = request.getParameter("pass");
	  
	  //String visited=request.getParameter("visited");
	  
	  
	  System.out.println(uname);
	  System.out.println(pass);  
	
	  if(dao.check(uname,pass))
	  	{
		  System.out.println("true in checking");
	  		HttpSession session = request.getSession();
	  		session.setAttribute("username", uname);
	  		response.sendRedirect("welcome.jsp");}
	  	
	  	else
	  	{
	  		System.out.println("wrong password started");
	  		//  request.set("error", "Invalid user or password");
	    //  		RequestDispatcher rd = request.getRequestDispatcher("login.jsp?error=Invalid password");
		//	rd.include(request, response);
	  		response.sendRedirect("login.jsp?error=Invalid user or password");
	  	}
		
	}

}
