<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file= "header.html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Loan Error Page</title>
</head>
<body>
<br><br><br><br><br>
<center><img src="err1.jpg">
<br><br><br>
<h1 style="color:red;"><%out.print(session.getAttribute("errmsg")); %></h1>
<a href="" style="color:red;">Click here</a> to go back to HOME PAGE... </center>
</body>
</html>