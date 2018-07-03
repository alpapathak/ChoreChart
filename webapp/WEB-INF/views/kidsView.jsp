<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
<body>
<div>
	<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
	 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
</div>
<h4>${kidObj.getLoginId()}</h4>
<div>
<div align="center">
<table>
<thead>List OF Chores Assigned and Completed by ${kidObj.getLoginId()}</thead>
<th>Chore Name</th>
<th>Notes</th>
<th>Points</th>
<th>Status</th>
		<c:forEach items="${listOfAllChores}" var="lc">
		<tr><td>
		 	&nbsp;&nbsp;${lc.choreAssigned.choreDesc}</td>
		 	<td>
		 	&nbsp;&nbsp;${lc.notes}
		 	</td>
		 	<td>
		 	&nbsp;&nbsp;${lc.choreAssigned.chorePoints}</td>
		 <td>
		  <a href="<c:url value='complete.jsp'>
				<c:param name='loginId' value= '${kidObj.getLoginId()}'/>
				<c:param name='choreId' value= '${lc.choreId}'/>
			
		</c:url>">
		Complete
		</a>
		</td>
	
	</tr>
		
		</c:forEach>

	</table>
	 </div>
</div>
</body>
</html>