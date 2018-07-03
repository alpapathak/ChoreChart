<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Add Chore </title>
</head>
<body>
<div>
	<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
	 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
</div>
<div>Assign Chores to ${loginId}</div>
<div>
<form:form id="assignChoretoChild" action="addChoreKidProcess" method="post" modelAttribute="chores">
<form:select path="choreId" items="${listOfChores}" itemValue="choreId" itemLabel="choreDesc" />
<tr>
<input type ="hidden" name="loginId" value="${loginId}"/>
					<td><input type="submit" value="Assign to Kid" /></td>
				</tr>
</form:form>
</div>
<div></div><div></div><div></div><div></div>
<br>
<br>
<br>
<br>
<div>
<form:form id="addChoreForm" action="addChoreProcess" method="post" modelAttribute="chores">
	<table>
		<thead>
			<tr>
				<th>New Chore</th>
				<th></th>
			</tr>
		</thead>
			<tbody>
				<tr>
					<td><form:label path="ChoreDesc">Chore Description</form:label>
					 <form:textarea path="ChoreDesc"/></td>
					<td><form:label path="ChorePoints">Points to be awarded</form:label>
					 <form:input path="ChorePoints" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /><input type="reset"></td>
				</tr>
			</tbody>
		</table>
	</form:form>
 	</div>

</body>
</html>