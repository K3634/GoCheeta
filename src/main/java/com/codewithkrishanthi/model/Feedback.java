package com.codewithkrishanthi.model;

public class Feedback {

	private int b_ID;
	private String des;
	private String cName;

	public Feedback() {
		super();
		
	}

	public Feedback(String des, String cName) {
		super();
		this.des = des;
		this.cName = cName;
	}

	public Feedback(int b_ID, String des, String cName) {
		super();
		this.b_ID = b_ID;
		this.des = des;
		this.cName = cName;
	}

	public int getB_ID() {
		return b_ID;
	}

	public void setB_ID(int b_ID) {
		this.b_ID = b_ID;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}


	
	
	
}
