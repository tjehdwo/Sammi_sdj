import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername ="sm";
	private static final String jdbcPassword ="sm1234";
	
	public UserInfoDAO() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserInfo getCheckId(String id,String password){
		UserInfo userInfo = null;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT ID,PASSWORD FROM USERINFO WHERE ID = ? AND PASSWORD = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
			int userId = resultSet.getInt("USER_ID");
				id = resultSet.getString("ID");
				password = resultSet.getString("PASSWORD");
			String phoneNumber = resultSet.getString("PHONE_NUMBER");
			String eMail = resultSet.getString("EMAIL");
			String address = resultSet.getString("ADDRESS");
				
				userInfo = new UserInfo(userId,id,password,phoneNumber,eMail,address);
			
			/*	request.setAttribute("",userInfo);
				request.getRequestDispatcher("/register.jsp").forward(request, response);*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userInfo;
	}

}
