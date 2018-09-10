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

@WebServlet("/EdituserinfoServlet")
public class EdituserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EdituserinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();	
		String firstname=(String) request.getParameter("firstui") ;
		String lastname= (String)session.getAttribute("lastui");
		String username =(String)session.getAttribute("username");
		
		EditProfileDao dap =new EditProfileDao(); 
		loginbean p =new loginbean();
		p.setUser(username);		
		dap.changeUserInfo(username,firstname,lastname);
		response.sendRedirect("welcome.jsp? info updated");
	}

}
