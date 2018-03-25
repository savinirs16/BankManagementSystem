<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Loan Success Page</title>
</head>
<body>
<br><br><br><br><br>
<center><h1><% 
	String loanID=(String)session.getAttribute("LoanID");
	out.print("Loan Applied Successfully with LoanID "+loanID);%>
	<br>
	<% out.print(" Your Loan request will be Processed within 30 Working days");
%></h1></center>
</body>
</html>