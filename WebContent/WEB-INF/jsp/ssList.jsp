<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/list.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/print.css" media="print">
<link rel="stylesheet" type="text/css" href="css/screen.css" media="screen">
<title>科目別学生一覧画面</title>
</head>
<body>
	<div1>教科名：<c:out value="${sub_name}" /></div1>
	<h2>科目学生一覧</h2>
	<p>選択中の科目：<c:out value="${sub_name}" /> </p>
	<p>登録学生一覧</p>

	<table class ="stu">
		<tr>
			<th>学生ID</th>
			<th>学生名</th>
		</tr>
		<c:forEach var="data" items="${sessionScope.sslist}" varStatus="status">
		<tr>
			<td><c:out value="${data.s_id}" /></td>
			<td><c:out value="${data.s_name}" /></td>
		</tr>
		</c:forEach>
	</table>
	<br>

	<input type="button" onclick="window.print()"  value="印刷(印刷画面へ)">
	<input type="button" onclick='history.back();' value="戻る(科目一覧画面へ)">

</body>
</html>
