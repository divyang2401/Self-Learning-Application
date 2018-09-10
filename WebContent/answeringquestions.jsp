<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.List,java.util.ArrayList,com.hw4.bean.Answerbean, com.hw4.bean.NAnswerbean,java.io.PrintWriter"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Questions</title>

<%HttpSession sessiona = request.getSession();
PrintWriter outs = response.getWriter();
List<NAnswerbean> list1 =(List)sessiona.getAttribute("listN");
List<Answerbean> list2 =(List)sessiona.getAttribute("listMcq");


%>
<script>
function check(){
	alert("function in");	
	var ab = document.getElementById("answern");
	var pq = document.getElementById("answerm");
	alert("function in values assigned");	
	alert(ab);
	alert(pq);
	
	if((ab== null|| ab.equals(null)) && (pq== null|| pq.equals(null))){
		alert("you have to choose one!");}
	
	if((ab != null || (!ab.equals(null)))&& (pq!= null || (!pq.equals(null)))){
		alert("you have to select only one");}
	else{alert("something goes wrong!");}
}
</script>
</head>
<body>

<form action= "<%=request.getContextPath()%>/ViewSQuestion" onsubmit="return check()">

<p>
Numerical Questions:
<select name="answernu" id="answern">
<option value=null>Select anyone</option>
<%for(NAnswerbean e: list1){ 
		
%>
						<option value="<%=e.getQuestionid()%>"><%=e.getQuestionid()%></option>
						<% }%>
</select>
 </p>

<p>
Multiple Choice Questions: 
<select name="answermcq" id="answerm">
<option value=null>Select anyone</option>
<%for(Answerbean r: list2){ %>
						<option value="<%=r.getQuestionid()%>"><%=r.getQuestionid()%></option>
						<% }%>
</select>
</p>

<p><input type="submit" value="Search"> 
</p>
</form>

<h1> Numerical Questions:</h1>
<table border='1' width='100%'> 

<% 
//outs.print("<table border='1' width='100%'");  
//outs.print("<tr><th>QID</th><th>Question</th><th>hint1</th><th>Feedback</th></tr>"); 
%>

<tr><th>QID</th><th>Question</th><th>Status</th><th>Feedback</th></tr>

<% for (NAnswerbean x: list1){
//if(x.getQuestionid()==idn){
%>
<tr><td><%= x.getQuestionid()%></td><td><%= x.getQuestion()%></td><td><%=x.getStatus()%></td><td><%=x.getFeed()%></td></tr>	

<% }

//else {
//String status="pending";%>

<%//}} %>
</table> 

<h2>Multiple Choice Questions:</h2>
<table border='2' width='100%'>

<tr><th>QID</th><th>Question</th><th>Status</th><th>Feedback</th></tr>

<% for (Answerbean p: list2){%>

<tr><td><%= p.getQuestionid()%></td><td><%= p.getQuestion()%></td><td><%=p.getStatus()%></td><td><%=p.getFeed()%></td></tr>

<%}%>
</table>
</body>
</html>
