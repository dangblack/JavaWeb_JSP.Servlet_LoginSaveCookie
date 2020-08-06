<div class="header">
	<div class="headerBar"
		style="height: 100px; background-color: lightgray;">
		<div style="float: left;">
			<h1>My Site</h1>
		</div>
		<div style="float: right;">
			<p style="text-align: right;">Hello ${loginedUser.userName}</p>
			search <input type="text">
		</div>
	</div>
	<div class="navigation bar" style="margin-left: 100px;">
		<a href="./home">Home</a>|
        <a href="./productList">Product List</a>|
        <a href="./userInfo">My account info</a>|
        <c:choose>
   			<c:when test="${empty loginedUser }"><a href="./login">Login</a></c:when> 
   			<c:otherwise><a href="./logout">Logout</a></c:otherwise>    
		</c:choose>

	</div> 
</div>