package com.codewithkrishanthi.model;

public class Register {


		
		   private int uID;
		   private String uName;
		   private String address;
		   private String contactNo;
		   private String branchName;
		   private String uPassword;
		   private int urole_ID;
		   
		   
		public Register() {
			super();
			
		}


		public Register(String uName, String address, String contactNo, String branchName, String uPassword,
				int urole_ID) {
			super();
			this.uName = uName;
			this.address = address;
			this.contactNo = contactNo;
			this.branchName = branchName;
			this.uPassword = uPassword;
			this.urole_ID = urole_ID;
		}


		public Register(int uID, String uName, String address, String contactNo, String branchName, String uPassword,
				int urole_ID) {
			super();
			this.uID = uID;
			this.uName = uName;
			this.address = address;
			this.contactNo = contactNo;
			this.branchName = branchName;
			this.uPassword = uPassword;
			this.urole_ID = urole_ID;
		}


		public int getuID() {
			return uID;
		}


		public void setuID(int uID) {
			this.uID = uID;
		}


		public String getuName() {
			return uName;
		}


		public void setuName(String uName) {
			this.uName = uName;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getContactNo() {
			return contactNo;
		}


		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}


		public String getBranchName() {
			return branchName;
		}


		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}


		public String getuPassword() {
			return uPassword;
		}


		public void setuPassword(String uPassword) {
			this.uPassword = uPassword;
		}


		public int getUrole_ID() {
			return urole_ID;
		}


		public void setUrole_ID(int urole_ID) {
			this.urole_ID = urole_ID;
		}

		   
		
		   
}
