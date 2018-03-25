<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.bms.vo.UpdateProfileVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<head>
<%@ include file="headerupd.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<% 
		UpdateProfileVO updateprofileVO = (UpdateProfileVO) session.getAttribute("updateprofileVO");
       %>
	
<body>
<center>
<br><br>
<a href="UpdateProfile.jsp" style="color: red;"> Update </a> 
   <p><font style="Bold" color="green" size="6">Account Details Updated Successfully!!!</font><p>
  <br>
  <br>
  <br>
  
  <table style="font-size:0.5" border="1" width="300px" height="100px" bordercolor="grey" align="center" cellpadding="0px" cellspacing="0px" >
    <tr><td>GuardianType <font color=red></font></td><td><%=updateprofileVO.getGuardiantype()%></td></tr>
    <tr><td>GuardianName <font color=red></font></td><td><%=updateprofileVO.getGuardianname()%></td></tr>
    <tr><td>Address <font color=red></font></td><td><%=updateprofileVO.getAdd()%></td></tr>
    <tr><td>CitizenShip <font color=red></font></td><td><%=updateprofileVO.getCitizenship()%></td></tr>
    <tr><td>Country <font color=red></font></td><td><%=updateprofileVO.getCountry()%></td></tr>
    <tr><td>State <font color=red></font></td><td><%=updateprofileVO.getState()%></td></tr>
    <tr><td>EmailID <font color=red></font></td><td><%=updateprofileVO.getEmailID()%></td></tr>
    <tr><td>Marital Status <font color=red></font></td><td><%=updateprofileVO.getMarital()%></td></tr>
    <tr><td>Contact Number <font color=red></font></td><td><%=updateprofileVO.getContact()%></td></tr>
    <tr><td>IdentificationProofType <font color=red></font></td><td><%=updateprofileVO.getIdtype()%></td></tr>
    <tr><td>IdentificationDocumentNumber &nbsp<font color=red></font></td><td><%=updateprofileVO.getDocnum()%></td></tr>
    <tr><td>Account Type<font color=red></font></td><td><%=updateprofileVO.getAcctype()%></td></tr>
    
      </table>
  
</center>
</body>
</html>