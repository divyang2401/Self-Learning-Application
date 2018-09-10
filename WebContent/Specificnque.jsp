<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import ="java.util.List,com.hw4.bean.NAnswerbean"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>Specific numerical question page</title>
<script>
function check(){
	var useranswer=document.getElementById("useranswer");
	var answerbyhid=document.getElementById("ans").value ;
	var hint=document.getElementById("hint").value ;

	if(useranswer==answerbyhid|| useranswer.equals(answerbyhid)){
	alert("answerbyhid"+answerbyhid);
	document.getElementById("demo").innerHTML= "your answer is correct!"; 
	return true;
	}
	else{
		document.getElementById("demo").innerHTML="your answer is wrong!"+hint;
		return false;	}
}
function fin(){
	var useranswer =document.getElementById("useranswer");
	if(useranswer==null || useranswer.equals(null)){alert("empty answer is not valid");
	return false;
	}
	else {return true;}
}
</script>
</head>
<body>
<table>
<center>
<c:forEach items="${sessionScope.questidforn}" var="i">
	<tr><td>Q:${i.questionid}: ${i.question}</td></tr>
	<input type="hidden" name="question" value="${i.question}">
	<input type="hidden" name="answert" id="ans" value="${i.answer}">
	<input type="hidden" name="hint1" id="hint" value="${i.hint1}">

</c:forEach>
</center>
<p id="demo"></p>
<center>
<p>
<form action="<%=request.getContextPath() %>/Userservlet" onsubmit="return check()">
<tr><td>Answer:<input type="text" name="useranswer" id="uanswer"></td></tr>
<input type="submit" value="Check Answer">
</form>
</center>

<form onsubmit=" return fin()">
<input type="submit" value="Finish">
</form>
</p>
</table>
</body>
</html>