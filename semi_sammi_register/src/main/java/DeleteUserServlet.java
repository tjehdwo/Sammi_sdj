

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername ="sm";
		String jdbcPassword ="sm1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		
		//회원탈퇴 DELETE
		String sql = "DELETE FROM USERINFO WHERE ID = ? AND PASSWORD =?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, password);
		
		preparedStatement.executeUpdate();
		
		//성공시 로그인 화면으로 이동
		response.sendRedirect("login.jsp");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
