<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 완료!</title>
</head>
<body>
<h1>회원 탈퇴 성공</h1>
<h2>잠시 뒤 로그인 페이지로 이동합니다.</h2>
<script>
	//3초 후 홈페이지로 이동하는 javascript
	setTimeout(function() {
		//이동할 페이지 경로 설정
		window.location.href="logout.jsp";
	}, 5000); //3000 = 3초
</script>
</body>
</html>