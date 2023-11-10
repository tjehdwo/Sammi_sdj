

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// JDBC 불러오기
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername ="sm";
		String jdbcPassword ="sm1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
			//넣고자하는 DB 값 설정
			/*
			 * CREATE TABLE USERINFO (
			    USER_ID NUMBER(5) PRIMARY KEY,
			    ID VARCHAR2(50),
			    PASSWORD VARCHAR2(50),
			    PWCHECK  VARCHAR2(50),
			    PHONE_NUMBER VARCHAR2(15),
			    EMAIL VARCHAR2(50),
			    ADDRESS VARCHAR2(50)
			);
			 * */
			String id = request.getParameter("ID");
			String password = request.getParameter("PASSWORD");
			String phoneNumber = request.getParameter("PHONE_NUMBER");
			String email = request.getParameter("EMAIL");
			String address = request.getParameter("ADDRESS");
			
			
			//회원가입 insert
			String sql = "INSERT INTO USERINFO (USER_ID,ID,PASSWORD,PHONE_NUMBER,Email,ADDRESS) VALUES (USERINFO_SEQ.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3,phoneNumber);
			preparedStatement.setString(4,email);
			preparedStatement.setString(5,address);
			
			preparedStatement.executeUpdate();
			
			
			
			//가입 성공할 경우 회원 정보를 세션에 저장
			/*세션 객체를 통해 클라이언트와 서버간에 전송할 데이터를 저장하고 공유하는 작업을 수행
			session "mno"라는 이름으로 데이터를 저장하는 역할
			
			request : 현재 클라이언트의 요청에 대한 정보를 제공하는 역할을 함
			
			session 이란 ? 웹이나 애플리케이션 상태를 유지하고 데이터를 저장하기 위해 사용
			
			getSession() : request에서 현재 세션을 가지고 옴
			
			setAttribute("mno",mno) : 세션에 데이터를 저장하는 메서드
			"mno" 데이터를 저장하고, "mno" 변수 값이 해당 데이터로 설정되게 함
			이렇게 저장된 데이터는 다른 서블릿이나 jsp 페이지에서 접근 가능함
			*/
			request.getSession().setAttribute("ID",id);
			request.getSession().setAttribute("PASSWORD",password);
			request.getSession().setAttribute("PHONE_NUMBER",phoneNumber);
			request.getSession().setAttribute("EMAIL",email);
			request.getSession().setAttribute("ADDRESS",address);
				
			//성공할 경우 이동할 페이지 설정해주고 다시 전송
			response.sendRedirect("register_success.jsp");
		} catch (SQLException e) {
			//실패할 경우 이동할 페이지 설정
			response.sendRedirect("register_error.jsp");
			e.printStackTrace();
		}
	}

}
