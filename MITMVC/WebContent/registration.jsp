<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type ="text/css" href="css/cssLayout.css"/>
<link rel="stylesheet" type ="text/css" href="css/default.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="top">
	

	
</div>
<div>
	<div id="left">
		<h2><a href ="index.jsp">home</a></h2>
		<h2><a href ="login.jsp">login</a></h2>
		<h2><a href ="registration.jsp">Sign Up</a></h2>
		
</div>

<div id="content" class="left_content">

	<h1>Registration form</h1>
	<% 
	String msg=(String)request.getAttribute("msg");
	if(msg!=null){
		%>
		<%=msg %>
		<%
	}
	
	%>
	<form action="Registration" method=post>
	<table>
	<tr>
	<td>Name:</td><td><input type="text" name="name"></td>
	</tr>
	<tr>
	<td>user id:</td><td><input type="text" name="uid"></td>
	</tr>
	<tr>
	<td>password:</td><td><input type="password" name="pass"></td>
	</tr>
	<tr>
	<td>email_id:</td><td><input type="text" name="emailid"></td>
	</tr>
	<tr>
	<td>mobile number:</td><td><input type="text" name="mobno"></td>
	</tr>
	<tr>
	<td><input type="submit" value="SignUp"></td>
	</tr>
	</table>
	
	</form>
	
</div>
</div>
<div id="bottom" align="center">
Copyright &copy;Mithi 2014

</div>

</body>
</html>