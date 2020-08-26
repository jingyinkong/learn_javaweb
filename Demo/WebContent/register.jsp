<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阿巴阿巴 - ( ゜- ゜)つロ 乾杯~</title>
<link rel="stylesheet" href="css/register.css" type="text/css">
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
	<% 
		String msg = (String)request.getAttribute("msg");
	%>
	<div class="top">
		<img src="img/top.png">	
	</div>
	<div class="box">
		<form action="RegisterServlet" method="post" onsubmit="return check()">
			<h2>注册</h2>
			<h3>请告诉我你的昵称吧</h3>
			<p id="tip"><%=msg == null?"":msg%></p>
			<input type="text" name="name" id="name" class="name" tabindex="1" autocapitalize="off" autocorrect="off" autocomplete="username" autofocus="autofocus" placeholder="昵称">
			<h3>请偷偷写你的密码吧</h3>
			<input type="password" name="password" id="password" class="password" tabindex="2" autocomplete="current-password" placeholder="密码（6-16个字符组成，区分大小写）">
			<div class="checkbox">
				<label>
					我已同意
					<label>
						<input name="agree" type="checkbox">
					</label>
					<a target="_blank" href="#">《阿巴阿巴网用户使用协议》</a>
					和
					<a target="_blank" href="#">《阿巴阿巴隐私政策》</a>
				</label>
			</div>
			<input type="submit" name="commit" value="注册" tabindex="3" class="button" onclick="check();">
			<!--<label for="check"><input type="checkbox" value="" id="check">Agree to the agreement</label>-->
			<div class="login">
				<a href="login.jsp">已有账号，直接登录></a>
			</div>
		</form>
	</div>
</body>
</html>