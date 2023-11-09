<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="../CSS/styles.css">
</head>
<body>
<form action ="LoginServlet" method="post">
	<label for="ID">아이디 :</label>
	<input type="text" placeholder="아이디를 입력하세요."><br>
	
	<label for="PASSWORD">비밀번호 :</label>
	<input type="password" placeholder="비밀번호를 입력하세요."><br>
	<input type="submit" value="로그인"><input type="button" value="회원가입">
</form>
</body>
</html>