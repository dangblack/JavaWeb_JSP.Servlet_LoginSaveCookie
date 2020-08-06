<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Demo website sevlet</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- import css -->
<style type="text/css">
	<jsp:include page="../css/index.css"/>
	<jsp:include page="../css/login.css"/>
	<jsp:include page="../css/productlist.css"/>
</style>
<!-- Cách import thứ 2 
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/productlist.css">
 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
	<div class="header">
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="content">
		<jsp:include page="content.jsp"></jsp:include>
	</div>
	<div class="footer">
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script>
		<jsp:include page="../js/program.js"/>
	</script>
</body>

</html>