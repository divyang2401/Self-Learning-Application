package com.hw4.controller;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hw4.bean.Answerbean;
import com.hw4.bean.NAnswerbean;
import com.hw4.model.ViewQuestionsDao;

@WebServlet("/ViewSQuestion")
public class ViewSQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewSQuestion() {
        super();
          }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException 
    {
    	try
    	{
        	HttpSession session = request.getSession();
            List<Answerbean> listb = null;
            List<NAnswerbean> listp =null;
            
            String idn= null;
            String idmcq= request.getParameter("answermcq");
            
            System.out.println("value in ViewSQuestion numeric"+idn);
            System.out.println("value in ViewSQuestion mcq" +idmcq);

            if(idmcq==null || idmcq.equals("null")){
            System.out.println("ViewSQuestion: numerical question you choose");	
            int id= Integer.parseInt(idn);
            NAnswerbean n = new NAnswerbean();
            n.setQuestionid(id);
            
            ViewQuestionsDao vqdao= new ViewQuestionsDao();
            List lista = vqdao.getSpecificnQuestion(n);
            List<NAnswerbean> listy =vqdao.getSpecificnQuestion(n);
            
            System.out.println("---------------List from DAO-----------"+lista);
            
            session.setAttribute("idn", id);
            session.setAttribute("questidforn",lista);
            session.setAttribute("listnoy", listy);
            response.sendRedirect("Specificnque.jsp");
                   }
            
            else if(idn==null || idn.equals("null")){
            	System.out.println("ViewSQuestion: MCQ question you choose");
            	int idm= Integer.parseInt(idmcq);
            	Answerbean a = new Answerbean();
            	a.setQuestionid(idm);
            	
            	ViewQuestionsDao vda= new ViewQuestionsDao();
            	List listd= vda.getSpecificmcQuestion(a);
            	session.setAttribute("questidformcq",listd);
            	List<Answerbean> listo =vda.getSpecificmcQuestion(a);

                session.setAttribute("idmcq", idm);
                session.setAttribute("questidformcq",listd);     
                session.setAttribute("listnoy", listp);
            	response.sendRedirect("specificmcq.jsp");
        }
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}