<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	String username=request.getParameter("username");

String password=request.getParameter("password"); 
if((username.equals("abc") && password.equals("abc")))
{ 
	session.setAttribute("username",username); 
	response.sendRedirect("FixedAsset.html"); 
} 
else throw new RuntimeException("Invalid Credentials!!!");
%>

</body>
</html>
