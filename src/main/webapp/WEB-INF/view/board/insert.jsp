<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }

    h2 {
        text-align: center;
        margin-top: 20px;
    }

    div {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    form input[type="text"],
    form textarea {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
        resize: vertical;
    }

    form button[type="submit"],
    form button[type="button"] {
        padding: 10px 20px;
        background-color: #007bff;
        border: none;
        border-radius: 3px;
        color: #fff;
        cursor: pointer;
    }

    form button[type="button"] {
        background-color: #ccc;
        margin-left: 10px;
    }
    
    #btn-board-list {
        background-color: #ccc;
        margin-left: 10px;
    }
</style>
</head>
<body>
<c:if test="${empty SsLoginId }">
    <script>
        alert("글작성은 로그인 후 사용가능합니다.");
        location.href="${pageContext.request.contextPath}/login";
    </script>
</c:if>
<c:choose>
    <c:when test="${not empty bno }">
        <h2>${bno }번 글에 답글 등록</h2>
    </c:when>
    <c:otherwise>
        <h2>새 글 등록</h2>
    </c:otherwise>
</c:choose>
<div>
    <form action="<%=request.getContextPath() %>/board/insert" method="post"
            enctype="multipart/form-data" >
        <c:if test="${not empty bno }">
            <input type="hidden" name="bno" value="${bno }">
        </c:if>
        제목: <input type="text" name="btitle">
        <br>
        내용: <textarea rows="10" cols="50" name="bcontent"></textarea>
        <br>
        <button type="submit" id="btn-board-insert">글 등록</button>
	    <button type="button" id="btn-board-list">글목록으로 이동</button>
    </form>
</div>
	<script>
		$("#btn-board-list").click(function(){
			location.href="${pageContext.request.contextPath}/board/list";
		});
		$("#btn-board-insert").click(function(){
			alert("댓글 등록이 완료되었습니다.");
		});
	</script>
</body>
</html>