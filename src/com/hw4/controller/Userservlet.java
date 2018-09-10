package com.hw4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.hw4.bean.NAnswerbean;
import com.hw4.model.UseranswerDao;

@WebServlet("/Userservlet")
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Userservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uanswer= request.getParameter("uanswer");
		System.out.println("user answer is"+uanswer);
		NAnswerbean p = new NAnswerbean();
		String status="Completed";
		p.setStatus(status);
		
		HttpSession session= request.getSession();	
		int idn = (int)session.getAttribute("idn");
	
		String user=(String)session.getAttribute("username");
		UseranswerDao da = new UseranswerDao();
		da.saven(idn,status);
		response.sendRedirect("Congratulations.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

}
