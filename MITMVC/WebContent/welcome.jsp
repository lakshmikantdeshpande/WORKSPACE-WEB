<%@page import="com.model.User"%>
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
<%
User user=(User)request.getSession().getAttribute("user");

%>
<div id="top">
	<h1><b>Welcome to Mithi</b> </h1>

	
</div>
<div>
	<div id="left">
	<h2>hello <%=user.getName()%></h2>
	
		
		<h2><a href ="SignOut">Logout</a></h2>
				
		
</div>

<div id="content" class="left_content">
		<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null){
			%>
			<font color="red"><%=msg %></font>
			<%
		}
		
		%>
</div>
</div>
<div id="bottom" align="center">
Copyright &copy;Mithi 2014

</div>

</body>
</html>