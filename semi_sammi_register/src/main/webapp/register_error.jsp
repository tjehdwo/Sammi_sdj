<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 실패 !</title>
</head>
<body>
<h1>가입 실패</h1>
<p>회원 가입중 오류가 발생했습니다.
가입을 다시 시도해주세요.</p>
<script>
	//3초 후 홈페이지로 이동하는 javascript
	setTimeout(function() {
		//이동할 페이지 경로 설정
		window.location.href="register.jsp";
	}, 5000); //5000 = 5초
</script>
</body>
</html>