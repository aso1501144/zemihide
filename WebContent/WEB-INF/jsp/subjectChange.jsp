<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目変更画面</title>
</head>
<body>

	<h2>科目変更</h2>
	選択中の科目：
	<c:out value="${sub}"></c:out>
	<br>
	<br>
	<a href="#"
		onclick="document.homhom.flg.value='1';document.homhom.sub_id.value='${sub_id}';document.homhom.submit();return false;">◯科目を変更する(科目登録画面へ)</a>
	<br>
	<br>
	<a href="MSubDelete">◯科目を削除する(科目削除画面へ)</a>

	<br><br>
	<input type="button" onClick='history.back();' value="戻る">

	<form action="SubEntry" method="get" name="homhom">
		<input type="hidden" name="sub_id" value="">
		<input type="hidden" name="flg" value="">
	</form>

</body>
</html>