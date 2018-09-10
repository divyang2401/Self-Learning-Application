package com.hw4.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw4.model.LoginDao;

@WebServlet("/Register.java")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	
		      
		   /* public static byte[] getSalt() throws NoSuchAlgorithmException{
		    	
		    	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		    	byte[] salt = new byte[16];
		    	sr.nextBytes(salt);
		    	return salt;
		    	  }*/
		  
		  
		  LoginDao dao = new LoginDao();
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String uname = request.getParameter("uname");
				String pass= request.getParameter("pass");
				String first= request.getParameter("first");
				String last=request.getParameter("last");

				String email = request.getParameter("mail");
				HttpSession session = request.getSession();			
				System.out.println("gonna check dao exist");
			
				
				
			if(dao.exists(uname)){
				session.setAttribute("username", uname);
				request.setAttribute("error", "User already exists!");
				response.sendRedirect("Register.jsp?error=User already exists!");
				//RequestDispatcher rd =  request.getRequestDispatcher("Register.jsp");
		  		//rd.include(request, response);
		  	}
		  	else
		  	{
		  		System.out.println("gonna check dao add in else");
		  	try
		  	{	
		  		System.out.println("--uname--"+uname);
		  		System.out.println("--pwd---"+pass);
		       // int status = dao.add(uname,pass,mail);
		  		dao.add(uname,pass,email,first,last);
		  		System.out.println("--------------------after DAO---------------------");
		  		System.out.print("record saved sucessfully!");
					response.sendRedirect("login.jsp");
				}
				  	
		  	catch(Exception e)
		  	{
		  		System.out.println("Sorry! unable to save record");
				response.sendRedirect("Register.jsp?error=Registration Problem");
			    e.printStackTrace();
		  	}
		  	}
				
			}
		}
