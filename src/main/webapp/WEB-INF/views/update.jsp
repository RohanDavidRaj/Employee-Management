<%@page import="com.tc.employeemanagement.entity.EmpEntity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
EmpEntity employee = (EmpEntity) request.getAttribute("entity");

String green = (String) request.getAttribute("msg");
%>
<%@ include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>





<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	if (green != null && !green.isEmpty()) {
	%>
	<div class="alert alert-success" role="alert">
		<%=green%>
	</div>
	<%
	}
	%>
	<br>
	<br>

	<div class="row">
		<div class="col-3"></div>
		<div>
			<form class="container p-4 " action="./update" method="post">
				<div class="form-group">
					<label>Employee ID</label> <input name="empId" type="text"
						class="form-control" value=" <%=employee.getEmpId()%>"
						disabled="disabled">
				</div>
				<br>

				<div class="form-group">
					<label>Employee Name</label> <input name="empName" type="text"
						class="form-control" value=" <%=employee.getEmpName()%>">
				</div>
				<br>

				<div class="form-group">
					<label>Employee ID</label> <input name="empEmail" type="text"
						class="form-control" value=" <%=employee.getEmpEmail()%>">
				</div>
				<br>

				<div class="form-group">
					<label>Employee Password</label> <input name="empPass"
						type="password" class="form-control"
						value=" <%=employee.getEmpPass()%>">
				</div>
				<br>




				<button type="submit" class="btn btn-primary">Update
					Details;</button>
			</form>
</body>
</html>