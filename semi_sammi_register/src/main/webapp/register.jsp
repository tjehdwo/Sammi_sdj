<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "UserInfoDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 사이트</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles.css">
</head>
<body>
<h1>회원가입</h1>
<% UserInfoDAO userInfoDAO = new UserInfoDAO();
   
%>
<div id="background">
          <form action="RegisterServlet" method="post">  
             <div id="d1">
                <label for="ID">아이디 : </label>
                <input type="text" placeholder="아이디를 입력하세요." id="ID" name="ID" required><input type="submit" value="중복 체크" id="checkButton" onclick="">
            </div>
            <div id="d2">
                <label for="PASSWORD">비밀번호 : </label>
                <input type="PASSWORD" placeholder="비밀번호를 입력하세요." id="PASSWORD" name="PASSWORD" required><br>
            </div>
            	<div>
            	<p id="pm" style="color:red;"></p><br>
            	</div>
            <div id="d3">
                <label for="PWCHECK">비밀번호 확인 : </label>
                <input type="PASSWORD" placeholder="비밀번호를 확인하세요." id="PWCHECK" name="PWCHECK" required><input type="button" value="비밀번호 확인"><br>
            </div>
            
            <div id="d4">  
                <label for="PHONE_NUMBER">전화번호 : </label>
                <input type="text" placeholder="번호를 입력하세요.(-제외)"id="PHONE_NUMBER" name="PHONE_NUMBER" required><br>
            </div>
            <div id="d5">
                <label for="EMAIL">이메일 : </label>
                <input type="email"placeholder="이메일을 입력하세요." id="EMAIL" name="EMAIL"><br>
            </div>
            <div id="d6">
                <label for="ADDRESS">주소 : </label>
                <input type="text" placeholder="주소를 입력하세요." id="ADDRESS" name="ADDRESS" required><br>
            </div>
            <div id="d7">    
                <button type="submit" onclick="createUser()">가입하기</button>
            </div>
         
    </form>
</div>

<script>
function createUser () {

	var userId = document.getElementById("ID");
	var userPw = document.getElementById("PASSWORD");

	if(userId.value === undefined || userId.value === "" || userId.value.length === 0 || $.trim(userId) === "") {
      	alert('ID를 입력하세요');
      	userId.focus();
      	return false;
   }

       	if(userPw.value === undefined || userPw.value === "" || userPw.value.length === 0 || $.trim(userPw) === "") {
      	alert('비밀번호를 입력하세요');
      	userPw.focus();
      	return false;
   }
}

	

</script>
</body>
</html>
