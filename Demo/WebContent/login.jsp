<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>阿巴阿巴 - ( ゜- ゜)つロ 乾杯~</title>
<link rel="stylesheet" href="css/login.css" type="text/css">
<script type="text/javascript">
	function check(){
	    var name = document.getElementById('name').value;
	    var password = document.getElementById('password').value;
	    if(name == ''){
	        document.getElementById('tip').innerHTML = "用户名不能为空";
	        console.log('name is null');
	        return false;
	    }
	    if(password == ''){
	    	console.log('password is null');
	        document.getElementById('tip').innerHTML = "密码不能为空";
	        return false;
	    }
	    return true;
	}
</script> 
</head>
<body>
	<div class="box">
		<form action="LoginServlet" method="post" onsubmit="return check()">
			<% 
				String msg = (String)request.getAttribute("msg");
			%>
			<p id="tip"><%=msg == null?"":msg%></p>
			<h3>Username</h3>
			<input type="text" name="name" id="name" class="" tabindex="1" autocapitalize="off" autocorrect="off" autocomplete="username" autofocus="autofocus">
			<h3>Password</h3>
			<input type="password" name="password" id="password" class="" tabindex="2" autocomplete="current-password">
			<input type="submit" name="commit" value="Sign in" tabindex="3" class="" data-disable-with="Signing inâ¦" onclick="check();">
		</form>
	</div>
</body>
</html>