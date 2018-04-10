<%@page import="com.model.QuestionController"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<title>Online Exam</title>
	</head>
	<body>
		<%
			QuestionController questionController = new QuestionController();
			ServletContext context = getServletContext();
		%>
		<div>
			<form method="post">
			<table class="table">
				<caption>
					Online Exam
				</caption>
				<thead>
					<tr>
						<th>Question</th>
						<th>True or False</th>
					</tr>
				</thead>
				<tbody>
				
<%= questionController.readQuestionFile(context.getRealPath("WEB-INF/assignment.txt")) %>
					<tr>
						<td>
						</td>
						<td>
							<input type="submit" value="Submit"/>
						</td>
					</tr>
					<%= questionController.handleAnswer(request, out) %>
				</tbody>
			</table>
			</form>
		</div>
	</body>
</html>