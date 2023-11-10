<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 성공!</title>
</head>
<body>
<h1>회원가입에 성공!</h1>
<h2>회원가입 정보 : </h2>
<p> 아이디 : <%= session.getAttribute("ID") %></p>
<p> 비밀번호 : <%= session.getAttribute("PASSWORD") %></p>
<p> 전화번호 : <%= session.getAttribute("PHONE_NUMBER") %></p>
<p> 이메일 : <%= session.getAttribute("EMAIL") %></p>
<p> 주소 : <%= session.getAttribute("ADDRESS") %></p>
<script>
	//3초 후 홈페이지로 이동하는 javascript
	setTimeout(function() {
		//이동할 페이지 경로 설정
		window.location.href="Main.jsp";
	}, 5000); //5000 = 5초
</script>
</body>
</html>