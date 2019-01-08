<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updatedVendor" method="post">
		<table>
	<tr>
		<td>Id:</td><td><input type="text" name="vId" value="${vendor.vId}" readonly="readonly"/></td>
	</tr>
	<tr>
		<td>Name:</td><td><input type="text" name="vName" value="${vendor.vName}"/></td>
	</tr>
	<tr>
		<td>Address:</td><td><input type="text" name="vAddr" value="${vendor.vAddr}"/></td>
	</tr>
	<tr>
		<td></td><td><input type="submit" value="update"/></td>
	</tr>
</table>
	</form>
</body>
</html>