<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>navbar</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-info p-3">
		<a class="navbar-brand" href="#">Employee Management Application</a>
		
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav" >
				<li class="nav-item active"><a class="nav-link text-dark" href="./delete">Delete
				</a></li>
				<li class="nav-item active"><a class="nav-link text-dark" href="./update">Update</a>
				</li>
				<li class="nav-item active"><a class="nav-link text-dark" href="./all">All
						Employee</a>
				<li class="nav-item active"><a class="nav-link text-danger"
					href="./logout">LogOut</a></li>



			</ul>
		</div>
	</nav>

</body>
</html>