<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/list.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申込み科目一覧</title>
</head>
<body>
	<h2>申込み科目一覧</h2>
	ようこそ
	<c:out value="${s_name}"></c:out>
	さん
	<div style="text-align: center">
		<a href="userlogin">ログアウト</a>
	</div>
	<br>


	<c:forEach var="data" items="${sessionScope.entry}" varStatus="status">


		<table class="sub">
			<tbody>
				<tr>
					<th>科目名</th>
					<th></th>
				</tr>
				<tr>
					<c:if test="${data.sub_name != null}">
						<td><c:out value="${data.sub_name}" /></td>
						<td><a href="#"
							onclick="document.homhom.sub_id.value='${data.sub_id}';document.homhom.num.value='1';document.homhom.submit();return false;">変更</a></td>
					</c:if>
				</tr>
				<tr>
					<c:if test="${data.sub_name2 != null}">
						<td><c:out value="${data.sub_name2}" /></td>
						<td><a href="#"
							onclick="document.homhom.sub_id.value='${data.sub_id2}';document.homhom.num.value='2';document.homhom.submit();return false;">変更</a></td>
					</c:if>
				</tr>
				<tr>
					<td></td>
					<c:if test="${data.sub_name2 == null or data.sub_name == null}">
						<td><a href="U103mousikomi">申し込み</a></td>
					</c:if>
			</tbody>
		</table>
	</c:forEach>



	<form action="SubjectChange" method="get" name="homhom">
		<input type="hidden" name="sub_id" value=""> <input
			type="hidden" name="num" value="">
	</form>


</body>
</html>