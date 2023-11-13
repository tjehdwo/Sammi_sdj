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
                        	  <%
                        	  	
								String id = (String)session.getAttribute("ID");
								%>
                          	   <%=id %>님
								 <button class="use_logout" title="로그아웃" onclik="main()">
	                                <span><img src="./img/logout.png" class="logout"><br>LOGOUT</span>
	                          	 </button>
                          		
								
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
<script>
 function main () {
	 window.location.href="Main.jsp";
 }
</script>
	
</body>
</html>