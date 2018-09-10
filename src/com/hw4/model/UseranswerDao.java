package com.hw4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hw4.bean.NAnswerbean;

public class UseranswerDao {
	static String url = "jdbc:mysql://localhost:9050/hw4";
	static String username= "root";
	static String password="root";
    static String sav = "insert into hw4.user_values(questionid,answer,username,answer_check) values(?,?,?,?)";		
    static ResultSet rs1;
    
	public void saven(int idn,String status){
		 
		int questionid = idn;
		String useradd= status;

		try {	
		System.out.println("connection try");
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "update hw4.nquestion set status=? where questionid=?";
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println("connection happen and assign string");
		//static String sav = "insert into hw4.user_values(questionid,answer,username,answer_check) values(?,?,?,?)";
		st.setString(1, useradd);
		st.setInt(2, questionid);
		st.executeUpdate();
		con.close();	
	}
	catch(Exception l){
		l.printStackTrace();
	}	
	
	}
	public void savemcq(int idmcq,String status){
		
		int questionid = idmcq;
		String useradd= status;

		try {	
		System.out.println("connection try");
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "update hw4.mquestion set status=? where questionid=?";
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println("connection happen and assign string");
		//static String sav = "insert into hw4.user_values(questionid,answer,username,answer_check) values(?,?,?,?)";
		st.setString(1, useradd);
		st.setInt(2, questionid);
		st.executeUpdate();
		con.close();	
	}
	catch(Exception l){
		l.printStackTrace();
	}	
		
		
	}	
	public void deleteAll(){
		String useradd= null;
		try {	
		System.out.println("connection try");
		Class.forName("com.mysql.jdbc.Driver");
		String sql = "update hw4.nquestion set status=?";
		Connection con = DriverManager.getConnection(url,username,password);
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println("connection happen and assign string");
		//static String sav = "insert into hw4.user_values(questionid,answer,username,answer_check) values(?,?,?,?)";
		st.setString(1, useradd);
		st.executeUpdate();
		con.close();	
	}
	catch(Exception l){
		l.printStackTrace();
	}	
	
	}
	
}
