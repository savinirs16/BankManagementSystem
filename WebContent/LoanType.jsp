<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header2.html"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoanType</title>

</head>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>

<body>

<br><br><br><br><br><br>
<center><h1 style="color: red;">Apply Loan</h1>
<form action="SwitchController" method="get">
<h1>Select Loan Type</h1>
<table><tr><td>
<select name="loanType" >
  <option selected="selected" style="font-style:italic ;">--SELECT--</option>
  <option value="educational">Educational Loan Form</option>
  <option value="personal">Personal Loan Form</option>
 </select>
 </td></tr>
 <tr><td>
 <br><br>
 <input type="submit" value="Submit"/></td></tr></center><br>
 
</table></form>
<br><br><br><br><br><br><br>
<div align="center">
<a href="CustomerHomePage.jsp" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Cognizant Bank @ All Rights Reserved </marquee>
   </div>
</body>
</html>
