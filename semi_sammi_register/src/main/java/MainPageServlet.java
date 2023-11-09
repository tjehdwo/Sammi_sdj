

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


@WebServlet("/MainPageServlet")
public class MainPageServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// JDBC 불러오기
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
		
			/*DB
			USERINFO
			USER_ID
			USER_ADDRESS
			ID
			*/
			int userId = Integer.parseInt(request.getParameter("USER_ID"));
			String id = request.getParameter("ID");
			String address = request.getParameter("ADDRESS");
			
			//메인페이지 필요한 정보 
			String sql1 = "SELECT USER_ID,ID,ADDRESS FROM USERINFO WHERE USER_ID = ?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, userId);
			preparedStatement1.executeQuery();
			
			response.sendRedirect("MainPageCenterServle.java");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
