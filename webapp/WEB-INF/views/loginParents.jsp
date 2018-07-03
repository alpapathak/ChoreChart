<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Registration</title>
</head>
<body>
<div>
	<div>
		<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
		 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
	 </div>

		<form:form id="parentLoginForm" action="findParentUser" method="post" modelAttribute="parents">
		<table>
			<thead>
			<tr>
				<th>Parents Login Page</th>
				<th></th>
			</tr>
			</thead>
			<tr>
				<td><form:label path="UserName">Email/UserName:</form:label>
						<form:input path="UserName"></form:input>
				<form:label path="Password">Password: </form:label>
					<form:password path="Password"></form:password></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</tr>
					
		</table>
	</form:form>
 	</div>
</body>
</html>