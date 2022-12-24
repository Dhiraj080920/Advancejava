<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.html" %>
<form action="validate.jsp">
   user name : <input type="text" name='uname' id='nm'>
   passsword : <input type="password" name="pass" id="pass">
   <button type="submit" name="btn" id="btn">Login</button>
</form>
<%@include file="footer.html" %>
</body>
</html>