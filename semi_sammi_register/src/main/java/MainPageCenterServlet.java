

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


@WebServlet("/MainPageCenterServlet")
public class MainPageCenterServlet extends HttpServlet {
	
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
		
			
			/*
			REALESTATEINFO
			REALESTATE_ID
			REALESTATE_NAME
			REALESTATE_TYPE
			REALESTATE_CONDITION
			REALESTATE_AREA
			REALESTATE_ADDRESS
			*/
			
			int realId = Integer.parseInt(request.getParameter("REALESTATE_ID"));
			String realName = request.getParameter("REALESTATE_NAME");
			String realType = request.getParameter("REALESTATE_TYPE");
			String realCondition = request.getParameter("REALESTATE_CONDITION");
			String realArea = request.getParameter("REALESTATE_AREA");
			String realAddress = request.getParameter("REALESTATE_ADDRESS");
			
			String sql2 = "SELECT REALESTATE_ID,REALESTATE_NAME,REALESTATE_TYPE,REALESTATE_CONDITION,REALESTATE_AREA FROM REALESTATEINFO WHERE REALESTATE_ADDRESS LIKE '%?%'";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement2.setString(1,realAddress);
			preparedStatement2.executeQuery();
			
			//성공시 (추천매물사이트 주소)
			response.sendRedirect("");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}


