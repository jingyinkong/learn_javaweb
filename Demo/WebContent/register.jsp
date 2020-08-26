<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>请注册</title>
<link rel="stylesheet" href="css/register.css" type="text/css">
</head>
<body>
	<% 
		String msg = (String)request.getAttribute("msg");
	%>
	<p><%=msg == null?"":msg%></p>
	<div class="box">
		<form action="RegisterServlet" method="post">
			<h2>Create your account</h2>
			<h3>Username</h3>
			<input type="text" name="name" id="login_field" class="" tabindex="1" autocapitalize="off" autocorrect="off" autocomplete="username" autofocus="autofocus">
			<h3>Password</h3>
			<input type="password" name="password" id="password" class="" tabindex="2" autocomplete="current-password">
			<input type="submit" name="commit" value="Sign in" tabindex="3" class="" data-disable-with="Signing inâ¦">
			<!--<label for="check"><input type="checkbox" value="" id="check">Agree to the agreement</label>-->
		</form>
	</div>
</body>
</html>