<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
</head>
<body>
<h2>회원가입</h2>
<div>
	<form action="<%=request.getContextPath() %>/member/insert.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mpwd"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mname"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="memail"></td>
			</tr>
		</table>
		<button type="submit">회원등록</button>
	</form>
</div>
</body>
</html>