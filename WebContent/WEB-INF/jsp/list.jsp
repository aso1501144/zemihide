<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申込み科目一覧</title>
</head>
<body>
	<h2>申込み科目一覧</h2>
	<a href="userlogin">ログアウト</a>

	<a href="U103mousikomi">申し込み</a>

	<c:forEach var="data" items="${sessionScope.entry}" varStatus="status">
		<p>
			<c:out value="${data.sub_name}" />
			<a href="#"
				onclick="document.homhom.sub_id.value= '${data.sub_id}';document.homhom.num.value='1';document.homhom.submit();return false;">変更</a>
		</p>
		<p>
			<c:out value="${data.sub_name2}" />
			<a href="#"
				onclick="document.homhom.sub_id.value= '${data.sub_id2}'document.homhom.num.value='2';document.homhom.submit();return false;">変更</a>
		</p>



	</c:forEach>

	<form action="SubjectChange" method="get" name="homhom">
		<input type="hidden" name="sub_id" value="">
		<input type="hidden" name="num" value="">
	</form>


</body>
</html>