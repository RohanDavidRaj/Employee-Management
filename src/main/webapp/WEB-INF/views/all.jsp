<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.tc.employeemanagement.entity.EmpEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<EmpEntity> list = (List<EmpEntity>) request.getAttribute("list");
%>

<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">


<title>Insert title here</title>
</head>
<body>

<div class="row container">

<h1 class="display-3 text-center">All Employee Data</h1>
	<br>



	<div col-sm><form class="form-inline container-sm m-5 " action="./all"
		method="post">
		<input name="value" class="form-control mr-sm" type="search"
			placeholder="Search" aria-label="Search"> <br>
		<button type="submit" class="btn btn-outline-info">Search by
			First Alphabet</button>
	</form></div>

</div>


	
	


	<table class="table container">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
			</tr>
		</thead>
		<%
		int i = 1;
		%>
		<%
		for (EmpEntity emp : list) {
		%>


		<tbody>
			<tr>
				<th scope="row"><%=i++%></th>
				<td><%=emp.getEmpId()%></td>
				<td><%=emp.getEmpName()%></td>
				<td><%=emp.getEmpEmail()%></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>


</body>
</html>