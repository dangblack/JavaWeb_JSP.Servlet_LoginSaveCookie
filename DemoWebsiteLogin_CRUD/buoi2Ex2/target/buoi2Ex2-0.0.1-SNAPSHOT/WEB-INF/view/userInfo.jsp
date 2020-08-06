<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="body">
		<h2>Hello ${loginedUser.userName}</h2>
		<p>
			User name: <b>${loginedUser.userName}</b>
		</p>
		<p>Gender: ${loginedUser.gender}</p>
	</div>
</body>
</html>