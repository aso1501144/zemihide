<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/hover.css" rel="stylesheet">
<script type="text/javascript" src="/zemihide/js/javascript.js"></script>
<title>科目申込み</title>
</head>
<body>

	<h2>科目申し込み</h2>
	申し込む科目を選択してください
	<div style="text-align: center">
		<a href="userlogin">ログアウト</a>
	</div>
	<form action="genresearch" name="kamoku">
		<select name="genre">
			<option value="">ジャンル選択</option>
			<option value="eng">英語</option>
			<option value="it">IT</option>
			<option value="com">コミュニケーション</option>
		</select> <input type="submit" value="検索"> <input type="submit"
			value="クリア" name="genre">
	</form>

	<table class="sub">
		<tbody>
			<tr>
				<th>科目名</th>
				<th></th>
			</tr>

			<c:forEach var="data" items="${sessionScope.subject}"
				varStatus="status">

				<tr>
					<td><c:out value="${data.sub_name}" /></td>

					<td><a href="#"
						onclick="document.homhom.sub_ident.value= '${data.sub_id}';document.homhom.submit();return false;">申し込む</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<form action="Entry" method="post" name="homhom">
		<input type="hidden" name="sub_ident" value="">
	</form>

	<input type="button" onClick='history.back();' value="戻る">
</body>
</html>