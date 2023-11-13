<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 사이트</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles2.css">
</head>
<body>
<h1>회원탈퇴</h1>
<div id="background">
    <form action="DeleteUserServlet" method="post">
        
            <div id="d1">
                <label for="ID">아이디 : </label>
                <input type="text" placeholder="아이디를 입력하세요." id="ID" name="ID" required><br>
            </div>
            <div id="d2">
                <label for="PASSWORD">비밀번호 : </label>
                <input type="PASSWORD" placeholder="비밀번호를 입력하세요." id="PASSWORD" name="PASSWORD" required><br><br>
            </div>
            <br>
         	<div>
                <input type="submit" value="탈퇴하기" id="deleteButton" >
            </div>
          
    </form>
</div>
<script>

</script>

</body>
</html>