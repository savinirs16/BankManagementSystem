<%@page import="com.bms.vo.UpdateProfileVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.HashMap"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="headerupd.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Welcome To Update-Profile page</title>
<script type="text/javascript">

function validateemail()
{
  var mail=document.getElementById("email").value;	
  var mail_pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if(mail=="")
  
  document.getElementById('message').innerHTML="Please enter Your E-MailID";
  
  else if(mail_pattern.test(mail)==false)
  document.getElementById('message').innerHTML="Enter a Valid E-Mail Id";

  else
  
  document.getElementById('message').innerHTML="";
}

function validateguardianname()
{
	var name=document.getElementById("name").value;
	var letters = /^[A-Za-z]+$/;
	
	 if(name=="")
			document.getElementById("message").innerHTML="Please fill the guardian name column";
	 else if((!name.match(letters)) )
		document.getElementById("message").innerHTML="Enter the guardian name in alphates only";
	else 
        document.getElementById("message").innerHTML="";
	}

function validatephone()
{
	var mobile = document.getElementById("custcontact").value;
	
	 if(mobile=="")
			document.getElementById("message").innerHTML="Please fill the contact number field";
	 else    if(isNaN(mobile))
	    	  document.getElementById("message").innerHTML="Enter only  numbers into the Contact Number field.";      
	       
	 else    if(mobile.length!=10)
	    	  document.getElementById("message").innerHTML="Enter 10 digits Contact Number.";
	 else    if(mobile==null)
   	  document.getElementById("message").innerHTML="Enter valid Contact Number.";
	 else 
	        document.getElementById("message").innerHTML="";
	          
}




</script>
<script src="javascript/cms.js"></script>

 <script type="text/javascript">
	/*Retriew Country details From backend*/
<%Map<String, String> countryDetails = (HashMap<String, String>) session.getAttribute("countryDetails");%>
<%String[] cdValues = countryDetails.values().toArray(new String[0]);
String[] cdKeys = countryDetails.keySet().toArray(new String[0]);%>
 var country_arr = new Array();  
 var country_ids = new Array(); 
 <%for (int i=0; i < cdValues.length; i++) {%>  
 country_arr[<%= i %>] = '<%=cdValues[i] %>'; 
 country_ids[<%= i %>] = '<%=cdKeys[i] %>'; 
 <%}%> 
 /*Retriew State details From backend*/
 
 <%Map<String, String> stateDetails = (HashMap<String, String>) session.getAttribute("stateDetails");%>
 <%String[] stateValues = stateDetails.values().toArray(new String[0]);
  String[] stateKeys = stateDetails.keySet().toArray(new String[0]);%>
  var state_arr = new Array();  
  var state_ids = new Array(); 
  <% for (int i=0; i < stateValues.length; i++){%>
  	state_ids[<%= i %>] = '<%=stateKeys[i] %>'; 
    state_arr[<%= i %>] = '<%=stateValues[i] %>'; 
  <%}%> 
  </script>

<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>

</head>
<center><body>

 <% 
		UpdateProfileVO updateprofileVO = (UpdateProfileVO) session.getAttribute("customerVO");
	
	%>



 <form action="UpdateProfileController" method ="post">
 <span id="message" style="color: red"></span><br>
<center><h2><font color="white" size="100px"></font>Update Profile</h2></center> 
<table border="1" width="350px" height="480px" bordercolor="black" align="center" cellpadding="6px" cellspacing="0px" >

<tr><td>Customer id <font color=red>*</font></td><td><%=updateprofileVO.getCusid()%></td></tr>

<tr><td>Name <font color=red>*</font></td><td><%=updateprofileVO.getName()%></td></tr>
<tr><td>Account Number  <font color=red>*</font></td>
<td><%=updateprofileVO.getAccno()%></td></tr>
<tr><td>Guardian Type  <font color=red>*</font></td>
<td><input type="text" name="GuardianType" value="<%=updateprofileVO.getGuardiantype()%>" /></td></tr>
<tr><td>Guardian Name  <font color=red>*</font></td>
<td><input id="name" type="text" name="GuardianName" value="<%=updateprofileVO.getGuardianname()%>" onblur="validateguardianname()" /></td></tr>
<tr><td> Address  <font color=red>*</font></td><td>
<textarea rows="2" cols="17" name="address" "/><%=updateprofileVO.getAdd()%></textarea></td>
<tr><td>Citizen Ship  <font color=red>*</font></td>
<td><input type="text" name="CitizenShip" value="<%=updateprofileVO.getCitizenship()%>" /></td></tr>

<tr><td>Country <font color=red>*</font></td>
<td><select	name="countryid" id="countryid" class="textbox" required/></td></tr>



<tr><td>State  <font color=red>*</font></td>
<td><select id="stateid" name="stateid" class="textbox">
<script language="javascript">
			populateCountries("countryid", "stateid");
		</script>
</td></tr>




       
  <tr><td>EmailID <font color=red>*</font></td><td><input type="text" id="email" name="EmailID" value="<%=updateprofileVO.getEmailID()%>" onblur="validateemail()"/></td></tr>
  <tr><td>Gender  <font color=red>*</font></td><td><%=updateprofileVO.getGender()%></td></tr>

  <tr><td>Marital Status  <font color=red>*</font></td>
<td><input type="text"  name="MaritalStatus"  value="<%=updateprofileVO.getMarital()%>" />
</td>
</tr>
<tr><td>Contact Number  <font color=red>*</font></td><td><input id="custcontact" type="text" name="ContactNumber" value="<%=updateprofileVO.getContact()%>" onblur="validatephone()" /></td>
</tr> 
<tr><td>DateofBirth<font color=red>*</font></td><td><%=updateprofileVO.getDob()%></td></tr>
<tr><td>Identification proof type  <font color=red>*</font></td><td><select name="Identificationprooftype" value="<%=updateprofileVO.getIdtype()%>" >
<option selected="selected" >Select ProofType</option>
<option value="Aadhar Card" >Aadhar Card</option>
<option value="PAN Card">PAN Card</option>
<option value="Passport">Passport</option>
<option value="Voter ID">Voter ID</option>
</select></td></tr>
 <tr><td>IdentificationDocumentNumber<font color=red>*</font></td>
 <td><input type="text" name="IdentificationDocumentNumber"  value="<%=updateprofileVO.getDocnum()%>" /></td>
</tr>
<tr><td>Reference Account Holder Name  <font color=red>*</font></td><td><%=updateprofileVO.getAccholdername()%></td></tr>
<tr><td>Reference Account Holder contact Number  <font color=red>*</font></td><td><%=updateprofileVO.getAccholdernum() %></td></tr>
<tr><td>Reference Account Holder Address  <font color=red>*</font></td><td><%=updateprofileVO.getAccholderadd()%></td></tr>

<tr><td>Account Type  <font color=red>*</font></td>
<td><input type="text" name="AccountType"  value="<%=updateprofileVO.getAcctype() %>" />
</td>

</tr>
 <tr><td>Branch Name  <font color=red>*</font></td><td><%=updateprofileVO.getBranchname() %></tr>

 <tr><td>Registration Date  <font color=red>*</font></td><td><%=updateprofileVO.getRegdate()%></td></tr>
 <tr><td>Citizen Status  <font color=red>*</font></td><td><%=updateprofileVO.getCitizenstatus()%></td></tr>
 <tr><td>IFSC Code  <font color=red>*</font></td><td><%=updateprofileVO.getIfsc()%></td></tr>
 </table></td></tr></table>
<center>
<font color='red'>  </font>
<table style="margin-center: 180px; "><tr><td></td><td><input type="submit" value="update" id="update"></td><td></td></tr></table></center>
</form>
<br>
<br>
<div align="center">
<a href="" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Cognizant Bank @ All Rights Reserved </marquee>
   </div>
</body></center>
</html>