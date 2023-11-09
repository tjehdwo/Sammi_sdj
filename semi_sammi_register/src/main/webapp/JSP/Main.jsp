<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인 홈페이지</title>
<link rel="stylesheet" type="text/css" href="../CSS/styles.css">
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	<div>
		<div>
		<form action="MainPageServlet" method="post">
		<a href = "login.jsp">로그인</a>
		
		
		
		
		
		
		
		
		
		
		</form>
		</div>
		
		<div>
		<form action="MainPageCenterServlet" method="post">
		<h1>추천매물</h1>
        <div id="pagination">
            <button id="prevPage">이전</button>
        </div>
            <div class="img-container">
                <!--이미지를 추가하는 공간-->
            </div>
        <div>
            <button id="nextPage">다음</button>
        </div>
		
		
		
		
		
		
		
		</form>
		</div>
	
	
	</div>
<script src="../JS/Main.js">

</script>
	
</body>
</html>