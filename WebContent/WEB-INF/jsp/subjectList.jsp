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

<form name = "form_serchList" method ="post" action ="servlet" > 
科目検索 
<br> 
<input type = "text" name = "serchWord"> 
<input type = "hidden" name = "serch" value = "serch"> 
<input type="submit" value="検索"> 
</form> 

<form method="GET" action="サーブレット名">
  <select name="grade">
    <option value="1">1</option>
  </select>
  <br>
  <select name="openDuring">
    <option value="1">1</option>
    <option value="2">2</option>
  </select>
  <br>
  <input type="submit' value="送信">
</form>

		<table border="1">
			<tr>
				<th>科目名</th>
				<th>科目分類名</th>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>

			</tr>
		</table>

</body>
</html>