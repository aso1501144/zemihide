<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/list.css" rel="stylesheet">
<link href="css/hover.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申し込み科目変更</title>
</head>
<body>
	<h2>申し込み科目変更</h2>
	<p style="padding-left: 2em">
		選択中の科目名：
		<c:out value="${sub}" />
		<br>
		<br> <a href="U103mousikomi">◯科目を変更する（科目申込画面へ）</a> <br>
		<br> <a href="tinanago">◯科目を削除する</a>
	</p>
	<input type="button" onClick='history.back();' value="戻る">

</body>
</html>