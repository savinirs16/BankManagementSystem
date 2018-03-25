<%@page import="com.bms.vo.TransactionVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<%@ include file="header5.html" %>
<style type="text/css">

 
table { 
  margin: 1em 0 3em 0;
}

table tr th, table tr td { 
  background: #323232;
  color: #FFF;
  padding: 0.75em 0.5em;
  text-align: left;
}
  
table tr td { 
  background: #FFF;
  color: #47433F;
  border-top: 1px solid #EEE;
}
.button {
	color: #fff; 
    background: #2BB1E0;	
	border-radius: 30px 30px 30px 30px;
	-moz-border-radius: 30px 30px 30px 30px;
	-webkit-border: 30px 30px 30px 30px; 
}
.center_footer{

color: #1a000d;
font-size:12px;
font-weight:bold;
width:550px;
padding:27px;
text-align:center;
margin-left:250px;
float:left;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="DownloadController" method="get">
<br><br><br>
<h2 style="color: #4db8ff;">Success</h2>
<table border="1">

<tr> <th>Transaction_date</th>
	<th>Transaction Type</th>
	<th>Amount</th>
	<th>Transaction_Balance</th>	
</tr>
<%  
	List<TransactionVO> transactionList = (List)session.getAttribute("tList");
	for(TransactionVO transaction : transactionList){ %>
<tr>
<td>
	<%=transaction.getTransactionDate()  %>

</td>
<td>

<%= transaction.getTransactionType() %>

</td>
<td> 
<%=transaction.getTransactionAmount() %>
</td>
<td> 
	<%out.print(transaction.getBalance()); }%>
</td>
</tr>
</table>
<input type="submit" value="Download" class="button" style="height: 25px;width: 100px"/> 
</form>
<div  align="center"  class="center_footer" style="padding:120px 0 0 280px;" >
<a href="CustomerHomePage.jsp" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" style="color: black; font-size: medium;" >Disclaimer</a>
<br>
<br>
   <marquee>   &copy; CognizantBank @ All Rights Reserved </marquee></div>
</center>
</body>
</html>