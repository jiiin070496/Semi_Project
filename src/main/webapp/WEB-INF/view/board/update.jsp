<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
</head>
<body>
	<c:choose>
	<c:when test="${not empty bno }">
		<h2>${bno }번 글 답글수정</h2>
	</c:when>
	<c:otherwise>
		<h2>새 글 등록</h2>
	</c:otherwise>
</c:choose>
	<div>
	<!-- type="file" 이 있다면 form method="post" enctype="multipart/form-data" 반드시 작성!!! -->
		<form action="<%=request.getContextPath() %>/board/insert" method="post" 
					enctype="multipart/form-data" >
			<c:if test="${not empty bno }">
				<input type="hidden" name="bno" value="${bno }">
			</c:if>
			제목:<input type="text" name="btitle">
			<br>
			내용:<textarea rows="10" cols="50" name="bcontent"></textarea>
			<br>
			<button type="submit" id="btn-board-insert">글 등록</button>
		</form>		
		<button type="button" id="btn-board-list">글목록으로 이동</button>
	</div>
</body>
</html>