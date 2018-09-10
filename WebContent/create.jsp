<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create</title>

<script type="text/javascript">
function check(){
<!--var choice1= document.getElementById("choiceaa").value;	
var choice2= document.getElementById("choicebb").value;
var choice3= document.getElementById("choicecc").value;
var choice4= document.getElementById("choicedd").value;-->
var hint = document.getElementById("hint11").value;
var ans = document.getElementById("answering").value;
var que = document.getElementById("createquestion").value;


if (que==null || que=="" )
{
if(ans=null || area==""){
	alert("Question and Answers Cannot be blank");
	return false;
   }
else{
alert("Question Cannot be blank");
return false;
}
}
else if(hint==null || hint=="")
{
alert("Hint cannot be blank");
return false;
}
} 
</script>

<% 
/*if(session.getAttribute("username")== null){
  response.sendRedirect("login.jsp");
}*/
%>
<style>
 body {
    	
    
}
div {
	width: 35%;
    padding: 10px;
    border: 5px solid black;
}

table{
	padding: 20px;
    border: 5px solid black;
}
</style>
<body>
<br>
<a href="welcome.jsp">Back to Home Page</a>


<center>
<div><h1>

<font size = "5" color = "SlateBlue"> CREATE Numerical Question </font>

</h1></div>
<br>

<form action = "<%=request.getContextPath()%>/CreateServlet" method ="post" onsubmit="return check()" >

	<table>
	<tr><td height="50">
<font color = "Light SlateBlue">Question: </font>

	<td height="30">
<textarea rows="5" cols="50" maxlength="250" id="createquestion" name="cquestion" placeholder="Enter Question here...">
</textarea>
	</td>
</tr>
<tr><td height="30">
<font color = "Light SlateBlue"></font>
<td>
<font color = "Light SlateBlue">Answer: </font><input autofocus type="text" name="answer" id="answering" placeholder= "Enter Answer"/>
</td>
</tr>


<tr><td><center><font color = "Light SlateBlue">Hint: </font><input type="text" name="hint1" id="hint11" placeholder= "Enter Hint 1"/></center></td></tr>
<tr><td><center><font color = "Light SlateBlue">Feedback:</font><input type="text" name="feed" id="feedb" placeholder= "Enter Feedback"/></center></td></tr>
</table>
<input type="submit" value="SUBMIT" >
</center>
</form>
</body>
</html>
