<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 홈페이지</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles2.css">
</head>
<body>
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
		<div>
		<form action="MainPageServlet" method="post">
		
		
		
		
		
		
		
		
		
		
		
		</form>
		</div>
		
		<div id="mainPageCenter">
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
	
	<footer>
		<p>드루와방 메인페이지입니다.</p>
	</footer>
	</div>
<script src="./JS/Main.js">
 
</script>
	
</body>
</html>