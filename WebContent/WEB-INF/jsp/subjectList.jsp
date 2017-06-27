<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目一覧</title>
</head>
<body>
	<h2>科目一覧</h2>
	ようこそ<c:out value="${m_name}"></c:out>さん
	<br><br>
	<a href="M102conf">ログアウト</a>

	<form action="genresearch" name="kamoku" method="post">
		<select name="genre">
			<option value="">ジャンル選択</option>
			<option value="eng">英語</option>
			<option value="it">IT</option>
			<option value="com">コミュニケーション</option>
		</select> <input type="submit" value="検索"> <input type="submit"
			value="クリア" name="genre">
	</form>

	<table border="1">
		<tr>
			<th>科目ID</th>
			<th>科目名</th>
			<th></th>
		</tr>
		<c:forEach var="data" items="${sessionScope.subject}"
			varStatus="status">
			<tr>
				<td><c:out value="${data.sub_id}" /></td>
				<td><c:out value="${data.sub_name}" /></td>
				<td><a href="#"
					onclick="document.homhom.sub_id.value='${data.sub_id}';document.homhom.num.value='1';document.homhom.submit();return false;">変更</a>
					<a href="#"
					onclick="document.homhom.sub_id.value='${data.sub_id}';document.homhom.num.value='2';document.homhom.submit();return false;">学生一覧</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<form action="MsubChange" method="get" name="homhom">
		<input type="hidden" name="sub_id" value=""> <input
			type="hidden" name="num" value="">
	</form>
</body>
</html>