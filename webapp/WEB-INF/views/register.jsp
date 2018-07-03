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
<style type="text/css">
.error {
	color: red;
}
</style>
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

		<form:form id="regForm" action="registerProcess" method="post" modelAttribute="register">
		<table>
			<thead>
			<tr>
				<th>Registration</th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			
				<tr>
					<td><form:label path="FirstName">First Name:</form:label>
					 <form:input path="FirstName"/>
					  <form:errors path="FirstName" cssClass="error" />
					</td>
					<td><form:label path="LastName">Last Name</form:label>
					 <form:input path="LastName" />
					  <form:errors path="LastName" cssClass="error" />
					  </td>
				</tr>
				<tr>
					<td><form:label path="Email_username">Email/UserName:</form:label>
					<form:input path="Email_username"></form:input>
					<form:errors path="Email_username" cssClass="error" />
					</td>
					<td><form:label path="Password">Password: </form:label>
					<form:password path="Password"></form:password>
					<form:errors path="Password" cssClass="error" />
					</td>
				</tr>
				<tr>
					<td>Date Of Birth:<form:input type="date" path="dateOfBirth" />
					<!--<form:errors path="dateOfBirth" cssClass="error" />--></td>
					<td>Receive Newsletter:<form:checkbox path="Newsletter" /></td>
				</tr>
				<tr>			
					<td>Relation to Child :<form:select path="relations">
    						<form:option value="-" label="--Please Select--"/>
    						<form:options items="${relations}"/>
						</form:select>
						<form:errors path="relations" cssClass="error" />
					</td>
				</tr>
	
				<tr>
					<td align="center"><input type="submit" value="Submit" /><input type="reset"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
 	</div>
 </div>
</body>
</html>