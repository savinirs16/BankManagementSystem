<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="cp.jpg">
<form action="TransactionController" method="get">



      <div class="home-page">
      <br>
<center>
<center><h1>Start Transaction Here</h1></center>
<br><br><br>
<center>Account Number &nbsp; &nbsp; &nbsp;<input type="text" name="accNumber"></center>

<br>
<center><input type="submit" value="Submit" class="myButton" id="submit"></center>



</center>
</div>
</form>
</body>
</html>