<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header.html"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EducationLoanForm</title>
</head>
<body>

<form action="LoanTypeController"  method="get" >
<br><br><center><h1>Education Loan form</h1></center>

Loan Amount<input type="text" name="loanAmount" required/><br><br>
Loan Apply Date<input type="text" name="loanApplyDate" value="yyyy-MM-dd" required/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<br><br>
Rate of Interest <input type="text" name="rateOfInterest" value="9%"/><br><br>
Duration of Loan <select size="number" name="duration"><option value="5">5</option><br><br>
<option value="10">10</option>
<option value="15">15</option>
<option value="20">20</option></select> <br><br>
Course <input type="text" name="course" required/><br><br>
Course Fee<input type="text" name="courseFee" required/><br><br>
Father's Name <input type="text" name="fathersName" required/><br><br>
Father's Occupation  <input type="text" name="fathersOccupation" required/><br><br>
Father's Total Experience <input type="text" name="fathersTotalExperience" required/><br><br>
Fathers Total Experience with Current Company <input type="text" name="fathersTotalExpWithCurrentCompany" required/><br><br>
Ration Card No.<input type="text" name="rationCardNumber" required/><br><br>
Father's Annual Income<input type="text" name="annualIncome" required/><br><br>


<br><br><input type="submit" value="Apply"/>


</form>
</center></div>
<footer>
 <marquee> Copyright © Cognizant Bank</marquee>
</footer>

</body>
</html>