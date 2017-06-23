<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目別学生一覧画面</title>
</head>
<body>
	<h2>科目学生一覧</h2>
	選択中の科目：<c:out value="${sub_name}" /> 登録学生一覧

	<table>
		<tr>
			<th>学生ID</th>
			<th>学生名</th>
		</tr>
		<tr>
		</tr>
	</table>

	<c:forEach var="data" items="${sessionScope.sslist}" varStatus="status">
		<p>
				<c:out value="${data.s_id}" />
		</p>
		<p>
				<c:out value="${data.s_name}" />
		</p>

	</c:forEach>

	<a href="#" onclick="windows.print()">印刷(印刷画面へ)</a>
	<a href="M102conf">戻る(科目一覧画面へ)</a>

</body>
</html>