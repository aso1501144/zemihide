<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/zemihide/js/javascript.js"></script>
<title>ユーザー用ログイン</title>
</head>
<body>
ゆーざー
	<form action="<%= request.getContextPath() %>/userlogin" method="POST" onsubmit="return check(this)">
<h2>ログイン（ユーザー）</h2>

		<table>
			<tr>
				<td>学生ID:</td>
				<td><input type="text" name="s_id" style="ime-mode:disabled"></td>
			</tr>
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン" onclick="check()">
	</form>
</body>
</html>