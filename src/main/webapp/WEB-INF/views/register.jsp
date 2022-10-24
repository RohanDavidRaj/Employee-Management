<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String green = (String) request.getAttribute("msg");
%>
<%
String red = (String) request.getAttribute("errmsg");
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
<body class="bg-light">

	<%
	if (green != null && !green.isEmpty()) {
	%>
	<div class="alert alert-success" role="alert">
		<%=green%>
	</div>
	<%
	}
	%>

	<%
	if (red != null && !red.isEmpty()) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=red%>
	</div>
	<%
	}
	%>

	<h1 class="display-1 text-center bg-info">Register</h1>


	<form class="container p-4 " action="./register" method="post">
		<div class="form-group">
			<label>Enter Employee Id</label> <input name="empId" type="text"
				class="form-control" placeholder="Enter Id">
		</div>

		<div class="form-group">
			<label>Employee Name</label> <input name="empName" type="text"
				class="form-control" placeholder="Enter name">
		</div>


		<div class="form-group">
			<label>Email address</label> <input name="empEmail" type="email"
				class="form-control" placeholder="Enter email">
		</div>

		<div class="form-group">
			<label>Create Password</label> <input name="empPass" type="password"
				class="form-control" placeholder="Enter password">
		</div>



		<br>
		<button type="submit" class="btn btn-primary" value="register">Submit</button>
	</form>


	<div class="container">
		Already have an account ?  <a class="text-decoration-none " href="./login"> Log In</a>
	</div>



</body>
</html>