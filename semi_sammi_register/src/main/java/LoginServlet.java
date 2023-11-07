

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUsername ="sm";
		String jdbcPassword ="sm1234";
		
		try {
			Class.forName("orcle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		
		
		String id = request.getParameter("ID");
		String password = request.getParameter("PASSWORD");
		
		//로그인 SELECT
		String sql = "SELECT USER_ID,ID,ADDRESS FROM USERINFO WHERE ID = ? AND PASSWORD =?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, password);
		
		ResultSet result = preparedStatement.executeQuery();
		
		int user_id = result.getInt("USER_ID");
		String address = result.getString("ADDRESS");
		
		request.getSession().setAttribute("USER_ID",user_id);
		request.getSession().setAttribute("ADDRESS",address);
		request.getSession().setAttribute("ID", id);
		request.getSession().setAttribute("PASSWORD", password);
		
		//성공할 경우 이동할 페이지 설정후 전송
		response.sendRedirect("login_success.jsp");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("logun_error.jsp");
			e.printStackTrace();
		}
		
				
	}
	
}