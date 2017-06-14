<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/hover.css" rel="stylesheet">
<title>申込み一覧</title>
</head>
<body>

<h2>科目申し込み</h2>
<a href="logout" class="logout">ログアウト</a>

<c:forEach var="data" items="${sessionScope.subject}"
						varStatus="status">
						<tr>
							<td><c:out value="${data.sub_id}" /></td>
							<td><c:out value="${data.sub_name}" /></td>
							<td><c:out value="${data.sc_id}" /></td>
						</tr>
					</c:forEach>

</body>
</html>