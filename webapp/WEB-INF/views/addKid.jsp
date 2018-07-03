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
<title>Add Kid </title>
</head>
<body>
Add Child ${parentObj.userName}
	<form:form id="addKidForm" action="addKidProcess" method="post" modelAttribute="kids">
	<table>
		<thead>
			<tr>
				<th>Add Kid's Information</th>
				<th></th>
			</tr>
		</thead>
			<tbody>
				<tr>
					<td><form:label path="FirstName">First Name</form:label>
					 <form:input path="FirstName"/></td>
					<td><form:label path="LastName">Last Name</form:label>
					 <form:input path="LastName" /></td>
				</tr>
				<tr>
					<td><form:label path="LoginId">Kid's Login Id/username:</form:label>
					<form:input path="LoginId"></form:input></td>
					<td><form:label path="Password">password: </form:label>
					<form:input path="Password"></form:input></td>
				</tr>
				<tr>
					<td><form:input type="date" path="dateOfBirth" />Kid's Date Of Birth</td>
				</tr>
				<tr>
					<td><form:label path="KidsEmail">Kid's Email id(optional)</form:label>
					<form:input path="KidsEmail"></form:input></td>
				<tr>
				<tr>
					<td><form:label path="ParentEmail">Parent's Email id(required)</form:label>
					<form:input path="ParentEmail"></form:input></td>
				<tr>
					<td><input type="submit" value="Submit" /><input type="reset"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
 	

</body>
</html>