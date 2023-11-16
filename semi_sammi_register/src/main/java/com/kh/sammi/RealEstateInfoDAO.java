package com.kh.sammi;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RealEstateInfoDAO {
	private static final String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String jdbcUsername = "sm";
	private static final String jdbcPassword = "sm1234";
	
	
	public List<RealEstateInfo> getMainRealEstateInfos(String realAddress){
		List<RealEstateInfo> realEstateInfos = new ArrayList<>();
		
		try {
			/* realEstate_id
			 * realEstateName 
			 * realEstateType 
			 * realEstateCondition 
			 * realEstateAddress 
			 * realEstatePhotos 
			 * realEstateMonthly
			 * realEstateArea
			 * */
			Class.forName("oracle.jdbc.OracleDriver");
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT REALESTATE_ID,REALESTATE_NAME,REALESTATE_TYPE,REALESTATE_CONDITION,REALESTATE_AREA,REALESTATE_MONTHLY,REALESTATE_PHOTOS,REALESTATE_ADDRESS FROM REALESTATEINFO WHERE REALESTATE_ADDRESS LIKE ?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, "%" + realAddress + "%");
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				int realId = resultSet.getInt("REALESTATE_ID");
				String realName = resultSet.getString("REALESTATE_NAME");
				String realType = resultSet.getString("REALESTATE_TYPE");
				String realConditon = resultSet.getString("REALESTATE_CONDITION");
				double realArea = resultSet.getDouble("REALESTATE_AREA");
				int realMonthly = resultSet.getInt("REALESTATE_MONTHLY");
				realAddress = resultSet.getString("REALESTATE_ADDRESS");
				
//				Blob realPhotos = resultSet.getBlob("REALESTATE_PHOTOS");
//				
//				byte[] imageData = realPhotos.getBytes(1,(int) realPhotos.length());
//				String imageBase64 = java.util.Base64.getEncoder().encodeToString(imageData);
//				String encodedImage = "data:image/jpeg;base64, " + imageBase64;
//				
				
				String encodedImage = "aa";
				RealEstateInfo realEstateInfo = new RealEstateInfo(realId,realName,realType,realConditon,realArea,realMonthly,encodedImage,realAddress);
				realEstateInfos.add(realEstateInfo);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return realEstateInfos;
	}
	
	/*public RealEstateInfo getRealEstateInfo(int realEstateId) {
		RealEstateInfo realEstateInfo = null;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return realEstateInfo;
	}*/
}
