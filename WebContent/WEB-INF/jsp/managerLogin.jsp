<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/hover.css" rel="stylesheet" media="all">
<link href="css/style.css" rel="stylesheet" media="all">
<link href="css/tekkadan.css" rel="stylesheet" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/zemihide/js/javascript.js"></script>
<title>管理者用ログイン</title>
</head>
<body id="manager">
	<form action="<%=request.getContextPath()%>/M102conf" method="POST"
		onsubmit="return check(this)">
	<div class="parent">
  	<div class="inner">
    <div class="tablecell">
    
	<c:if test="${errorMassage != null }">
		<c:out value="${errorMassage}"></c:out>
	</c:if>
			<table class="formstyle">
			<tr>
			<td colspan="2">ログイン（管理者）</td>
			</tr>
			<tr>
				<td>教師ID:</td>
				<td><input type="text" name="m_id"></td>
			</tr>
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
			<td colspan="2"><input type="submit" value="ログイン" onclick="check()" class="hvr-float"></td>
			</tr>
		</table>
	</div>
	</div>
	</div>
	</form>
</body>
</html>