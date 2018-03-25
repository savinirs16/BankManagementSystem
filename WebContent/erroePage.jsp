<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
</head>
<center><body>
<div
   style="
      top:8cm ;
      left: 15cm;
      position: absolute;
      z-index: 1;
      visibility: show;">

<h1 style="color: red;"><%=session.getAttribute("errMsg") %></h1>
</div>
</body></center>
</html>