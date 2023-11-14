<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 사이트</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles2.css">
</head>
<body id="createBody">
<div>
<header>
	<div class="use_list_box">
                <div class="use_list">
                    <p>
                        <a href="Main.jsp" class="use_main" onclik>
                            <span><img src="./img/로고.png" class="logo"></span>
                        </a>
                    </p>
                  
                    <ul class="use">
                        <li>
								 <a href="Main.jsp" class="use_logout" title="로그아웃" >
	                                <span><img src="./img/logout.png" class="logout"><br>LOGOUT</span>
	                          	 </a>
                          		
								
                        </li>
                        <li>
                            <a href="마이페이지로 이동" class="use_mypage" title="마이페이지">
                                <span><img src="./img/유저.png" class="user"><br>MY</span>
                            </a>
                        </li>
                        <li>
                            <a href="찜 매물 조회로 이동" class="use_likelist" title="찜매물">
                                <span><img src="./img/찜.png" class="like"><br>찜</span>
                            </a>
                        </li>
                    </ul>

                </div>

            </div>
	
	</header>
	<section>
<h1>회원가입</h1>
	<div id="background">
	          <form action="RegisterServlet" method="post">  
	            
	             <div id="d1">
	                <label for="ID">아이디 : </label>
	                <input type="text" placeholder="아이디를 입력하세요." id="ID" name="ID" required><input type="submit" value="중복 체크" id="checkButton">
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
	                <input type="PASSWORD" placeholder="비밀번호를 확인하세요." id="PWCHECK" name="PWCHECK" required><input type="button" value="비밀번호 확인" onclick="checkPW()" id="checkPwButton"><br>
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
	
	                <button type="submit" onclick="createUser()" >가입하기</button>
	            </div>
	         
	    </form>
		
	</div>
	</section>
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


function checkPW () {
	var pw = document.getElementById("PASSWORD");
	var pwCheck = document.getElementById("PWCHECK");


	
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
