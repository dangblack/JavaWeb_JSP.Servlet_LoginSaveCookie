<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<div class="loginView">
    <h2>Login page</h2>
    <p style="color: red;">${errorMessage}</p>
    <form action="login" method="post">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" value="${userName}"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="passWord" value="${passWord}"></td>
            </tr>
            <tr>
                <td>Remember me</td>
                <td><input type="checkbox" name="rememberMe"></td>
            </tr>
        </table>
        <input type="submit" value="submit">
        <input type="reset" value="cancel">
    </form>
</div>
</body>
</html>