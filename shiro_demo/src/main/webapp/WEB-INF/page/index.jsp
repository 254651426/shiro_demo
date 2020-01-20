<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<html>
<body>
	<shiro:hasPermission name="admin:goods:save">
		<label>这是拥有admin角色用户 才能使用的保存</label>
	</shiro:hasPermission>

	<shiro:hasPermission name="admin:goods:update">
		<label>这是拥有admin角色的用户 才能使用的修改</label>
	</shiro:hasPermission>
</body>
</html>
