<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 등록</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
<c:choose>
	<c:when test="${not empty bvo }">
		<h2>${bvo.bno }</h2>
	</c:when>
	<c:otherwise>
		<script>
			alert("해당하는 글을 읽을 수 없습니다. 다시 글 선택해주세요.");
			location.href="${pageContext.request.contextPath}/board/list";
		</script>
	</c:otherwise>
</c:choose>
	<div>
 		<form action="<%=request.getContextPath() %>/board/update" method="post">
	        <input type="hidden" name="bno" value="${bvo.bno }">
	        제목:<input type="text" name="btitle" value="${bvo.btitle }" readonly>
	        <br>
	        내용:<textarea rows="10" cols="50" name="bcontent" readonly>${bvo.bcontent }</textarea>
	        <br>
	
	        <c:if test="${SsLoginId eq bvo.mid}">
	            <button type="submit" id="btn-board-update">글 수정</button>
	            <button type="button" id="btn-board-delete">글 삭제</button>
	        </c:if>
	        <button type="button" id="btn-board-reply">댓글달기</button>
	        <button type="button" id="btn-board-list">글목록으로 이동</button>
        </form>
	</div>
	
	<script>
	   $("#btn-board-delete").click(function(){
           var bno = ${bvo.bno};
           if (confirm("글 삭제하시겠습니까?")) {
               $.ajax({
                   type: "POST",
                   url: "${pageContext.request.contextPath}/board/delete",
                   data: { bno: bno },
                   success: function (result){
                       if (result > 0){
                           alert("게시글 삭제에 실패했습니다.");
                       } else{
                           alert("게시글이 삭제되었습니다.");
                           location.href = "${pageContext.request.contextPath}/board/list";
                       }
                   }
               });
           }
       	});
	   	
		$("#btn-board-update").click(function(){
	        location.href="${pageContext.request.contextPath}/board/update?bno=${bvo.bno}";
 		});		
	   	
		$("#btn-board-list").click(function(){
			location.href="${pageContext.request.contextPath}/board/list";
		});		
		$("#btn-board-reply").click(function(){
			location.href="${pageContext.request.contextPath}/board/insert?bno=${bvo.bno }";
		});		
	</script>
</body>
</html>