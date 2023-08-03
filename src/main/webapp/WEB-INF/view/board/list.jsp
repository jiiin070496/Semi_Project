<%@ page import="semi_project.board.model.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
	.wrap-flex {
		display: flex;
	}
	
	.wrap-grid {
		display: grid;
		grid-template-columns: auto auto auto auto auto;
	}
</style>
</head>
<body>
	<h2>게시글</h2>
	<div><a href="<%=request.getContextPath() %>/board/insert"></a>새글 등록</div>
	<div class="wrap-grid">
		<div>번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>옵션</div>
<c:if test="${not empty bList }">
	<c:forEach items="${bList } " var="vo">
			<div>${vo.idx }</div>
			<div>
				<div>${vo.mid }</div>
				<div>vo.writeDate</div>
				<div><a href="<%=request.getContextPath() %>/board/insert?idx=${vo.idx}">답글</a></div>
			</div>
	</c:forEach>
</c:if>
	</div>


</body>
</html>