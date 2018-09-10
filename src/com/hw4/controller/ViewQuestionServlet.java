package com.hw4.controller;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
	import java.lang.RuntimeException;
	import javax.servlet.ServletException;
	import java.lang.NoSuchMethodException;
	import javax.servlet.ServletRequest;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import com.hw4.bean.Answerbean;
import com.hw4.bean.NAnswerbean;
import com.hw4.bean.UserNAnswerbean;
import com.hw4.model.ViewQuestionsDao;

	@WebServlet("/ViewQuestionServlet")

	public class ViewQuestionServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		public ViewQuestionServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws RuntimeException, IOException, NotSerializableException {
	
			HttpSession sessionp =request.getSession();
			response.setContentType("text/html");  
	        
			String username=(String)sessionp.getAttribute("username");
					
	        ViewQuestionsDao vdao= new ViewQuestionsDao();
	        
//	        List<Answerbean> list = vdao.getViewAllMQuestions();   

	           
	        List<Answerbean> listp =vdao.getViewAllMQuestions();;
	        sessionp.setAttribute("listMcq",listp);
	        
	        List<NAnswerbean> lista = vdao.getViewAllNQuestions();
	        List<NAnswerbean> listb =  lista;
	        sessionp.setAttribute("listN",lista);

	       /* for(NAnswerbean n: listb){
	        	System.out.println("Nanswerbean Numerical list");
	        	System.out.println(""+n.getQuestionid()+""+ n.getQuestion()+""+ n.getAnswer());} 
	        */
	        int boi = lista.size();
	        System.out.println("list size for nq"+boi);
	             
	        int poi = listp.size();
	        System.out.println("list size for MCQ ----------"+poi);
	        
	        response.sendRedirect("answeringquestions.jsp");
	     }  
	}
