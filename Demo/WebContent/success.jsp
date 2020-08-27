<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<% response.setHeader("Refresh","3;url=index.jsp");%>
	<h1>成功，三秒后将跳转到首页</h1>
	<a href="index.jsp">返回首页</a>
</body>
</html>