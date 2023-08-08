<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<div>
	<div>
		<h2>로그인</h2>
		<a href="<%=request.getContextPath() %>/board/list">메인으로</a>			
		<form action="<%=request.getContextPath() %>/login.login" method="post">
			id: <input type="text" name="mid" required="required"><br>
			pw: <input type="password" name="mpwd" required="required"><br>
			<button type="submit">로그인</button>
		</form>
		<form action="<%=request.getContextPath() %>/member/insert" method="post">
			<button type="submit">회원가입</button>
		</form>
	</div>
</div>

</body>
</html>