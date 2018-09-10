package com.hw4.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw4.bean.Answerbean;
import com.hw4.model.CreateDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/MCQuestionsServlet")
public class MCQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public MCQuestionsServlet() throws ClassNotFoundException, SQLException {
        super();
            }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//String mcq_id = request.getParameter("mcq_id");
		CreateDao dao= new CreateDao();
		int pop=0;
		String question = request.getParameter("question");
		String choicea = request.getParameter("choicea");
		String choiceb = request.getParameter("choiceb");
		String choicec = request.getParameter("choicec");
		String choiced = request.getParameter("choiced");
		String answer = request.getParameter("answer");
		String hint1 = request.getParameter("hint1");
		String feedback = request.getParameter("feedback");
		
		Answerbean a = new Answerbean();
		a.setQuestion(question);
		a.setChoicea(choicea);
		a.setChoiceb(choiceb);
		a.setChoicec(choicec);
		a.setChoiced(choiced);
		a.setAnswer(answer);
		a.setHint1(hint1);
		a.setFeed(feedback);
		
		String sql = 
			"insert into mquestion(question, choicea, choiceb, choicec, choiced, answer, hint1,feedback) values(?,?,?,?,?,?,?,?);";
		
		try {
			System.out.println("-----------------"+sql);

		pop= dao.save(sql, a);
			//ps.setString(1, mcq_id);
		if(pop==1){response.sendRedirect("welcome.jsp? MCQ question created!");}	
		else if(pop==0){response.sendRedirect("CreatMc.jsp?Create again sorry!");} 	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
