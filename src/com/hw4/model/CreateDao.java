package com.hw4.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hw4.bean.Answerbean;
import com.hw4.bean.NAnswerbean;

public class CreateDao {
	static String url = "jdbc:mysql://localhost:9050/hw4";
	static String username= "root";
	static String password="root";
    static String sav = "insert into hw4.nquestion(question,answer,hint1,feedback) values(?,?,?,?)";		
    static ResultSet rs1;
    
	public void save(NAnswerbean a){
			 String question= a.getQuestion() ;
			 String answer= a.getAnswer() ;
			 String hint1 = a.getHint1();
			 String feedback=  a.getFeed();
			 
	try {	System.out.println("connection try");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st = con.prepareStatement(sav);
			System.out.println("connection happen and assign string");
			
			st.setString(1, question);
			st.setString(2, answer);
			st.setString(3, hint1);
			st.setString(4, feedback);
			st.executeUpdate();
			con.close();	
		}
		catch(Exception l){
			l.printStackTrace();
		}
}	

	public int save(String sql, Answerbean a){
		 
		int status=0;
		 String question= a.getQuestion() ;
		 String answer= a.getAnswer() ;
		 String hint1 = a.getHint1();
		 String feedback=  a.getFeed();
		 String choicea = a.getChoicea();
		 String choiceb = a.getChoiceb();
		 String choicec = a.getChoicec();
		 String choiced = a.getChoiced();
		 
		 System.out.println("try in createdao");
try {	
	System.out.println("connection try");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println(sql);
		
		/*"insert into mquestion(question, choicea, choiceb, choicec, choiced, answer, hint1,feedback) values ('" + 
		question + "','" + choicea + "','" + choiceb + "','" + choicec + "','" + choiced + "','" +	
		answer + "','" + hint1 + "','" + "','" + feedback + "');"*/
		
		System.out.println("connection happen and assign string");
		st.setString(1, question);
		st.setString(2, choicea);
		st.setString(3, choiceb);
		st.setString(4, choicec);
		st.setString(5, choiced);
		st.setString(6, answer);
		st.setString(7, hint1);
		st.setString(8,feedback);
		st.executeUpdate();
		con.close();
		status=1;
	}
	catch(Exception l){
		l.printStackTrace();
		status=0;
	}
	return status;
	}	
	
	
	
	public static ResultSet executeDBQuery(String sql) throws SQLException{
			try {
				System.out.println("connection try");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(sql);
				System.out.println("connection happen and assign string");
		 
		 if(sql != null){
			if(sql.toLowerCase().startsWith("select")) {			
				rs1 = st.executeQuery(sql);
			} else {
				st.executeUpdate(sql);
				return null;
			}
		}
			}catch (Exception e){e.printStackTrace();}
		 return rs1;
	}

}