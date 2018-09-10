package com.hw4.model;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String url = "jdbc:mysql://localhost:9050/hw4";
	String uname= "root";
	String pwd= "root";
	
	String ccheck= "select userid from hw4.userinfo where username=? and password=?";
	String ins ="insert into hw4.userinfo(username,password,email,first,last) values(?,?,?,?,?)";
	String exi ="select userid from hw4.userinfo where username = ?";
	
	
public boolean check (String username, String password){
	System.out.println("come in dao file for checking");
 try
 {// userid, username,email, first,last,password,cpassword
	System.out.println("connection try");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,uname,pwd);
	PreparedStatement st = con.prepareStatement(ccheck);
	System.out.println("connection happen and assign string");
	st.setString(1, username);
	st.setString(2, password);
	System.out.println();
	ResultSet rs2 = st.executeQuery();
	if(rs2.next()){
		System.out.println("in logindao if loop");
		return true;
	}
		
}
catch(Exception e){
	e.printStackTrace();
}
return false;
}
	
	
public void add(String username, String password,String email, String first,String last)throws ClassNotFoundException{
		
	try
	{//userid, username,email, first,last,password,cpassword
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pwd);
     	System.out.println("-------------connection happen-------------");
		PreparedStatement st = con.prepareStatement(ins);
		st.setString(1, username);
		st.setString(2, password);
		st.setString(3, email);
		st.setString(4, first);
		st.setString(5, last);
		System.out.println("--------------------assigning variables----------------");
		st.executeUpdate();
		System.out.println("-------------connection gonna close");
		con.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
}	
	public boolean exists (String username)  {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pwd);
			PreparedStatement ps = con.prepareStatement(exi);
			ps.setString(1, username);
			System.out.println("gonna execute result state");
			ResultSet rs3 = ps.executeQuery();
			if(rs3.next()){
				return true;
			}
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}	
}	