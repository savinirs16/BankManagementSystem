<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
</head>
<body>
<%@ include file="header_index.html"%>
<br><br><br>
<center>Registered successfully <%=session.getAttribute("cusid") %><br>
      <a href="Login.jsp" style="color: red;">Click here</a> to login
</center>
</body>
</html>