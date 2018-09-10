package com.hw4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw4.bean.loginbean;
import com.hw4.model.EditProfileDao;


@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();	
		String newpass=(String) request.getParameter("npwd") ;
		String user= (String)session.getAttribute("username");
		String cpjsp =(String) request.getParameter("pwd");
		
		EditProfileDao da =new EditProfileDao(); 
		loginbean p =new loginbean();
		p.setUser(user);		
		
		
		
		String cpassfromdb = da.retrievePassword(p);
		session.setAttribute("currentpwd", cpassfromdb);
		System.out.println("cpassfromdb="+cpassfromdb);
		System.out.println("cpjsp="+cpjsp);
					
		if(cpassfromdb==cpjsp ||cpjsp.equals(cpassfromdb)) {
			System.out.println("it is in else loop");

			p.setPassword(newpass);
			int status= da.changePassword(p);
			
			if(status>0){
				//String io="1";
				//session.setAttribute("updatefromprofile",io);}
			response.sendRedirect("welcome.jsp?password updated!");
					}}
	
		else if(cpassfromdb != cpjsp){
			System.out.println("it is in if loop");
			response.sendRedirect("login.jsp?Wrong password entered!");}
	
	}

}

