<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<jsp:include page="/WEB-INF/view/msg/msg.jsp"></jsp:include>
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
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        margin-bottom: 10px;
        border-collapse: collapse;
    }

    th, td {
        padding: 8px;
        border-bottom: 1px solid #ddd;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    input[type="text"],
    input[type="password"],
    button[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    button[type="submit"] {
        background-color: #007bff;
        border: none;
        color: #fff;
        cursor: pointer;
    }
</style>
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