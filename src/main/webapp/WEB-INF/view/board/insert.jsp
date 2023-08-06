<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty idx }">
		<h2>${idx }에 댓글 등록</h2>
	</c:when>
	<c:otherwise>
		<h2>새 글 등록</h2>
	</c:otherwise>
</c:choose>
	<div>
		<form action="<%=request.getContextPath() %>/board/insert" method="post">
			<c:if test="${not empty idx }">
				<input type="hidden" name="idx" value="${idx }">
			</c:if>
			제목: <input type="text" name="title">
			<br>
			내용: <textarea rows="10" cols="50" name="content"></textarea>
			<br>
			<button type="submit">글 등록</button>
		</form>
	</div>
</body>
</html>