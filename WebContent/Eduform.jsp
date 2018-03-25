<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header2.html"%>
<br>
 <link rel="stylesheet" type="text/css" href="styleedu.css" media="all">
   
 <link rel="stylesheet" type="text/css" href="demoedu.css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" type="text/javascript" src="datetimepicker.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function validateloanamt(){
	var num=document.getElementById("loanamount").value;
	if(num=="")
		document.getElementById("message").innerHTML="Please enter the Loan amount field";
	else    if(isNaN(num))
  	  document.getElementById("message").innerHTML="Enter only  numbers into the Loan Amount field."; 
	
	
}

</script>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
</head>
<body>

<form action="LoanTypeController"  method="get" >
<div class="container">

<!-- freshdesignweb top bar -->
      
      <div class="freshdesignweb-top">
                  
   </span>
          
      <div class="clr"></div>
   
         </div><!--/ freshdesignweb top bar -->

			<header>
	
			<h1 style="color: #4db8ff;"><span></span>Educational Loan Form</h1>
     
       </header>       
 
     <div class="form">
        
		<form id="contactform"> 
            <%--<span id="message" style="color:red"></span> --%>
			<p class="contact"><label for="loanAmount"></label></p> <br>
			 <span id="message" style="color:red"></span><br><br>
            <input id="loanamount" name="loanAmount" placeholder="Loan Amount"  tabindex="1" type="text" onblur="validateloanamt()"> 
 

			<p class="contact"><label for="loanApplyDate"></label></p> 
	
			
    	<input type="Text" id="demo1" maxlength="25" size="25" name="loanApplyDate" placeholder="Loan Apply Date" >
			<a href="javascript:NewCal('demo1','ddMMyyyy',true,24)">
			<img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a>
    		
			
			
   			
 
    			<p class="contact"><label for="rateOfInterest"></label></p> 
    
			<input id="email" name="rateOfInterest" placeholder="Rate of Interest - 9%" > 

			
			           <select class="select-style gender" name="duration">
       
    				 <option value="select">Duration Of Loan in Years</option>
       
     				<option value="5">5</option>
        
    				<option value="10">10</option>
         
   				<option value="15">15</option>
					
				<option value="20">20</option>
        
    				</select><br><br>
               
 
              			
    			
 
                		<p class="contact"><label for="course"></label></p> 
    	
			<input type="text" id="password" name="course" placeholder="Course" required=""> 
    
            			<p class="contact"><label for="courseFee"></label></p> 
    		
			<input type="text" id="courseFee" name="courseFee" placeholder="Course Fee" onblur="validatecoursefee()"> 
      
  
               			<p class="contact"><label for="fathersName"></label></p> 
    		
			<input type="text" id="repassword" name="fathersName" placeholder="Fathers Name" required=""> 


			<p class="contact"><label for="fathersOccupation"></label></p> 
    		
			<input type="text" id="repassword" name="fathersOccupation" placeholder="Fathers Occupation" required=""> 


			
      			<p class="contact"><label for="fathersTotalExperience"></label></p> 
    		
			<input type="text" id="repassword" name="fathersTotalExperience" placeholder="Fathers Total Experience" required=""> 


			<p class="contact"><label for="fathersTotalExpWithCurrentCompany"></label></p> 
    		
			<input type="text" id="repassword" name="fathersTotalExpWithCurrentCompany" placeholder="Fathers Total Experience with Current Company" required="">


			<p class="contact"><label for="rationCardNumber"></label></p> 
    		
			<input type="text" id="repassword" name="rationCardNumber" placeholder="Ration Card Number" required=""> 


			<p class="contact"><label for="annualIncome"></label></p> 
    		
			<input type="text" id="repassword" name="annualIncome" placeholder="Annual Income" required="">
		
		
			<p style="text-align:right;"><a href="EMI edu.xlsx"  target="_blank" title="Loan EMI Calculator">Loan EMI Calculator&nbsp;<img alt="Image of the Emi Calculator " src='xls.gif' width='16' height='16' border=0 align='absmiddle'></a></p>
			


      <input class="buttom" name="submit" id="submit" tabindex="5" value="Apply..." type="submit"> 

   </form> 
 </div> 
   
</div>
<br>
<br>
<div align="center">
<a href="" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Cognizant Bank @ All Rights Reserved </marquee>
   </div>
   </form>
</body>
</html>