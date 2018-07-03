<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Kids Login Page</title>
</head>
<body>
	<div>
		<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
		 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
	 </div>
	 <div>
	<form:form id="kidsLoginForm" action="findKidUser" method="post" modelAttribute="kids">
		<table>
			<thead>
			<tr>
				<th>Kids Login Page</th>
				<th></th>
			</tr>
			</thead>
			<tr>
				<td><form:label path="LoginId">Login Id:</form:label>
						<form:input path="LoginId"></form:input>
				<form:label path="Password">Password: </form:label>
					<form:password path="Password"></form:password></td>
			</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
				
					
		</table>
	</form:form>
 	</div>
</body>
</html>