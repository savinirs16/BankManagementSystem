<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="stylelogin.css" />
<%@ include file="headerlogin.html" %>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
</head>
<body>
	<br>
	<div class="container">
	<section id="content">
		<h4 style="text-decoration: blink;color: red;">please enter the correct username or password</h4>
		<form action="LoginController" method="get">
			<h1>Login Form</h1>
			<div>.
				<input type="text" placeholder="Username" required="" id="username" name="uname" required/>
			</div>
			<div>
				<input type="password" placeholder="Password" required="" id="password" name="pass" required/>
			</div>
			<div>
				<input type="submit" value="Log in"  />
				<h2><a href="#">New User! Register</a></h2>
			</div>
		</form>
		
	</section>
</div>
<div align="center">
<a href="IndexPage.jsp" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Cognizant Bank @ All Rights Reserved </marquee>
   </div>
	
</body>
</html>




