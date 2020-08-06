<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<table border="1" cellpadding="5" cellspacing="2">
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Price</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
       <c:forEach items="${products}" var="product" >
	<tr>
		<td>${product.code}</td>
		<td>${product.name}</td>
		<td>${product.price}</td>
		<td><a href="update?code=${product.code}">Edit</a></td>
		<td><a href="delete?code=${product.code}" >Delete</a></td>
	</tr>
	 </c:forEach>
	 </table>
	 <a href="create" >Create Product</a>	
</body>
</html>
