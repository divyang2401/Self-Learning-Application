<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.io.PrintWriter,javax.servlet.http.HttpSession,com.hw4.bean.Answerbean,java.util.List,javax.servlet.ServletRequest"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
</head>
<%
if(session.getAttribute("username")== null){
  response.sendRedirect("login.jsp");
}
 response.setContentType("text/html");  
PrintWriter oput = response.getWriter();
oput.println("<a href='Welcome.jsp'>Welcome Again</a>");  
oput.println("<h1>Questions List</h1>");  
oput.print("<table border='1' width='100%'");
	System.out.println("-------------------------after table border------------");
//oput.print("<tr><th>Title</th><th>TextPart</th><th>Speaker</th><th>Speakerinfo</th><th>Venue</th><th>Time</th><th>Date</th></tr>");  
try{
	System.out.println("in try in ViewQuestion.jsp");
	 HttpSession sessionp =request.getSession();
	 List<Answerbean> listo= (List)sessionp.getAttribute("boost");
	 List<Answerbean> pop = listo;
	 if(!pop.isEmpty()){
		 System.out.println("------------not empty------------");}
	 else{
		 System.out.println("------ empty----------");}
	 System.out.println("view question.jsp after pop list");
	 System.out.println("--------size-----------"+ pop.size());
	 try{
		 System.out.println("try and try");
	 for(Answerbean a:pop)
     { System.out.println("Answebean deployed");
	    oput.print("<tr><td>"+ a.getQuestionid()+"</td><td>"+a.getQuestion()+"</td><td>"+a.getChoicea()+"</td><td>"+a.getChoiceb()+"</td><td>"+a.getChoicec()+"</td><td>"+a.getChoiced() +"</tr>"); 
     }
	 }
 	 catch(Exception e){e.printStackTrace();
	 System.out.println("in in catch");
	 }
}
 catch(Exception e){e.printStackTrace();
 System.out.println("in catch statement");
 }
 oput.print("</table>");
 oput.close();
%>
<body>
</body>
</html>