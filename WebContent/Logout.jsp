<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js">
        </script>
<%@include file="header_index.html" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>

<script type="text/javascript" language="javascript">

function DisableBackButton() {

window.history.forward()


}

DisableBackButton();

window.onload = DisableBackButton;

window.onpageshow = function(evt) { if (evt.persisted) DisableBackButton() }

window.onunload = function() { void (0) }

</script>
<style type="text/css">
body {
	background-image: url("cp.jpg");
}
</style>
</head>
<body>
<br>
<br>
<br>
<br>
 <center><h2 style="font-family: fantasy;color: #4db8ff;">Thank you for using Cognizant Banking Service</h2>
<br>
 <a href="Logout" style="color: red;">Click here</a> to go back to home page...</center>
</body>




</html>


