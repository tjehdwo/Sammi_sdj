<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 사이트</title>

</head>
<body>
<h1>회원가입</h1>

<div id="background">
          <form action="RegisterServlet" method="post">  
            
             <div id="d1">
                <label for="ID">아이디 : </label>
                <input type="text" placeholder="아이디를 입력하세요." id="ID" name="ID" required><input type="submit" value="중복 체크">
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
                <input type="PASSWORD" placeholder="비밀번호를 확인하세요." id="PWCHECK" name="PWCHECK" required><input type="button" value="비밀번호 확인" onclick="checkPW()"><br>
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
<<<<<<< HEAD
                <button type="submit" onclick="createUser()" >가입하기</button>
=======
                <button type="submit" onclick="createUser()">가입하기</button>
>>>>>>> 415de35a26f955997a62c37fad969f8c9c26c450
            </div>
         
    </form>
</div>

<script>
function createUser () {

	var userId = document.getElementById("ID");
	var userPw = document.getElementById("PASSWORD");

<<<<<<< HEAD
	if(userId.value === undefined || userId.value === "" || userId.value.length === 0 ) {
=======
	if(userId.value === undefined || userId.value === "" || userId.value.length === 0 || $.trim(userId) === "") {
>>>>>>> 415de35a26f955997a62c37fad969f8c9c26c450
      	alert('ID를 입력하세요');
      	userId.focus();
      	return false;
   }

<<<<<<< HEAD
       	if(userPw.value === undefined || userPw.value === "" || userPw.value.length === 0) {
=======
       	if(userPw.value === undefined || userPw.value === "" || userPw.value.length === 0 || $.trim(userPw) === "") {
>>>>>>> 415de35a26f955997a62c37fad969f8c9c26c450
      	alert('비밀번호를 입력하세요');
      	userPw.focus();
      	return false;
   }
}

<<<<<<< HEAD
function checkPW () {
	var pw = document.getElementById("PASSWORD");
	var pwCheck = document.getElementById("PWCHECK");
=======
>>>>>>> 415de35a26f955997a62c37fad969f8c9c26c450
	
	if(pw.value === pwCheck.value){
		alert("비밀번호가 일치합니다.");
		return true;
	}else if(pw.value.length ===0||pwCheck.value.length ===0){
		alert("비밀번호/비밀번호 확인을 입력해주세요.");
		return false;	
	}else{
		alert("비밀번호 확인을 잘못 입력하셨습니다. 다시 입력하세요.");
		pwCheck.focus();
		return false;
	}
	
}

</script>
</body>
</html>
