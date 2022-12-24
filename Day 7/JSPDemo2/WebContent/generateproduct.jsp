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
 <%--  default constructor will be called --%>
   <jsp:useBean id="p" class="com.demo.beans.Product" scope="request"></jsp:useBean>
   <%-- <jsp:setProperty property="pid" name="p" value='<%=request.getParameter("pid") %>'/> --%>
   <%-- call all setter methods 
   all text box names and product class member names should be same--%>
   <jsp:setProperty property="*" name="p"></jsp:setProperty>
   
    <%-- call all getter methods --%>
   <h1>Display data for product object</h1>
   Product id : <jsp:getProperty property="pid" name="p"></jsp:getProperty>
   Product name: <jsp:getProperty property="pname" name="p"></jsp:getProperty>
   Quantity : <jsp:getProperty property="qty" name="p"></jsp:getProperty>
   Price : <jsp:getProperty property="price" name="p"></jsp:getProperty>
   
   <%@include file="footer.html" %>
   
   
</body>
</html>