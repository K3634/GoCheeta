package com.codewithkrishanthi.model;

public class Driver {

	   private int dID;
	   private String driverName;
	   private String driverAddress;
	   private String driverTP;
	   private String branchName;
	   
	   
	public Driver() {
		super();
		
	}


	public Driver(String dName, String driverAddress, String driverTP, String branchName) {
		super();
		this.driverName = dName;
		this.driverAddress = driverAddress;
		this.driverTP = driverTP;
		this.branchName = branchName;
	}


	public Driver(int dID, String dName, String driverAddress, String driverTP, String branchName) {
		super();
		this.dID = dID;
		this.driverName = dName;
		this.driverAddress = driverAddress;
		this.driverTP = driverTP;
		this.branchName = branchName;
	}


	public int getdID() {
		return dID;
	}


	public void setdID(int dID) {
		this.dID = dID;
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


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	

	   
	   
}
