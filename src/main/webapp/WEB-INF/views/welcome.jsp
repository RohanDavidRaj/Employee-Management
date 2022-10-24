<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<h1 class="display-1 text-center bg-info">Wel-Come</h1> <br>
<br>
<br>
<p class="display-4 text-center"> Hi <mark><%=msg.toUpperCase() %></mark> How are you.....</p>

	
	
</body>
</html>