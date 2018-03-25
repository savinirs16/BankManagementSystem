<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="header.html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Loan Form</title>
</head>
<body>
<form action="LoanTypeController"  method="get">
<br>
<center><h1>Personal Loan form</h1></center>

<td align="center" valign="middle">Loan Amount</td><td><input type="text" name="loanAmount" required/></td></tr><br><br>
<td align="center" valign="middle">Loan Apply Date</td><td><input type="text" name="loanApplyDate" value="yyyy-MM-dd" required/></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<br><br>

<td align="center" valign="middle">Rate of Interest </td><td><input type="text" name="rateOfInterest" value="11%"/></td></tr><br><br>
<td align="center" valign="middle">Duration of Loan </td><td><select size="number" name="duration"><option value="5">5</option><br><br>
<option value="10">10</option>
<option value="15">15</option>
<option value="20">20</option></select> </td></tr><br><br>
<td align="center" valign="middle">Annual Income </td><td><input type="text" name="annualIncome" required/></td></tr><br><br>
<td align="center" valign="middle">Company </td><td><input type="text" name="company" required></td></tr><br><br>
<td align="center" valign="middle">Designation </td><td><input type="text" name="designation" required/></td></tr><br><br>
<td align="center" valign="middle">Total Experience </td><td><input type="text" name="totalExperience" required/></td></tr><br><br>
<td align="center" valign="middle">Experience with current</td><td> <input type="text" name="myExperienceWithCurrentCompany" required/></td></tr><br><br>
<td align="center" valign="middle">Guaranteer Name</td><td> <input type="text" name="guaranteerName" required/></td></tr><br><br>
<td align="center" valign="middle">Guaranteer Address </td><td><textarea rows="2" cols="16" name="guaranteerAddress" required></textarea></td></tr><br><br>
<td align="center" valign="middle">Guaranteer Income </td><td><input type="text" name="guaranteerIncome" required/></td></tr><br>

<br><br><tr><td align="center" valign="middle"><input type="submit" value="Apply"/></td>

</form>
</center></div>
  <footer>
 <marquee> Copyright © Cognizant Bank</h3></marquee>
</footer>
</body>
</html>

</body>
</html>