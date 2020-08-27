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
	<div class="top">
		<img src="img/top.png">	
	</div>
	<div class="box">
		<form action="LoginServlet" method="post" onsubmit="return check()">
			<% 
				String msg = (String)request.getAttribute("msg");
			%>
			<h2>登录</h2>
			<h3>请告诉我你的昵称吧</h3>
			<p id="tip"><%=msg == null?"":msg%></p>
			<input type="text" name="name" id="name" class="name" tabindex="1" autocapitalize="off" autocorrect="off" autocomplete="username" autofocus="autofocus" placeholder="昵称">
			<h3>请偷偷写你的密码吧</h3>
			<input type="password" name="password" id="password" class="password" tabindex="2" autocomplete="current-password" placeholder="密码（6-16个字符组成，区分大小写）">
			<input type="submit" name="commit" value="登录" tabindex="3" class="button" onclick="check();">
		</form>
	</div>
</body>
</html>