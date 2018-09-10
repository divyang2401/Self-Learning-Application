<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MCQs</title>
</head>
<body>
	<form name="myForm3" method="post" action="MCQuestionsServlet">
	<input type = "hidden" name = "type" id = "type">
		<table>
			<tbody>
				<tr>
					<td>Enter Question</td>
					<td><input type="text" name="question"></td>
				</tr>
				<tr>
					<td>Choice A:</td>
					<td><input type="text" name="choicea"></td>
				</tr>
				<tr>
					<td>Choice B:</td>
					<td><input type="text" name="choiceb"></td>
				</tr>
				<tr>
					<td>Choice C:</td>
					<td><input type="text" name="choicec"></td>
				</tr>
				<tr>
					<td>Choice D:</td>
					<td><input type="text" name="choiced"></td>
				</tr>
				<td>Answer:</td>
				<td><select name="answer" id="answer">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
						<option value="D">D</option>
				</select></td>
				</tr>
				<tr>
					<td>Hint 1:</td>
					<td><input type="text" name="hint1"></td>
				</tr>
				<tr>
					<td>Feedback:</td>
					<td><input type="text" name="feedback"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save" onclick = " document.getElementById('type').value = 'save';"></td><td><input type="submit" value="Save & Next Question" onclick = " document.getElementById('type').value = 'saveandnext';"></td>
				</tr>
			</tbody>
		</table>
		<a href="./welcome.jsp">Finish!</a>
	</form>
</body>
</html>