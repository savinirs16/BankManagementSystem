<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="header.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home Page</title>
<script type="text/javascript" language="javascript">

function DisableBackButton() {

window.history.forward()


}

DisableBackButton();

window.onload = DisableBackButton;

window.onpageshow = function(evt) { if (evt.persisted) DisableBackButton() }

window.onunload = function() { void (0) }

</script>
<%@include file="Imagesslide.html" %>
</head>
<body>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}

.data{

top: 7cm;
      left: 15cm;
      position: absolute;
      z-index: 1;
      visibility: show;
}

.center_footer{

color: #1a000d;
font-size:12px;
font-weight:bold;
width:550px;
padding:27px;
text-align:center;
margin-left:250px;
float:left;
}
</style>
<div class="data">
   

<h3 style="color: #4db8ff;">Name:</h3><%=session.getAttribute("cname") %>
<p>-------------------------------------------------------------------------------</p>
<br>
<h3 style="color: #4db8ff;">Account No. :</h3><%=session.getAttribute("acctnum") %>
<p>-------------------------------------------------------------------------------</p>
<br>
<h3 style="color: #4db8ff;">Balance:</h3><%=session.getAttribute("balance") %>
<p>-------------------------------------------------------------------------------</p>
</div> 
   
</body>

</html>


<% 
response.setHeader("Pragma","no-cache"); 
response.setHeader("Cache-Control","no-store"); 
response.setHeader("Expires","0"); 
response.setDateHeader("Expires",-1); 
%> 
