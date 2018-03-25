<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="header2.html"%>
 <link rel="stylesheet" type="text/css" href="styleper.css" media="all">
   
 <link rel="stylesheet" type="text/css" href="demoper.css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="datetimepicker.js"></script>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
 
</head>
<body>

<form action="LoanTypeController"  method="get" >
<div class="container">


      
      <div class="freshdesignweb-top">
                  
   </span>
          
      <div class="clr"></div>
   
         </div>

			<header>
	
			<h1 style="color: #4db8ff;"><span></span>Personal Loan Form</h1>
     
       </header>       
 
     <div class="form">
    
		<form id="contactform"> 
    
			<p class="contact"><label for="loanAmount"></label></p> 
  
  			<input id="name" name="loanAmount" placeholder="Loan Amount" required="" tabindex="1" type="text"> 
 

			<input type="Text" id="demo1" maxlength="25" size="25" name="loanApplyDate" placeholder="Loan Apply Date" >
			<a href="javascript:NewCal('demo1','ddMMyyyy',true,24)">
			<img src="cal.gif" width="16" height="16" border="0" alt="Pick a date"></a> 
   			
 
    			<p class="contact"><label for="rateOfInterest"></label></p> 
    
			<input id="email" name="rateOfInterest" placeholder="Rate of Interest - 11%"  > 

			
			           <select class="select-style gender" name="duration">
       
    				 <option value="select">Duration Of Loan in Years</option>
       
     				<option value="5">5</option>
        
    				<option value="10">10</option>
         
   				<option value="15">15</option>
					
				<option value="20">20</option>
        
    				</select><br><br>
               
 
              			  <p class="contact"><label for="annualIncome"></label></p> 
    	
			<input id="username" name="annualIncome" placeholder="Annual Income" required="" tabindex="2" type="text"> 
    			
 
              			  <p class="contact"><label for="company"></label></p> 
    	
			<input type="text" id="password" name="company" placeholder="Company Name" required=""> 
    

           			 <p class="contact"><label for="designation"></label></p> 
    		
			<input type="text" id="repassword" name="designation" placeholder="Designation" required=""> 
      
  
              			<p class="contact"><label for="totalExperience"></label></p> 
    		
			<input type="text" id="repassword" name="totalExperience" placeholder="Total Experience" required="">

			
			<p class="contact"><label for="myExperienceWithCurrentCompany"></label></p> 
    		
			<input type="text" id="repassword" name="myExperienceWithCurrentCompany" placeholder="Experience with current Company" required="">


			<p class="contact"><label for="guaranteerName"></label></p> 
    		
			<input type="text" id="repassword" name="guaranteerName" placeholder="Guaranteer Name" required="">
      


			<p class="contact"><label for="guaranteerAddress"></label></p> 
    		
			<input type="text" id="repassword" name="guaranteerAddress" placeholder="Guarenteer Address" required="">


			<p class="contact"><label for="guaranteerIncome"></label></p> 
    		
			<input type="text" id="repassword" name="guaranteerIncome" placeholder="Guarenteer Income" required="">
			
			<p style="text-align:right;"><a href="EMI per.xlsx"  target="_blank" title="Loan EMI Calculator">Loan EMI Calculator&nbsp;<img alt="Image of the Emi Calculator " src='xls.gif' width='16' height='16' border=0 align='absmiddle'></a></p>

<input class="buttom" name="submit" id="submit" tabindex="5" value="Apply..." type="submit"> 	 
              
                </form> 
                
	</div>      
	</div>
	<br><br>
	<div align="center">
<a href="" style="color: black; font-size: medium;" >Home|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Aboutus.jsp" target="_blank" style="color: black;font-size: medium;">About|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Contactus.jsp" target="_blank" style="color: black;font-size: medium;">Contact|&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><a href="Disclaimer.jsp" target="_blank" style="color: black; font-size: medium;" >Disclaimer</a>

   <marquee>   &copy; Bms @ All Rights Reserved </marquee>
   </div>
</body>

</html>