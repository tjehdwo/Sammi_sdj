<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 사이트</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles2.css">
</head>
<body id="deleteBody">
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



<div>
	<section>
	<h2>회원탈퇴</h2>
    <form action="DeleteUserServlet" method="post">
            <div id="deleteId">
                <label for="ID">아이디 : </label>
                <input type="text" placeholder="아이디를 입력하세요." id="ID" name="ID" required><br>
            </div>
            <div id="deletePw">
                <label for="PASSWORD">비밀번호 : </label>
                <input type="PASSWORD" placeholder="비밀번호를 입력하세요." id="PASSWORD" name="PASSWORD" required><br><br>
            </div>
            <br>
         	<div>
                <input type="submit" value="회원탈퇴" id="deleteButton" >
            </div>
    </form>
    </section>
</div>
<script>

</script>

</body>
</html>