<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目削除画面</title>
</head>
<body>
	<h2>科目削除</h2>
	<form action="" method="get">
		<p style="padding-left: 2em">
			<c:out value="${data.sub_name}" />
			を削除します。
		</p>
		<input type="button" onClick='history.back();' value="戻る"
			style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333;">

		<input type="submit" value=削除（科目申込一覧に戻る） />
	</form>
</body>
</html>