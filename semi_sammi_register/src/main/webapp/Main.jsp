<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kh.sammi.RealEstateInfo" %>
<%@ page import="com.kh.sammi.RealEstateInfoDAO" %>
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
		<div id="main center">
		
		 <div>
<%	
	String address = (String)session.getAttribute("ADDRESS");
    RealEstateInfoDAO realEstateInfoDAO = new RealEstateInfoDAO();
    List<RealEstateInfo> realEstateInfos = realEstateInfoDAO.getMainRealEstateInfos(address);
    
    for (RealEstateInfo r : realEstateInfos) {
        String realName = r.getRealEstateName();
        String realType = r.getRealEstateType();
        String realCondition = r.getRealEstateCondition();
        double realArea = r.getRealEstateArea();
        int realMonthly = r.getRealEstateMonthly();
        String realPhotos = r.getRealEstatePhotos();
        String realAddress = r.getRealEstateAddress();
        
        // 매물 정보를 출력하는 코드 작성
        %>
        <h2><%= realName %></h2>
        <p>유형: <%= realType %></p>
        <p>상태: <%= realCondition %></p>
        <p>면적: <%= realArea %> 제곱미터</p>
        <p>월세: <%= realMonthly %> 만원</p>
        <p>사진: <%= realPhotos %></p>
        <p>주소: <%= realAddress %></p>
        <% 
    }
%>
</div>
		
		
		</form>
		</div>
	</div>
	<footer>
		<p>드루와방 메인페이지입니다.</p>
	</footer>
	</div>
<script src="./JS/Main.js">
 
</script>
	
</body>
</html>