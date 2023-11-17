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
			 * realEstateName s
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
	public int getTotalRealEstateInfoCount(String realAddress){
		int totalCount = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			String sql = "SELECT COUNT(*) AS total FROM REALESTATEINFO WHERE REALESTATE_ADDRESS = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, realAddress);
			ResultSet rs = ps.executeQuery();
			
			
			if(rs.next()) {
				totalCount = rs.getInt("total");
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
	public List<RealEstateInfo> getMainRealEstate(int pageNumber, int pageSize) {
		
		List<RealEstateInfo> realList = new ArrayList<>();
		int start = PaginationUtil.paginationStart(pageNumber, pageSize);
        int end = PaginationUtil.paginationEnd(pageNumber, pageSize);
        
        try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				String sql = "SELECT * FROM (SELECT r.*, ROWNUM AS rnum FROM (SELECT * FROM REALESTATEINFO ORDER BY REALESTATE_ID) r WHERE ROWNUM <= ?) WHERE rnum >= ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, end);
		        ps.setInt(2, start);
		        ResultSet rs = ps.executeQuery();
		        
		        
		        while(rs.next()) {
		        	RealEstateInfo realEstateInfo = new RealEstateInfo();
		        	realEstateInfo.setRealEstateId(rs.getInt("REALESTATE_ID"));
		        	realEstateInfo.setRealEstateName(rs.getString("REALESTATE_NAME"));
		        	realEstateInfo.setRealEstateType(rs.getString("REALESTATE_TYPE"));
		        	realEstateInfo.setRealEstateCondition(rs.getString("REALESTATE_CONDITION"));
		        	realEstateInfo.setRealEstateArea(rs.getDouble("REALESTATE_AREA"));
		        	realEstateInfo.setRealEstateMonthly(rs.getInt("REALESTATE_MONTHLY"));
		        	realEstateInfo.setRealEstateAddress(rs.getString("REALESTATE_ADDRESS"));
		        	realList.add(realEstateInfo);
		        	
		        
		        
		        }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return realList;
	    

	}
}

