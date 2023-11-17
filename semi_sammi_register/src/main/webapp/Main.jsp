<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kh.sammi.RealEstateInfo" %>
<%@ page import="com.kh.sammi.RealEstateInfoDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.io.OutputStream" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 홈페이지</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles2.css">
</head>
<body id="mainBody">

<header>
		<div class="use_list_box">
			<div class="use_list">
				<p>
					<a href="Main.jsp" class="use_main">
						<span><img src="./img/로고.png" class="logo"></span>
					</a>
				</p>
				                  
				<ul class="use">
					<li>
					<%
					  if (session.getAttribute("ID") != null) {
					 %>
					 <% String id = (String)session.getAttribute("ID"); %>
	
						<a href="logout.jsp" class="use_logout" title="로그아웃" >
							<span><img src="./img/logout.png" class="logout"><br>LOGOUT</span>
						</a>
						<% 
					  }else{
						%>
						<a href="login.jsp" class="use_logout" title="로그인" >
							<span><img src="./img/login.png" class="logout"><br>LOGIN</span>
						</a>
						<%
					  }
						%>
	
					</li>
					<li>
						<a href="MyPage.jsp" class="use_mypage" title="마이페이지">
							<span><img src="./img/유저.png" class="user"><br>MY</span>
						</a>
					</li>
					<li>
						<a href="deleteUser.jsp" class="use_likelist" title="찜매물">
							<span><img src="./img/찜.png" class="like"><br>찜</span>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</header>
		<div id="mainPageCenter">
		<h1 id="hh">추천매물</h1>
		<form action="MainPageCenterServlet" method="post">
		 <div>
		 
	
<%	
	
    
	String address = (String)session.getAttribute("ADDRESS");
	RealEstateInfoDAO realEstateInfoDAO = new RealEstateInfoDAO();
	int pageNumber = 1;
	int pageSize = 2;
    if(session.getAttribute("ADDRESS") != null){
		
    	
		
		List<RealEstateInfo> realList = realEstateInfoDAO.getMainRealEstate(pageNumber,pageSize);
    
	    for (RealEstateInfo r : realList) {
	        int realId = r.getRealEstateId();
	    	String realName = r.getRealEstateName();
	        String realType = r.getRealEstateType();
	        String realCondition = r.getRealEstateCondition();
	        double realArea = r.getRealEstateArea();
	        int realMonthly = r.getRealEstateMonthly();
	        String realAddress = r.getRealEstateAddress();
     	  // String realPhotos = r.getRealEstatePhotos();
        
        
        // 매물 정보를 출력하는 코드 작성
        %>
        
        <div id="mainDiv">
	        <table border=1>
	        	<tr>
	        		<th>
		        		<th> <h2><%= realName %></h2></th>
						<td><p>유형: <%= realType %></p> 
						<p>상태: <%= realCondition %></p>
				        <p>면적: <%= realArea %> 제곱미터</p>
						<p>월세: <%= realMonthly %> 만원</p>
						<p>주소: <%= realAddress %></p>
						</td> 
						<th>
						
						<img src="img/login.png" id="imageSize">
							
						</th>      
						    
						 <% }
	    }else{
		%>	    	
	    <h1>추천 매물이 없습니다.</h1>
	    <% }
	    %>
	    

								    
								   
								    	
							    
   					 
    			
    				</th>
				</tr>
			</table>
			 				
						       
		</div>
		</div>
		<%
		//1. 페이지네이션 링크를 생성해줄것이고, 링크는 page 값에 따라서 다르게 보일 것
		String test = (String)session.getAttribute("ADDRESS");
		int totalEventList = realEstateInfoDAO.getTotalRealEstateInfoCount(test); //전체 제품 가져오기
		int totalPages = (int) Math.ceil((double) totalEventList / pageSize);

		for (int i = 1; i <= totalPages; i++) {
		%>
		
		<a href="<%=request.getRequestURI()%>?page=<%=i%>"><%=i%></a>
	
		<%
		}
		%>
		</form>
		</div>
	
	<footer>
		<p><a href="Main.jsp">메인으로</a></p><p>전화번호:02-123-4567</p>
			  
	</footer>
	
<script>

</script>
	
</body>
</html>