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
	<%@ include file="header.jsp" %>
	<h2>Update Product</h2>
	<p style="color: red;">${errorMessage}</p>
	<form action="update" method="post">
		<table>
			<tr>
				<td><input type="text" name="code" value="${product.code}" style="display: none;"></td>
			</tr>
			<tr>
				<td>New name</td>
				<td><input type="text" name="inputName" value="${product.name}"></td>
			</tr>
			<tr>
				<td>New price</td>
				<td><input type="text" name="inputPrice" value="${product.price}"></td>
			</tr>
		</table>
		<input type="submit" value="submit">
		<input type="reset" value="cancel">
	</form>
</body>
</html>