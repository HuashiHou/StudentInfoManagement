<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改学生信息</title>
</head>
<body>
<form method="post" action="update" >
<input name="id" type="text" value="${stu.id}" readonly/><br/>
<input name="name" type="text" value="${stu.name}"/><br/>
<input name="sex" type="text" value="${stu.sex}"/><br/>
<input type="submit" value="submit"/>
</form>
</body>
</html>