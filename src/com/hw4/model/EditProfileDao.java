package com.hw4.model;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.hw4.bean.loginbean;
import java.sql.ResultSet;

public class EditProfileDao {
	static String url = "jdbc:mysql://localhost:9050/ualbanyhangouts";
	static String userforconnection= "root";
	static String passwordforconnection="root";
	    
	java.sql.Connection con = null;
	java.sql.Statement statement = null;
	java.sql.ResultSet resultSet = null;

	//(two parameters in session role and username)
public String retrievePassword(loginbean a){ 

	String user=a.getUser();
String passworddb = null;

String cha= "select * from hw4.userinfo where username=?";
System.out.println(cha);

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url,userforconnection,passwordforconnection);
PreparedStatement po = con.prepareStatement(cha);
po.setString(1,user);
resultSet = po.executeQuery();


while(resultSet.next())
{	passworddb = resultSet.getString("password");
System.out.println("current saved pwd is:"+passworddb);
}
con.close();
return passworddb;
}

catch(Exception e) {
e.printStackTrace();

return "Invalid Process";
}
}

public int changePassword(loginbean l){
	String chap= "update hw4.userinfo set password=?  where username=?";
	
	//update ualbanyhangouts.user_details set password= "dw"  where email="divyang12200730@gmail.com"
	int status=0;
	String email=l.getUser();
	String pwd=l.getPassword();
	
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(url,userforconnection,passwordforconnection);
	PreparedStatement st = con.prepareStatement(chap);
	st.setString(1,pwd);
	st.setString(2, email);

	System.out.println("connection happen and assign string");
	status= st.executeUpdate();
	System.out.println(chap);
	System.out.println(st);
	
	con.close();
	return status;
	}
	catch(Exception e){e.printStackTrace();
	return 0;
	}
}

public void changeUserInfo(String username,String first,String last){

	try{
		Class.forName("com.mysql.jdbc.Driver");
		String sql= "update hw4.userinfo set first=?,last=?  where username=?";
		Connection con = DriverManager.getConnection(url,userforconnection,passwordforconnection);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, first);
		st.setString(2, last);
		st.setString(3, username);
		System.out.println("connection happen and assign string");
		st.executeUpdate();
		System.out.println(sql);
		con.close();
				}
	catch(Exception e){e.printStackTrace();}
	}
}