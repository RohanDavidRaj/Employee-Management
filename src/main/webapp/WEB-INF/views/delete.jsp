<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% String empId=(String)request.getAttribute("empId"); %>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete</title>
</head>
<body>
	<div class="row">
		<div class="col-3"></div>
		<div>
			<form class="container p-4 " action="./delete" method="post">
				<div class="form-group">
					<label>Employee ID</label> <input name="empId" type="text"
						class="form-control" value=" <%=empId %>" disabled="disabled" >
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Delete</button>
			</form>

</body>
</html>