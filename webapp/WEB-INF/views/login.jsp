<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/css/navbar.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Login Page</title>
</head>
<body>
	<table>
		<thead>
			<tr>
			<th>Login</th>
			<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Enter username :<input type="text" name="username"> </td>
			</tr>
			<tr>
				<td>Enter password :<input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</tbody>
		</table>
		</form>
	</div>
</div>
</body>
</html>