<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.HashMap"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<%@ include file="header_reg.html"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Page</title>
<script type="text/javascript">
function validatename()
{
	var name=document.getElementById("name").value;
	var letters = /^[A-Za-z]+$/;
	
	 if(name=="")
			document.getElementById("message").innerHTML="Please fill the name column";
	 else if((!name.match(letters)) )
		document.getElementById("message").innerHTML="Enter the name in alphates only";
	else 
        document.getElementById("message").innerHTML="";
	}

function validateuname()
{
	var name=document.getElementById("uname").value;
	var letters = /^[A-Za-z]+$/;
	
	 if(name=="")
			document.getElementById("message").innerHTML="Please fill the user name column";
	 else if((!name.match(letters)) )
		document.getElementById("message").innerHTML="Enter the user name in alphates only";
	else 
        document.getElementById("message").innerHTML="";
	}
	
function validateemail()
{
  var mail=document.getElementById("email").value;	
  var mail_pattern=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if(mail=="")
  
  document.getElementById('message').innerHTML="please enter Your E-MailID";
  
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

function passwordVal()
{
var password=document.getElementById("password").value; 
var re=/^[a-zA-Z0-9!@#$%^&*]{8,16}/;
if(password=="")
	
	document.getElementById("message").innerHTML="Please enter the password field";
else if(!re.test(password))

document.getElementById("message").innerHTML="The password should be a Combination of at least one number, one lowercase, one uppercase letter and at least eight characters";

else 
    document.getElementById("message").innerHTML="";
}


function confirmpasswordVal()
{
var password=document.getElementById("password").value;
var confirmpassword=document.getElementById("confirmpassword").value;
if(confirmpassword!=password)
{
document.getElementById("message").innerHTML="Password doesn't match...re enter correct password!";
}
}

function validateaccholdername()
{
	var name=document.getElementById("accholdername").value;
	var letters = /^[A-Za-z]+$/;
	
	 if(name=="")
			document.getElementById("message").innerHTML="Please fill the Account holder name column";
	 else if((!name.match(letters)) )
		document.getElementById("message").innerHTML="Enter the Account Holder name in alphates only";
	else 
        document.getElementById("message").innerHTML="";
}
function validateaccholdernum()
{
	var num=document.getElementById("accholdernum").value;
	if(num=="")
		document.getElementById("message").innerHTML="Please fill the Reference Account holder number field";
	else    if(isNaN(num))
  	  document.getElementById("message").innerHTML="Enter only  numbers into the Reference Account Holder Number field."; 
	
}
</script>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
    <link rel="stylesheet" type="text/css" href="demo.css" media="all" />
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
</head>
<center>
<body>




<form action="RegistrationController" method="post">
<br>
<br><h1>REGISTRATION</h1>

<table border="1" cellpadding="4.2" cellspacing="0"> 
<tr><span id="message" style="color:red"></span><br>   

<tr><td>Name<span style="color:red">*</span></td><span id="message" style="color: red"></span><td><input type="text" name="name" id="name" onblur="validatename()" ></td></tr>
<tr><td>UserName<span style="color:red">*</span></td><span id="message" style="color: red"></span><td><input type="text" name="uname" id="uname" onblur="validateuname()" ></td></tr>
<tr><td>Password<span style="color:red">*</span></td><td><input type="password" name="pass" id="password" onblur="passwordVal()"/></td></tr><span id="message" style="color: red"></span>
<tr><td>RetypePassword<span style="color:red">*</span></td><td><input type="password" name="rpass" id="confirmpassword" onblur="confirmpasswordVal()"/></td></tr><span id="message" style="color: red"></span>

<tr><td>Guardian Type<span style="color:red">*</span></td><td><input type="text" name="gtype" > </td></tr>
<tr><td>Guardian Name<span style="color:red">*</span></td><td><input type="text" name="gname" id="name" onblur="validateguardianname()" ></td></tr><span id="message" style="color: red"></span>
<tr><td>Address<span style="color:red">*</span></td><td><textarea rows="2" cols="16" name="address"></textarea></td></tr>
<tr><td>Citizenship<span style="color:red">*</span></td><td><input type="radio"  name="citizenship" value="Indian"/>Indian<input type="radio" name="citizenship" value="NRI"/>NRI </td></tr>
<tr><td>Citizen Status<span style="color:red">*</span></td><td><input type="text"  name="citizenstatus"></td></tr>

<tr><td>Country<span style="color:red">*</span></td><td>
<select	name="countryid" id="countryid" class="textbox" required/>
 </td></tr>
 
 <tr><td>State<span style="color:red">*</span></td><td>
<select id="stateid" name="stateid" class="textbox"></select>
<script language="javascript">
			populateCountries("countryid", "stateid");
		</script>
</td></tr>



<tr><td>Email Address<span style="color:red">*</span></td><td><input type="text" name="email" id="email" onblur="validateemail()"/><span id="message" style="color: red"></span></td></tr>
 

 
<tr><td>Contact Number<span style="color:red">*</span></td><td><input type="text" name="contact" id="custcontact" onblur="validatephone()" /></td></tr> <span id="message" style="color: red"></span> 
    
<tr><td>Date Of Birth<span style="color:red">*</span></td><td><input  type="text" class="datepicker" name="dob"></td></tr>
<tr><td>Gender<span style="color:red">*</span></td><td><input type="radio" name="gender" value="Male"/>Male<input type="radio" name="gender" value="Female"/>Female</td></tr>
<tr><td>Marital Status<span style="color:red">*</span></td><td>
<select name="maritalStatus"><option selected="selected">Select</option>
<option value="single">Single</option>
<option value="married">Married</option>
</select> </td></tr>

<tr><td>Registration date<span style="color:red">*</span></td><td><input type="text" class="datepicker" name="date"></td></tr>
<tr><td>Account type<span style="color:red">*</span></td><td>
<select name="Acctype"><option selected="selected">Select</option>
<option>Saving</option>
<option>Salary</option>
</select> </td></tr>
<tr><td>Initial Deposit Amount<span style="color:red">*</span></td><td><input type="text" name="inidepamo"></td></tr>
<tr><td>Branch Name<span style="color:red">*</span></td><td>
<select name="branchName"><option selected="selected">Select</option>
<option>TNAGAR</option>
<option>SAIDAPET</option>
<option>PERUNGUDI</option>
 </select> </td></tr>
<tr><td>Identification Proof Type<span style="color:red">*</span></td><td>
<select name="idproof"><option selected="selected">Select</option>
<option>Vote card</option>
<option>Pan card</option>
</select> </td></tr>
<tr><td>Identification Document Number<span style="color:red">*</span></td><td><input type="text" name="idnum"></td></tr>
<tr><td>Reference Account Holder Name<span style="color:red">*</span></td><td><input type="text" name="refname" id="accholdername" onblur="validateaccholdername()"></td></tr><span id="message" style="color: red"></span> 
    
<tr><td>Reference Account Holder Account Number<span style="color:red">*</span></td><td><input type="text" name="refaccnum" id="accholdernum" onblur="validateaccholdernum()"/></td></tr>
<tr><td>Reference Account Holder Address<span style="color:red">*</span></td><td><textarea rows="2" cols="16" name="refaddress"></textarea></td></tr>

<tr><td><input type="submit" name="Reset" value="Reset"/></td>

<td><input type="submit" name="button" value="Register"/><a href="successPage.jsp"></a></td></tr></table>
 
</center>


</form>
<br>
<br><br>
<br>
</div>
<br>
<br>
<div align="center">
<a href="IndexPage.jsp" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Cognizant Bank @ All Rights Reserved </marquee>
   </div>
</body>
</html>
 