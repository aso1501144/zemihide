<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目別学生一覧画面印刷画面</title>
</head>
<body>
<h2>ログイン（ユーザー）</h2>
	<form action="<%= request.getContextPath() %>/userEntry" method="POST">
		<table>
			<tr>
				<td>学生ID:</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>