<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� Ȩ������</title>
<link rel="stylesheet" type="text/css" href="./CSS/styles.css">
</head>
<body>
	<h1>���� �������Դϴ�.</h1>
	<div>
		<div>
		<form action="MainPageServlet" method="post">
		<a href = "login.jsp">�α���</a>
		
		
		
		
		
		
		
		
		
		
		</form>
		</div>
		
		<div>
		<form action="MainPageCenterServlet" method="post">
		<h1>��õ�Ź�</h1>
        <div id="pagination">
            <button id="prevPage">����</button>
        </div>
            <div class="img-container">
                <!--�̹����� �߰��ϴ� ����-->
            </div>
        <div>
            <button id="nextPage">����</button>
        </div>
		
		
		
		
		
		
		
		</form>
		</div>
	
	
	</div>
<script src="./JS/Main.js">

</script>
	
</body>
</html>