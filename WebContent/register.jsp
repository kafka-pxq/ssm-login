<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="user" class="com.kidream.persistence.pojo.User"
	scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>注册页面</h3>
	<form:form action="/ssm-testLogin/user/regist" modelAttribute="user"
		method="POST" enctype="multipart-form-data">
		用户名：<form:input path="username" placeholder="请输入用户名" />
		<form:errors path="username" style="color:red" />
		<br>
		密码：<form:password path="password" placeholder="请输入密码" />
		<form:errors path="password" style="color:red" />
		<br>
		<input type="submit" value="注册">
	</form:form>
	<br>
	<span style="color:red">${error}</span>
</body>
</html>