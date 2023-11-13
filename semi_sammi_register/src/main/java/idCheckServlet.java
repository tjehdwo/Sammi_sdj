

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
import javax.servlet.http.HttpSession;


@WebServlet("/idCheckServlet")
public class idCheckServlet extends HttpServlet {
	
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			String sql = "SELECT ID FROM USERINFO WHERE ID = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("ID", result.getString("ID"));
				response.sendRedirect("register.jsp");
			}else {
				response.sendRedirect("register.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
