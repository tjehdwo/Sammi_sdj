package com.kh.sammi;

public class RealEstateInfo {
	private int realEstateId;
	private String realEstateName;
	private String realEstateType;
	private String realEstateCondition;
	private double realEstateArea;
	private int realEstateMonthly;
	private String realEstatePhotos;
	private String realEstateAddress;
	
	public RealEstateInfo() {}
	public RealEstateInfo(int realEstateId,String realEstateName, String realEstateType,
			String realEstateCondition,double realEstateArea,
			int realEstateMonthly,String realEstatePhotos,String realEstateAddress) {
		this.realEstateId = realEstateId;
		this.realEstateName = realEstateName;
		this.realEstateType = realEstateType;
		this.realEstateCondition = realEstateCondition;
		this.realEstateArea = realEstateArea;
		this.realEstateMonthly = realEstateMonthly;
		this.realEstatePhotos = realEstatePhotos;
		this.realEstateAddress = realEstateAddress;
	}
	
	
	
	
	public int getRealEstateId() {
		return realEstateId;
	}
	public void setRealEstateId(int realEstateId) {
		this.realEstateId = realEstateId;
	}
	public String getRealEstateName() {
		return realEstateName;
	}
	public void setRealEstateName(String realEstateName) {
		this.realEstateName = realEstateName;
	}
	public String getRealEstateType() {
		return realEstateType;
	}
	public void setRealEstateType(String realEstateType) {
		this.realEstateType = realEstateType;
	}
	public String getRealEstateCondition() {
		return realEstateCondition;
	}
	public void setRealEstateCondition(String realEstateCondition) {
		this.realEstateCondition = realEstateCondition;
	}
	public double getRealEstateArea() {
		return realEstateArea;
	}
	public void setRealEstateArea(double realEstateArea) {
		this.realEstateArea = realEstateArea;
	}
	
	public int getRealEstateMonthly() {
		return realEstateMonthly;
	}
	public void setRealEstateMonthly(int realEstateMonthly) {
		this.realEstateMonthly = realEstateMonthly;
	}
	public String getRealEstatePhotos() {
		return realEstatePhotos;
	}
	public void setRealEstatePhotos(String realEstatePhotos) {
		this.realEstatePhotos = realEstatePhotos;
	}
	public String getRealEstateAddress() {
		return realEstateAddress;
	}
	public void setRealEstateAddress(String realEstateAddress) {
		this.realEstateAddress = realEstateAddress;
	}
	
	
	
	
/*
 * REALESTATE_ID;
	 INTERMEDIARY_ID
	REALESTATE_NAME
	REALESTATE_TYPE
	REALESTATE_CONDITION
	REALESTATE_AREA
	FLOORS
	ROOMS_COUNT
	TOILET_COUNT
	REALESTATE_SALEPRICE
	REALESTATE_MONTHLY
	REALESTATE_MAINTENANCE_COST
	AVAILABLE_MOVE_IN_DATE
	PARKING_COUNT
	REALESTATE_OPTIION
	REALESTATE_PHOTOS
	OTHER_COMMENT
	REALESTATE_DATE
	REALESTATE_ADDRESS*/
}
