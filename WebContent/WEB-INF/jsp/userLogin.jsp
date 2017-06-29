<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/hover.css" rel="stylesheet" media="all">
<link href="css/style.css" rel="stylesheet" media="all">
<link href="css/tekkadan.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/zemihide/js/javascript.js"></script>
<title>ユーザー用ログイン</title>
</head>
<body>
	<div id = "main">
	<form action="<%=request.getContextPath()%>/userlogin" method="POST"
		onsubmit="return check(this)">
		<h2>ログイン（ユーザー）</h2>

		<c:if test="${errorMassage != null }">
			<c:out value="${errorMassage}"></c:out>
		</c:if>
		<table class="formstyle">
			<tr>
				<td>学生ID:</td>
				<td><input type="text" name="s_id" style="ime-mode: disabled"></td>
			</tr>
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="pass"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン" onclick="check()" class="hvr-float">
	</form>
	</div>
</body>
</html>