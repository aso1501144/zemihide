<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認画面</title>
</head>
<body>
<h2>削除確認</h2>
<form action="SubjectDelete" method="post">
<p style="padding-left:2em">
	<c:out value="${sub}" />の申し込みを削除します。
</p>
<input type="button" onClick='history.back();' value="戻る" style="padding: 10px; margin-bottom: 10px; border: 1px solid #333333;">

<input type="submit" value=削除（科目申込一覧に戻る）/>
</form>
</body>
</html>