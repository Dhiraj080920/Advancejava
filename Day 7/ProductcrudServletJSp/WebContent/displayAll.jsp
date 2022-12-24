<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, com.demo.beans.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sdfsd</title>
</head>
<body>
	<%
		List<Product> plist = (List<Product>)request.getAttribute("plist");
		%>
		<table border="2">
		
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Actions</th>
			</tr>
			<%
				for(Product p: plist){
					%>
						<tr>
							<td><%=p.getPid() %></td>
							<td><%=p.getPname() %></td>
							<td><%=p.getQty() %></td>
							<td><%=p.getPrice() %></td>
							<td><a href="edit?id=<%=p.getPid() %>">Edit</a>/
								<a href="delete?id=<%=p.getPid() %>">Delete</a>
							</td>
						</tr>
				<%}%>
				<a href="addProduct.jsp">Add Product</a>
		</table>
</body>
</html>