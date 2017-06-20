<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目一覧</title>
</head>
<body>

<h2>科目一覧</h2>
<a href="logout" >ログアウト</a>


<form method="GET" action="M102conf">
  <select name="grade">
    <option value="1">IT</option>
  	<option value="2">英語</option>
  	<option value="3">コミュニケーション</option>
    </select>
</form>

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