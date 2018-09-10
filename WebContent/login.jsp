<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<script type="text/javascript">
function Validatation()
{	var username= document.getElementById("username");
	var password= document.getElementById("password");
	
	if(username.value==null || username.value=="" )
	{	
		if(password.value==null || password.value=="")
		{	alert("Username and Password  Cannot be blank");
			return false;
			}	
		else
		{
			alert("Username Cannot be blank");
			return false;
		}
	}	
	if(password.value==null || password.value==""){alert("Password Cannot be blank");
					return false;}
}
</script>
<body>
<form action="<%=request.getContextPath() %>/Login" method="post" onsubmit="return Validatation()">
<table>
<tr>

<td> UserName:<input type="text" id="username" name="uname" placeholder="Enter username"/></td>
</tr>
<tr><td>Password:<input type="password" id="password" name="pass" placeholder="Enter Password" /></td>
</tr>

	<input type="submit" value="Login" ></td>
<td><a href="Register.jsp">Register</a></td></tr>
</table>
</form>
<%
System.out.println("---------------------0a--------------");

String pass_info = (String)request.getParameter("error");
if(pass_info != null)
{out.println("<font color= red size =4px>"+ pass_info +"</font>");}
String user_info = (String)request.getParameter("username");
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//Proxy
response.setHeader("Cache-Control","no-cache, no-store, must-revalide");//HTTP 1.1
%>
</body>
</html>