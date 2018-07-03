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
<title>Parents Viewing Page</title>
</head>
<body>
<div>
	<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
	 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
</div>


<div>${parentFName} ${parentLName}   ${userName} </div>

 <!--  <div align= "right">
 	<a href ="addChore.jsp?userName=${userName}">Add New Chore</a>
 </div>
 -->
<div>
	<table>
	<tr>
		<th>Children</th>
	</tr>
	<c:forEach items="${listOfKids}" var="s">
	<tr><td>
		<a href="<c:url value='ChildActivityFromParent.jsp'>
			<c:param name='loginId' value= '${s.loginId}'/>
		</c:url>">
		${s.loginId}</a>
	</c:forEach>
	</td>
	</tr>
	</table>
 </div>
 <br>
 <br>
 <div>
 	<a href="addKid.jsp?userName=${userName}">Add Kid </a>
 </div>
 <div align="center">
 <table>
 <tr>
 </tr>
 </table>
 </div>
</body>
</html>