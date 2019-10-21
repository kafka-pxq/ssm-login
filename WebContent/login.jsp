<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<span style="color:red">
			${errorMsg}
		</span>
	<form action="/ssm-testLogin/user/checkLogin" method="POST" enctype="multipart-form-data">
		账号：<input type="text" name="username" placeholder="请输入账号"/><br>
		密码：<input type="text" name="password" placeholder="请输入密码"/><br>
		<input type="submit" value="login">
	</form> 
	<div>没有账号，注册一个</div><a href="/ssm-testLogin/register.jsp" type="color:red">logon</a>
	${msg}
</body>
</html>