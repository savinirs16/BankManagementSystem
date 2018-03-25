<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
<%@ include file="header.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%long final_amount = (Long)session.getAttribute("final_amount"); %>
<%String transactiontype=(String) session.getAttribute("transType"); %>
<body>
<br>
<br>
<br>
<h1><center style="color: #4db8ff">
<% if(transactiontype.equalsIgnoreCase("deposit")) {%>
Transaction Deposit successful final amount in the account is : <%=final_amount %>
<%}else if (transactiontype.equalsIgnoreCase("withdrawal")){ %>
Transaction Withdrawal successful final amount in the account is : <%=final_amount %>
<%}else if(transactiontype.equalsIgnoreCase("loanEMIDebit")){ %>
Transaction Loan EMI Debit successful final amount in the account is : <%=final_amount %>
<%} %><br>
File the Transaction ID <%=session.getAttribute("transactionid") %> for future reference.
</center></h1>
</body>
</html>