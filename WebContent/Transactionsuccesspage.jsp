<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="header.html" %>
</head>
<body>
<h1 style="color: #4db8ff;"><center>
<br><br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;
<% 
	
	out.print("        "+"Statement downloaded successfully......");
%>
&nbsp;&nbsp;&nbsp;&nbsp;
<% 
	out.println("        "+"file name is "+session.getAttribute("filename"));
%>
</center></h1>
</body>
</html>