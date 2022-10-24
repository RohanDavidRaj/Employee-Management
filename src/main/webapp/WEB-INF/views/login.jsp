<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String red = (String) request.getAttribute("errMess");
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
<body class=" bg-light">
	<%
	if (red != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=red%>
	</div>
	<%
	}
	%>

	<h1 class="display-1 text-center bg-info">Login</h1>


	<div class="row">
		<div class="col-3"></div>
		<div>
			<form class="container p-4 " action="./login" method="post">
				<div class="form-group">
					<label>Employee ID</label> <input name="empId" type="text"
						class="form-control" placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						name="empPass" type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>


			<div class="container">
				Don't have an account yet? <a
					class="text-decoration-none  font-weight-bold" href="./register">Register
					Here</a>
			</div>
</body>
</html>