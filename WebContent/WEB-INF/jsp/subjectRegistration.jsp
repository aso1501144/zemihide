<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>科目登録画面</title>
</head>
<body>
<h2>科目登録</h2>

	<form action="SubEntry" method="POST">
		<table>
			<tr>
				<td>科目名：</td>
				<td><input type="text" name="subjectName"></td>
			</tr>
			<tr>
				<td>科目分類名：</td>
				<td>
				<select name="genre">
 				<option value="1">IT</option>
  				<option value="2">英語</option>
  				<option value="3">コミュニケーション</option>
				</select>
				</td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="sub_id" value="${sub_id}">
		<input type="hidden" name="flg" value="${flg}">
		<input type="submit" value="登録">
		<input type="button" onClick='history.back();' value="戻る">
	</form>


</body>
</html>