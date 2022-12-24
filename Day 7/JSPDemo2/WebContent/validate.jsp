<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
    String uname=request.getParameter("uname");
    String pass=request.getParameter("pass");
    if((uname.equals("admin")) && (pass.equals("admin"))){
    	%>
    <jsp:forward page="getproduct.jsp">
      <jsp:param value="Welcome to add new product" name="message"/>
    
    </jsp:forward>
    	
   <% 	
    }
    else{%>
    <h3>Pls reneter credentials</h3>
    <jsp:include page="login.jsp"></jsp:include>
    	
   <% }
  %>
</body>
</html>