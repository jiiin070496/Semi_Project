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
    <h2>글 수정</h2>
    <form action="${pageContext.request.contextPath}/board/update" method="post">
        <input type="hidden" name="bno" value="${dto.bno}">
        제목: <input type="text" name="btitle" value="${dto.btitle}">
        <br>
        내용: <textarea rows="10" cols="50" name="bcontent">${dto.bcontent}</textarea>
        <br>
        <input type="submit" value="수정">
    </form>
    <button type="button" id="btn-board-list">글목록으로 이동</button>
    
    <script>
	$("#btn-board-list").click(function(){
		location.href="${pageContext.request.contextPath}/board/list";
	});		
    </script>
</body>
</html>