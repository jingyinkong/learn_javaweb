<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fail</title>
</head>
<body>
	<% response.setHeader("Refresh","3;url=login.jsp");%>
	<h1>登录失败！三秒后将跳转到首页</h1>
	<a href="login.jsp">返回登录页面</a>
</body>
</html>