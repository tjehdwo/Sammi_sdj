

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
			String sql = "INSERT INTO USERINFO (ID,PASSWORD,PHONE_NUMBER,Email,ADDRESS) VALUES (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, password);
			preparedStatement.setString(4,phoneNumber);
			preparedStatement.setString(5,email);
			preparedStatement.setString(6,address);
			
			preparedStatement.executeUpdate();
			
			//���� ������ ��� ȸ�� ������ ���ǿ� ����
			/*���� ��ü�� ���� Ŭ���̾�Ʈ�� �������� ������ �����͸� �����ϰ� �����ϴ� �۾��� ����
			session "mno"��� �̸����� �����͸� �����ϴ� ����
			
			request : ���� Ŭ���̾�Ʈ�� ��û�� ���� ������ �����ϴ� ������ ��
			
			session �̶� ? ���̳� ���ø����̼� ���¸� �����ϰ� �����͸� �����ϱ� ���� ���
			
			getSession() : request���� ���� ������ ������ ��
			
			setAttribute("mno",mno) : ���ǿ� �����͸� �����ϴ� �޼���
			"mno" �����͸� �����ϰ�, "mno" ���� ���� �ش� �����ͷ� �����ǰ� ��
			�̷��� ����� �����ʹ� �ٸ� �����̳� jsp ���������� ���� ������
			*/
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
