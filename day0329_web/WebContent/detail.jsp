<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生详情</title>
</head>
<body>
<table border="1" align="center" width="300px">
<tr><td>ID</td><td>NAME</td><td>SEX</td></tr>
<tr><td>${stu.id }</td><td>${stu.name }</td><td>${stu.sex }</td></tr>
<tr><td colspan="3"><a href="list.do">HOME</a></td></tr>
</table>
</body>
</html>