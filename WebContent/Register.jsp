<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register yourself</title>
</head>
<script type="text/javascript">
function validate(){
var username =document.getElementById("nam");
var pwd = document.getElementById("pwd") ;
var cpwd =document.getElementById("cpwd");
var pop = document.getElementById("poi");

if((pwd.value!= cpwd.value)){
	alert("Password and Confirm Password Should be same!");
	return false;
}	
if(pop!= null){
 pop.style.display= block;
 return false;
}

if(username.value==null || username.value=="" )
{
	if(pwd.value==null || pwd.value=="")
	{	if(cpwd.value==null || cpwd.value=="")
		{
			alert("Username, Password and Confirm Password Cannot be blank");
			return false;
		}
	}
	else if(cpwd.value==null || cpwd.value=="")
	{	alert("Username and confirm password Cannot be blank");
		return false;
	}
	else
	{  alert("Username Cannot be blank");
		return false;
	}
}
else {		
	if (pwd.value==null || pwd.value=="") {
		if (cpwd.value==null || cpwd.value=="") {
			alert("Password and confirm password Cannot be blank");
			return false;
		} else  {
			alert("Password  Cannot be blank");
			return false;}
	}
	else{
		if(cpwd.value==null || cpwd.value==""){
			alert("Confirm password Cannot be blank");
			return false;}	
		}
}
</script>
<body>
<form action ="<%=request.getContextPath() %>/Register.java" method ="post" onsubmit="return validate()">
<table>
<tr><td> FirstName:<input type="text" id ="fir" name="first"  placeholder="Enter firstname" required ></td></tr>
<tr><td> LastName:<input type="text" id ="las" name="last"  placeholder="Enter lastname"></td></tr>
<tr><td> UserName:<input type="text" id ="nam" name="uname"  placeholder="Enter username" required></td></tr>
<tr><td>Password:<input type="password" id="pwd" name="pass" placeholder="Enter pwd" required/></td></tr>
<tr><td>Confirm Password:<input type="password" id="cpwd" name="cpass"  placeholder="Enter c_pwd" required/></td></tr>
<tr> <td>Email:<input type="Email" name="mail" id="emil" placeholder="Enter Email" required/></td></tr>

<tr><td><input type ="submit" value="signup"></td></tr>
</table>
<span id="poi" style="display: none"><%String pass = (String)request.getAttribute("error");%></span>
</form>
<%
String pass_info = (String)request.getParameter("error");
if(pass_info != null){
out.println("<font color= red size =4px>"+ pass_info +"</font>");}
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//Proxy
response.setHeader("Cache-Control","no-cache, no-store, must-revalide");//HTTP 1.1
%>

</body>
</html>