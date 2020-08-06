<%!String getStringAttribute(HttpServletRequest request, String key) {
	//check cookie
		return request.getAttribute(key) == null ? null : request.getAttribute(key).toString();
	}

	private String getCookieByKey(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			return null;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return null;
	}
%>
<%!String fillStringValueToForm(String value) {
	return value == null ? "" : value;
}
%>
<%
	String username = getCookieByKey(request, "username");
%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home" onclick="clickHome()">Demo
				Website Servlet</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="home" onclick="clickHome()">Home</a></li>
				<li><a id="productList" href="#" onclick="clickProductList()">Product
						List</a></li>
				<li><a id="myAccountInfo" href="#">My Account Info</a></li>
			</ul>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

			<ul class="nav navbar-nav navbar-right">
				<li><a id="login" onclick="clickLogin()"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a id="logout" onclick="clickLogout()"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				<li><a><%=fillStringValueToForm(username)%></a></li>

			</ul>

		</div>
	</div>
</nav>