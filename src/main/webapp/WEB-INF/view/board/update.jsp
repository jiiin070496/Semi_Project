<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
</head>
<body>
<h2>글 수정</h2>
<form id="update" action="${pageContext.request.contextPath}/board/update" method="post">
    <input type="hidden" name="bno" value="${dto.bno}">
    제목: <input type="text" name="btitle" value="${dto.btitle}">
    <br>
    내용: <textarea rows="10" cols="50" name="bcontent">${dto.bcontent}</textarea>
    <br>
    <input type="submit" value="수정">
	<button type="button" id="btn-board-list">메인으로</button>
</form>

<script>   
$("#update").submit(function(e) {
    $.ajax({
        type: "POST",
        url: $(this).attr("action"),
        data: $(this).serialize(),
        success: function(result) {
            alert("글이 수정되었습니다.");
            location.href = "${pageContext.request.contextPath}/board/list";
        },
        error: function() {
            alert("글 수정에 실패하였습니다.");
        }
    });
});

$("#btn-board-list").click(function(){
    location.href="${pageContext.request.contextPath}/board/list";
});    

</script>
</body>
</html>