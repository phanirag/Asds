<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertVendor" method="post">
	<table>
		<tr>
			<td>Name:</td><td><input type="text" name="vName"/></td>
		</tr>
		<tr>
			<td>Address:</td><td><input type="text" name="vAddr"/></td>
		</tr>
		<tr>
			<td></td><td><input type="submit" value="Go.."/></td>
		</tr>
	</table>
</form>
${msg}
<a href="viewAllVendor">Click here to view Records</a>
</body>
</html>