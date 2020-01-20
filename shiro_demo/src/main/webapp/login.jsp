<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<body>
	<form action="subLogin" method="post">
		username<input type="text" id="username" name="username" value="${User.Username}"></input>
		password<input id="password" type="password" name="password" value="${User.Password}"></input>
		<button type="submit" value="提交">提交</button>
	</form>
</body>
</html>
