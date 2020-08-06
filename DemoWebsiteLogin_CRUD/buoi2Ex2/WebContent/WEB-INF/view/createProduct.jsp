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
	<h2>Create Product</h2>
	<p style="color: red;">${errorMessage}</p>
	<form action="create" method="post">
		<table>
			<tr>
				<td>Code</td>
				<td><input type="text" name="inputCode"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="inputName"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="inputPrice"></td>
			</tr>
		</table>
		<input type="submit" value="submit">
		<input type="reset" value="cancel">
	</form>
</body>
</html>