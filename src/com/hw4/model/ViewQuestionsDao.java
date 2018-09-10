package com.hw4.model;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.hw4.bean.Answerbean;
import com.hw4.bean.NAnswerbean;
import com.hw4.bean.UserNAnswerbean;

public class ViewQuestionsDao {
	public List<Answerbean> getViewAllMQuestions(){
		List <Answerbean> list = new ArrayList<Answerbean>();
		java.sql.Connection con = null;
		java.sql.PreparedStatement ps = null;
		
		try {			
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:9050/hw4", "root", "root");
		String sqp = "SELECT * FROM hw4.mquestion";
		ps = con.prepareStatement(sqp);
		ResultSet rs = ps.executeQuery();

     while(rs.next()){
    	 Answerbean e = new Answerbean();
    	 String question = rs.getString("question");
		String choicea = rs.getString("choicea");
		String choiceb = rs.getString("choiceb");
		String choicec = rs.getString("choicec");
		String choiced = rs.getString("choiced");
		String hint = rs.getString("hint1");
		String answer= rs.getString("answer");
		String feedback= rs.getString("feedback");
		int questionid = rs.getInt("questionid");
		String status = rs.getString("status");
		System.out.println("question--------------"+question);
		System.out.println("choicea-------------"+choicea);
		System.out.println("choiceb-------------"+choiceb);
		System.out.println("choicec-------------"+choicec);
		System.out.println("choiced-------------"+choiced);
		System.out.println("hint------------"+ hint);
		System.out.println("answer----------------"+answer);
		System.out.println("questionid---------------"+questionid);
		
		e.setQuestion(question);
		e.setChoicea(choicea);
		e.setChoiceb(choiceb);
		e.setChoicec(choicec);
		e.setChoiced(choiced);
		e.setAnswer(answer);
		e.setHint1(hint);
		e.setQuestionid(questionid);
		e.setFeed(feedback);
		e.setStatus(status);
		list.add(e);
			}
     con.close();	
		}
		catch(Exception w){w.printStackTrace();}
		return list;
		}
		public List<NAnswerbean> getViewAllNQuestions(){
			List <NAnswerbean> Nlist = new ArrayList<NAnswerbean>();
			java.sql.Connection con = null;
			java.sql.PreparedStatement ps = null;
		try{
		String sql = "SELECT * FROM hw4.nquestion";
		con = DriverManager.getConnection("jdbc:mysql://localhost:9050/hw4", "root", "root");
		ps = con.prepareStatement(sql);
		
		ResultSet rsa = ps.executeQuery();
		
     	while(rsa.next()){
     	NAnswerbean p = new NAnswerbean();
     	String question = rsa.getString("question");
		String hint1 = rsa.getString("hint1");
		String answer= rsa.getString("answer");
		String feedback= rsa.getString("feedback");
		int questionid = rsa.getInt("questionid");
		String status = rsa.getString("status");

		System.out.println("question--------------"+question);
		System.out.println("hint------------"+ hint1);
		System.out.println("feedback------------"+ feedback);
		System.out.println("answer----------------"+answer);
		System.out.println("questionid---------------"+questionid);
		
		p.setQuestion(question);
		p.setAnswer(answer);
		p.setHint1(hint1);
		p.setQuestionid(questionid);
		p.setFeed(feedback);
		p.setStatus(status);
		Nlist.add(p);
			
		}
     	con.close();
		}
		catch(Exception p){p.printStackTrace();}
		return Nlist;
		}

public List <NAnswerbean> getSpecificnQuestion(NAnswerbean n) throws Exception{
	
	List <NAnswerbean> lista = new ArrayList<NAnswerbean>();
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;

try{
	String sqla = "SELECT * FROM hw4.nquestion where questionid="+n.getQuestionid();
	con = DriverManager.getConnection("jdbc:mysql://localhost:9050/hw4", "root", "root");
	ps = con.prepareStatement(sqla);
	System.out.println(sqla);
	
	
	ResultSet rsw = ps.executeQuery();
	while(rsw.next()){
	NAnswerbean d = new NAnswerbean();
	String question = rsw.getString("question");
	System.out.println(question+"from database");
	String hint1 = rsw.getString("hint1");
	String answer= rsw.getString("answer");
	String feedback= rsw.getString("feedback");
	int qid =rsw.getInt("questionid");

	d.setQuestion(question);
	d.setAnswer(answer);
	d.setFeed(feedback);
	d.setHint1(hint1);
	d.setQuestionid(qid);
	lista.add(d);
	con.close();
	}

}
catch(Exception e){e.printStackTrace();}	
return lista;
}

public List <Answerbean> getSpecificmcQuestion(Answerbean a){
	List <Answerbean> listf = new ArrayList<Answerbean>();
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;	
	
try{
	String sqla = "SELECT * FROM hw4.mquestion where questionid="+a.getQuestionid();
	con = DriverManager.getConnection("jdbc:mysql://localhost:9050/hw4", "root", "root");
	ps = con.prepareStatement(sqla);
	ResultSet rsq = ps.executeQuery();

	while(rsq.next()){
	Answerbean p = new Answerbean();
	String question = rsq.getString("question");
	String hint1 = rsq.getString("hint1");
	String answer= rsq.getString("answer");
	String feedback= rsq.getString("feedback");
	String choicea = rsq.getString("choicea");
	String choiceb = rsq.getString("choiceb");
	String choicec = rsq.getString("choicec");
	String choiced = rsq.getString("choiced");
	int questionid= rsq.getInt("questionid");
	
	p.setQuestion(question);
	p.setAnswer(answer);
	p.setFeed(feedback);
	p.setHint1(hint1);
	p.setChoicea(choicea);
	p.setChoiceb(choiceb);
	p.setChoicec(choicec);
	p.setChoiced(choiced);
	p.setQuestionid(questionid);
	
	listf.add(p);
	con.close();
	}
}
catch(Exception e){e.printStackTrace();}	
return listf;
}

public List getCompletednQuestion(UserNAnswerbean n){
	
	java.sql.Connection con = null;
	java.sql.PreparedStatement ps = null;
	String username=n.getUsername();
	List listx= new ArrayList<>();
	System.out.println("----------------username is---------"+username);
try{
	String sqla = "SELECT * FROM hw4.user_values where username=?";
	con = DriverManager.getConnection("jdbc:mysql://localhost:9050/hw4", "root", "root");
	ps = con.prepareStatement(sqla);
	ps.setString(1, username);
	ResultSet rs = ps.executeQuery();

	while(rs.next()){
	int questionid = rs.getInt("questionid");
	String answer_check = rs.getString("answer_check");
	String useranswer = rs.getString("answer");
	String uname = rs.getString("username");
	
	System.out.println("question id is"+questionid);
	System.out.println("answer_check is"+answer_check);
	UserNAnswerbean d =new UserNAnswerbean();
	d.setAnswer(useranswer);
	d.setQuestionid(questionid);
	d.setStatus(answer_check);
	d.setUsername(uname);
	listx.add(d);
	con.close();
	}
	}catch(Exception e){e.printStackTrace();}
	return listx;

}
}
