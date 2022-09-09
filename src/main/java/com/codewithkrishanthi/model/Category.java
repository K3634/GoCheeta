package com.codewithkrishanthi.model;

public class Category {

	
	   private int categoryID;
	   private String vehicleNo;
	   private String vehicleName;
	   private String branchName;
	   private int price;
	   private String driverID;
	   private String driverName;
	   private String driverAddress;
	   private String driverTP;
	   
	   
	public Category() {
		super();
		
	}


	public Category(String vehicleNo, String vehicleName, String branchName, int price, String driverID,
			String driverName, String driverAddress, String driverTP) {
		super();
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.branchName = branchName;
		this.price = price;
		this.driverID = driverID;
		this.driverName = driverName;
		this.driverAddress = driverAddress;
		this.driverTP = driverTP;
	}


	public Category(int categoryID, String vehicleNo, String vehicleName, String branchName, int price, String driverID,
			String driverName, String driverAddress, String driverTP) {
		super();
		this.categoryID = categoryID;
		this.vehicleNo = vehicleNo;
		this.vehicleName = vehicleName;
		this.branchName = branchName;
		this.price = price;
		this.driverID = driverID;
		this.driverName = driverName;
		this.driverAddress = driverAddress;
		this.driverTP = driverTP;
	}


	public int getCategoryID() {
		return categoryID;
	}


	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}


	public String getVehicleNo() {
		return vehicleNo;
	}


	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDriverID() {
		return driverID;
	}


	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}


	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getDriverAddress() {
		return driverAddress;
	}


	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}


	public String getDriverTP() {
		return driverTP;
	}


	public void setDriverTP(String driverTP) {
		this.driverTP = driverTP;
	}

	   
	   
	   
	
	
}
