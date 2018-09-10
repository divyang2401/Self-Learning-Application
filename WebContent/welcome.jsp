<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<% 
if(session.getAttribute("username")== null){
	response.sendRedirect("login.jsp");
    }
response.setHeader("Pragma","no-cache");//HTTP 1.0
response.setHeader("Expires","0");//Proxy
response.setHeader("Cache-Control","no-cache, no-store, must-revalide");//HTTP 1.1
%>

<body>

<h1>Hello welcome page</h1>

<h4 style="text-align: left;">Date and Time:<% Date date = new Date(); %><%=date.toString() %></h4>
<h5><a href="create.jsp"><b>Create Numerical Questions</b></a></h5>
<h6><a href="createMc.jsp"><b>Create MCQ Questions</b></a></h6>

<h7><a href="ViewQuestionServlet"> Answering Questions</a></h7> 
<h8><a href="EditProfile.jsp"> Change Password</a></h8>
<h9><a href="Edituserinfo.jsp"> Change User info</a></h9>

<form action="logout">
<input type="submit" value="Logout">

</form>
</body>
</html>