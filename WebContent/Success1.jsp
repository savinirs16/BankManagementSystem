<%@page import="com.bms.dao.TransactionDAO"%>
<%@page import="com.bms.vo.TransactionVO1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.bms.vo.AccountDetailsVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header3.html" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Transaction Page</title>

	
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no">

   <link rel="stylesheet" type="text/css" href="style1trans.css" media="all">
   
 <link rel="stylesheet" type="text/css" href="demotrans.css" media="all">
<title>Transaction Page</title>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<script>
function validateamount()
{
      var x=document.getElementById("amount").value;
      if(x==null||x=="")
            document.getElementById("message").innerHTML="Amount field should not be empty";
      else if(x<=0)
            document.getElementById("message").innerHTML="Enter a valid Amount";
      else if(x>0)
          document.getElementById("message").innerHTML="";
           }
           
           
           function validatedeposit()
           {
        	   
        	   if(document.getElementById("transactionType").value.equals("selected"))
{
        		   document.getElementById("msg").innerHTML="select a transaction type";
           }
           }    
</script>
</head>
<body background="cp.jpg">
<form action="TransactionController" method="post" >
<div class="container">
<%
AccountDetailsVO accountVO=(AccountDetailsVO)session.getAttribute("accountVO");

%>   
     <div class="freshdesignweb-top">                
      <div class="clr"></div>
 </div>
<header>
<h1><span></span>Transaction Page</h1>
</header>       
 <div class="form">
    
		<form id="contactform"> 
		 
		<p class="contact"><label for="customerID" >Customer ID</label></p> 
  			<%=accountVO.getCusID() %>
			<br><br>
			
			<p class="contact"><label for="accnum">Account Number</label></p> 
             <%=accountVO.getAccountNum()%> 
             <br><br>
             
    			<p class="contact"><label for="accname">Account Holders Name</label></p> 
		        <%=accountVO.getCname()%>
               <br><br>
 
                <p class="contact"><label for="acctype">Account Type</label></p> 
		        <%=accountVO.getAccountType()%>
    			<br><br>
              
                <p class="contact"><label for="transactionID">Transaction ID</label></p> 
		        <%=accountVO.getTransactionID()%>
                <br><br>
                
             <p class="contact"><label for="balanceamount">Balance</label></p>  
              <%=accountVO.getBalance()%>
              <br><br>
              
         <fieldset>
                <label>Transaction Type  </label> &nbsp;&nbsp;
          <select class="select-style" name="transactionType" id="transactionType" onblur="validatedeposit()" required="">
                   <option value="selected">-----select the type of transaction------</option>
                   <option value="deposit">Deposit</option>
                   <option value="withdrawal">WithDrawal</option>
                   <option value="loanEMIDebit">Loan EMI Debit</option>                  
           </select>    
        </fieldset>
            <br><br>
       
       <p class="contact"><label for="transactionDate">Transaction Date</label></p> 
         <%        
         Date dt=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String newDate=sdf.format(dt);
       out.print(newDate);
         session.setAttribute("date",newDate);
          %>
     <br><br>
         
       <p class="contact"><label for="amount" required>Amount</label></p> 
      <span id="message" style="color: red"></span>
      <input id="amount" name="amount" placeholder="Enter the amount " type="text" onblur="validateamount()"/> 
      <br><br> 
      <center>
      <input class="buttom" name="submit" id="submit" tabindex="5" value="proceed Transaction" type="submit">
      </center> 
	 
   </form> 
</div>      
</div>

</form>
</body>
</html>

