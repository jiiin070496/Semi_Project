<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<style>
body{
    position: relative;
    width: 1000px;
    height: 600px;
    border: 1px solid black;
}
 .title{
    font-weight: bold;
    width: 800px;
    height: 50px;
    border: 1px solid black;
    margin: 5px auto;
    text-align: center;
}
.list{
    width: 800px;
    height: 400px;
    border: 1px solid black;
    margin: 5px auto;
}
.styled-board{
	width = 100%;
	border-collapse = collapse;
	text-align: center;
}
.styled-board th, .styled-board td{
	padding: 10px;
}
.styled-board th {
	background-color: #f2f2f2;
}
.footer{
    position: absolute;
    bottom: 0px;
    left: 99px;
    width: 800px;
    height: 50px;
    border: 1px solid black;
    margin: 5px auto;
    text-align: center;
}
</style>
</head>
<body>
<div>
<%-- 
<c:choose>
	<c:when test="${not empty SsLoginId }">
		[<%= request.getSession().getAttribute("SsLoginId") %>]님 반갑습니다
	</c:when>
</c:choose> 
--%>

<script>
	var msg = '${successFailMsg}';
	if(msg){
		alert(msg);
	}
</script>

</div>
	<div class="title">
    	<p>커뮤니티 사이트</p>
    </div>
 	<c:if test="${not empty boardList }">
    	<p>총 <c:out value="${fn:length(boardList)}" />개의 게시물이 있습니다</p>
	</c:if>
	<div class="list">
		<table class="styled-board">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
	<c:if test="${not empty boardList }">
		<c:forEach items="${boardList }" var="vo">
			<tr>
				<td>${vo.bno }</td>
				<td>
				<a href="<%=request.getContextPath()%>/board/read?bno=${vo.bno }">
				<c:forEach begin="1" end="${vo.breLevel }">
				&#8618; 
				</c:forEach>
				${vo.btitle }
				</a>
				</td>
				<td>${vo.mid }</td>
				<td>${vo.bwriteDate }</td>
			</tr>
		</c:forEach>
	</c:if>
		</table>
	</div>
	<div>
	    <a href="<%=request.getContextPath()%>/board/insert">
	        <button>글 등록</button>
	    </a>
	</div>
<!-- 	<button type="button" id="btn-board-insert">글 등록</button>
	
	<script>
	$("#btn-board-insert").click(function(){
	    location.href="${pageContext.request.contextPath}/board/insert";
	});    
	</script> -->
     <div class="footer">
     	<p>copyright (c) 게시판</p>
     </div>
</body>
</html>