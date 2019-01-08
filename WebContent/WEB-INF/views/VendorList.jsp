<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<td>
	<a href="get-excel">Vendor Excel</a>
</td>
<table border="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Address</th>
		<th colspan="2">Operations</th>
	</tr>
	<c:forEach items="${list}" var="l">
	<tr>
		<td><c:out value="${l.vId}"/></td>
		<td><c:out value="${l.vName}"/></td>
		<td><c:out value="${l.vAddr}"/></td>
		<td>
			<a href="deleteVendor?vId=${l.vId}">
			<img  src="images/delete.png" width="30" height="30">
			</a>
		</td>
		<td>
			<a href="updateVendor?vId=${l.vId}">
			<img  src="images/edit.png" width="30" height="30">
			</a>
		</td>
	</tr>
	</c:forEach>
</table>
${msg}
</body>
</html>