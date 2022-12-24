<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='insertproduct' method="post">
		<table>
			<tr>
				<td>Product id :</td>
				<td><input type="text" name="pid" id="id"></td>
			</tr>
			<tr>
				<td>Product name :</td>
				<td><input type="text" name="pname" id="name"></td>
			</tr>
			<tr>
				<td>Product Quantity :</td>
				<td><input type="text" name="qty" id="qty"></td>
			</tr>
			<tr>
				<td>Product price :</td>
				<td><input type="text" name="price" id="price"></td>
			</tr>
			<tr>
				<td>Product cid :</td>
				<td><input type="text" name="cid" id="cid"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" name="btn" id="btn">Add
						product</button></td>
			</tr>
		</table>
	</form>
</body>
</html>