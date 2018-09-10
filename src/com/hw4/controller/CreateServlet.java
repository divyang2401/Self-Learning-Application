package com.hw4.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw4.bean.Answerbean;
import com.hw4.bean.NAnswerbean;
import com.hw4.model.CreateDao;


@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String question =request.getParameter("cquestion");
    	String answer =request.getParameter("answer");
    	String hint1 =request.getParameter("hint1");
    	String feed =request.getParameter("feed");
    	
    	NAnswerbean  a = new NAnswerbean();
    	a.setAnswer(answer);
    	a.setFeed(feed);
    	a.setHint1(hint1);
    	a.setQuestion(question);
 
    try{
      	CreateDao pao = new CreateDao();
        pao.save(a);
        response.sendRedirect("welcome.jsp?pass= Question Created");
       		}
    catch(Exception d){
    	response.sendRedirect("create.jsp?error=Again Create question");
    	d.printStackTrace();
    		}

    
    }	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
