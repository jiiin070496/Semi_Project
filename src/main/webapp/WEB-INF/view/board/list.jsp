<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
	.wrap-grid {
		display: grid;
		grid-template-columns: auto auto auto auto auto;
	}
</style>
</head>
<body>
<div>
<c:choose>
	<c:when test="${not empty SsLoginId }">
<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:when>
	<c:otherwise>
<a href="${pageContext.request.contextPath}/login">로그인</a>	
	</c:otherwise>
</c:choose>
</div>
	<h2>게시글</h2>
	<div><a href="<%=request.getContextPath() %>/board/insert">글등록</a></div>
	<div class="wrap-grid">
		<div>글번호</div>
		<div>제목</div>
		<div>작성자</div>
		<div>작성일</div>
		<div>답글</div>
<c:if test="${not empty boardList }">
	<c:forEach items="${boardList }" var="vo">
		<div>${vo.idx }</div>
		<div>
		<c:forEach begin="1" end="${vo.breLevel }">
		&#8618;
		</c:forEach>
		${vo.title }
		</div>
		<div>${vo.mid }</div>
		<div>${vo.writeDate }</div>
		<div><a href="<%=request.getContextPath()%>/board/insert?idx=${vo.idx }">답글</a></div>
	</c:forEach>
</c:if>		
	</div>
</body>
</html>