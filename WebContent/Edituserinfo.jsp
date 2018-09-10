<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User Info</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/EdituserinfoServlet" method ="post" onsubmit="return check()"> 
<tr><td> First name: <input type="text" id ="firstn" name="firstui" placeholder="Enter your first name" required/></td></tr>
<tr><td> Last name: <input type="text" id ="lastn" name="lastui" placeholder="Enter your last name" required/></td></tr>
</table>
<input type="submit" value="Update"/>
</form>
</body>
</html>