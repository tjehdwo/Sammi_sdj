

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
		// JDBC �ҷ�����
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
			
			//�ְ����ϴ� DB �� ����
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
			
			
			//ȸ������ insert
			String sql = "INSERT INTO USERINFO (USER_ID,ID,PASSWORD,PHONE_NUMBER,Email,ADDRESS) VALUES (USERINFO_SEQ.NEXTVAL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3,phoneNumber);
			preparedStatement.setString(4,email);
			preparedStatement.setString(5,address);
			
			preparedStatement.executeUpdate();
			
			
		
			request.getSession().setAttribute("ID",id);
			request.getSession().setAttribute("PASSWORD",password);
			request.getSession().setAttribute("PHONE_NUMBER",phoneNumber);
			request.getSession().setAttribute("EMAIL",email);
			request.getSession().setAttribute("ADDRESS",address);
				
			//������ ��� �̵��� ������ �������ְ� �ٽ� ����
			response.sendRedirect("register_success.jsp");
		} catch (SQLException e) {
			//������ ��� �̵��� ������ ����
			response.sendRedirect("register_error.jsp");
			e.printStackTrace();
		}
	}

}
