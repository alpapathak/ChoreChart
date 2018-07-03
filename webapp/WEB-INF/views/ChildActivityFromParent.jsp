<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<script language = "javascript">

/*var x = document.getElementById("reason");
var y = document.getElementById("points");
y.addEventListener("blur", myBlurFunction, true);


function myBlurFunction() {
	 document.getElementById("pointsAwarded").value=document.getElementById("points").value; 
}*/
function addURL(){
	alert("abc "+href);
}
</script>
</script>
<title>Activity Page </title>
</head>
<body>
 <div>
		<img src="/resources/images/chorechart.jpg"  width="200px" height="200px">
	 	 <div align="right">
			<a href="loginParents.jsp">Parent Login</a>
			<a href="loginChilds.jsp">Kids Login</a>
	</div>
	</div>
<div align="center">
<table>
	<thead>Chores to be approved for '${loginId}'</thead>
		<th>Chore Name</th>
		<th>Notes</th>
		<th>Status</th>
		<th>Points</th>
		<c:forEach items="${allChoresOfKids}" var="lc">
 		<tr><td>
		 	 &nbsp;&nbsp;${lc.choreAssigned.choreDesc}</td>
		 	 <td>&nbsp;&nbsp;${lc.notes}</td>
		 	 <td>&nbsp;&nbsp;${lc.choreStatus}</td>
		 	 <td>&nbsp;&nbsp;${lc.choreAssigned.chorePoints}</td>
		 	 <td>
		 	 <a onclick="addURL();" href="<c:url value='approve.jsp'>
				<c:param name='loginId' value= '${loginId}'/>
				<c:param name='choreId' value= '${lc.choreId}'/>
				<c:param name='pointsAwarded' value= '${lc.choreAssigned.chorePoints}'/>
		</c:url>">
		Approve
		</a>  
		Points to award : <input type="text" size="3" />
		</td>
		 <td>
		 	 <a href="<c:url value='reassign.jsp'>
				<c:param name='loginId' value= '${loginId}'/>
				<c:param name='choreId' value= '${lc.choreId}'/>
		</c:url>">
		Reassign
		</a>
		Reason for reassign : <input type ="text" id="reason" size="3"/>
		</td>
		</tr>
		 </c:forEach>
	</table>
 </div>
 
 <div align= "left">
 <a href="<c:url value='addChore.jsp'>
			<c:param name='loginId' value= '${loginId}'/>
		</c:url>">
	Assign New Chore</a>
 </div>
 
</body>
</html>