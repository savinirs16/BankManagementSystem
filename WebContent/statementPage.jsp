<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header5.html" %>

<style type="text/css">
body{
background-image: url("cp.jpg");
}

	.button {
	color: #fff; 
    background: #2BB1E0;	
	border-radius: 7px 7px 7px 7px;
	-moz-border-radius: 7px 7px 7px 7px;
	-webkit-border: 7px 7px 7px 7px; 
}
.center_footer{

color: #1a000d;
font-size:12px;
font-weight:bold;
width:550px;
padding:20px;
text-align:center;
margin-left:250px;
float:left;
}


 </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="datetimepicker.js"></script>

</head>



<body>

<br><br><br>
<center>
<h2>Statement Generation</h2>
<br><br>
<form action="StatementController" method="post">

<div class="fd" style="margin-right: 10px; ">
FromDate <input type="Text" id="demo1" maxlength="25" size="25" name="fDate" required>
<a href="javascript:NewCal('demo1','ddMMyyyy',true,24)">
<img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

ToDate <input type="Text" id="demo2" maxlength="25" size="25" name="tDate" required>
<a href="javascript:NewCal('demo2','ddMMyyyy',true,24)">
<img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a> 
</div>
<br>


<br><br><br>
<div class="tt" style="margin-right: 100px">
Transaction Type <select name="transactionType" required>
<option value="withdraw">Withdraw</option>
<option value="deposit">Deposit</option>
<option value="both">Both</option>
</select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Number <select name="limit" required>
<option value="5">5</option>
<option value="10">10</option>
<option value="20">20</option>
</select><br><br><br><br><br></div>

<input type="submit" value="View" class="button" style="height: 25px;width: 100px"/> 
<br><br><br><br>

</form>
<div  align="center"  class="center_footer" style="padding:120px 0 0 280px;" >
<a href="CustomerHomePage.jsp" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>
<br>
<br>
   <marquee >   &copy; Bms @ All Rights Reserved </marquee></div>
</center>


</body>

</html>