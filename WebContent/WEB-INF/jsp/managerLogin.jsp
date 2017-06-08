<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file ="/WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者用ログイン</title>
</head>
<body>
かんりしゃ
	<form action="<%= request.getContextPath() %>/managerEntry" method="POST">
		<table>
			<tr>
				<td>教師ID:</td>
				<td><input type="text" name="mangerid"></td>
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