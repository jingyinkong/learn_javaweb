<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>请登录</title>
<link rel="stylesheet" href="css/login.css" type="text/css">
</head>
<body>
	<div class="box">
		<form action="LoginServlet" method="post">
			<input type="text" name="name" id="login_field" class="" tabindex="1" autocapitalize="off" autocorrect="off" autocomplete="username" autofocus="autofocus">
			<input type="password" name="password" id="password" class="" tabindex="2" autocomplete="current-password">
			<input type="submit" name="commit" value="Sign in" tabindex="3" class="" data-disable-with="Signing inâ¦">
		</form>
	</div>
</body>
</html>