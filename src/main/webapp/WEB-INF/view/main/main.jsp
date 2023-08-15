<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<style>
 body{
        position: relative;
        width: 1000px;
        height: 600px;
        border: 1px solid black;
    }
    .login{
        position: absolute;
        bottom: 250px;
        left: 50%;
        width: 80px;
        height: 40px;
        text-align: center;
        line-height: 40px;
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<c:choose>
	<c:when test="${not empty SsLoginId }">
	 <div class="login">
<a href="${pageContext.request.contextPath}/login">로그인</a>
	</div>
	</c:when>
</c:choose>
</body>
</html>