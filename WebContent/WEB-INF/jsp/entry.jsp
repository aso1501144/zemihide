<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>申込み一覧</title>
<title>ユーザー用ログイン</title>
</head>
<body>

<h2>申込み科目一覧</h2>
<a href="logout" >ログアウト</a>

		<table border="1">
			<tr>
				<th>科目名</th>
				<th>科目分類名</th>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>

			</tr>
		</table>
		<input type="submit" value="ログイン">
=======
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
>>>>>>> branch 'master' of https://github.com/aso1501144/zemihide
</body>
</html>