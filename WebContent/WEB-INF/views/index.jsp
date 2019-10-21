<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kidream.persistence.pojo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">欢迎界面</h3>
	<a href="/ssm-testLogin/user/cancellation">注销登录</a><br>
	当前登录用户：<span style="color: blue;"><%pageContext.getOut().print(((User)session.getAttribute("user_in_session")).getUsername());%></span><br>
</body>
</html>