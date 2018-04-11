<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>学生信息管理系统</title>
</head>
<body>
	<table border="1" align="center" width="800px">
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>SEX</td>
			<td colspan="4">OPERATION</td>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.sex}</td>
				<td><a href="detail?id=${item.id}">Detail</a></td>
				<td><a href="update?id=${item.id}">Update</a></td>
				<td><a href="delete?id=${item.id}">Delete</a></td>
				<td><a href="cart?id=${item.id}">AddCart</a></td>
			</tr>
		</c:forEach>
		<tr><td colspan="7"><a href="add.jsp">ADD STUDENT</a></td></tr>
	</table><br>
	
	<table border="1" align="center" width="800px">
		<tr>
			<td colspan="3" align="center">HISTORIES</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>SEX</td>
		</tr>
		<c:forEach items="${hist}" var="hisItem">
			<tr>
				<td><a href="detail?id=${hisItem.id}">${hisItem.id}</a></td>
				<td>${hisItem.name}</td>
				<td>${hisItem.sex}</td>
			</tr>
		</c:forEach>
	</table><br>

	<table border="1" align="center" width="800px">
		<tr>
			<td colspan="4" align="center">SHOPPING CART</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>SEX</td>
			<td>OPERATION</td>
		</tr>
		<c:forEach items="${clist}" var="cartItem">
			<tr>
				<td><a href="detail?id=${cartItem.id}">${cartItem.id}</a></td>
				<td>${cartItem.name}</td>
				<td>${cartItem.sex}</td>
				<td><a href="cart?id=${cartItem.id}&op=del">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>