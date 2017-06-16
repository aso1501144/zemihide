<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/hover.css" rel="stylesheet">
<script type="text/javascript" src="/zemihide/js/javascript.js"></script>
<title>科目申込み</title>
</head>
<body>

	<h2>科目申し込み</h2>
	申し込む科目を選択してください
	<a href="logout" class="logout">ログアウト</a>
	<form name="test">
		<select name="genre" onChange="genreselect()">
			<option value="">ジャンル選択</option>
			<option value="english">英語</option>
			<option value="it">IT</option>
			<option value="com">コミュニケーション</option>
		</select>
	</form>

	<c:forEach var="data" items="${sessionScope.subject}"
		varStatus="status">

		<p>
			<c:out value="${data.sub_name}" />
			<a href="#"
				onclick="document.homhom.sub_ident.value= '${data.sub_id}';document.homhom.submit();return false;">申し込む</a>
	</c:forEach>

	<form action="Entry" method="post" name="homhom">
		<input type="hidden" name="sub_ident" value="">
	</form>

	<input type="button" onClick='history.back();' value="戻る">
</body>
</html>