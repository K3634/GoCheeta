package com.codewithkrishanthi.model;

public class Booking {
	
	   private int b_ID;
	   private String cName;
	   private String pickUp;
	   private String dropUp;
	   private String vCat;
	   private String b_date;
	   private int pay;
	   
	public Booking() {
		super();
		
	}

	public Booking(String cName, String pickUp, String dropUp, String vCat, String b_date, int pay) {
		super();
		this.cName = cName;
		this.pickUp = pickUp;
		this.dropUp = dropUp;
		this.vCat = vCat;
		this.b_date = b_date;
		this.pay = pay;
	}

	public Booking(int b_ID, String cName, String pickUp, String dropUp, String vCat, String b_date, int pay) {
		super();
		this.b_ID = b_ID;
		this.cName = cName;
		this.pickUp = pickUp;
		this.dropUp = dropUp;
		this.vCat = vCat;
		this.b_date = b_date;
		this.pay = pay;
	}

	public int getB_ID() {
		return b_ID;
	}

	public void setB_ID(int b_ID) {
		this.b_ID = b_ID;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropUp() {
		return dropUp;
	}

	public void setDropUp(String dropUp) {
		this.dropUp = dropUp;
	}

	public String getvCat() {
		return vCat;
	}

	public void setvCat(String vCat) {
		this.vCat = vCat;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}
	   
	

}
