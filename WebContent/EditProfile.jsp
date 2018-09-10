<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.io.PrintWriter,javax.servlet.http.HttpSession,java.util.List,javax.servlet.ServletRequest"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit your Profile</title>
</head>
<Script>
function check(){
	var cp= document.getElementById("cpass").value;	
	var np= document.getElementById("npass").value;
	var rnp= document.getElementById("rnpass").value;
	
	if (np!=rnp){
		alert("New password and Re-type password should be same");
		return false;
	}

} 
</Script>
<body>
<table>

<form action="<%=request.getContextPath()%>/EditProfileServlet" method ="post" onsubmit=" return check()"> 
<tr><td> Current Password: <input type="password" id ="cpass" name="pwd" placeholder="Enter your curent password" required/></td></tr>
<tr><td> New Password: <input type="password" id ="npass" name="npwd" placeholder="Enter your New password" required/></td></tr>
<tr><td> Re-type New Password: <input type="password" id ="rnpass" name="rnpwd" placeholder="Re-Enter your New password" required/></td></tr>
</table>
<input type="submit" value="Update"/>
</form>
</body>
</html>