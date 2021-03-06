package com.models;

import java.sql.Timestamp;

public class PromotionLocation {

	private int promotionID;
	private int discount;
	private Timestamp startTime;
	private Timestamp endTime;
	private int productID;
	private String location;

	public PromotionLocation() {
		this.promotionID = 0;
		this.discount = 0;
		this.startTime = new Timestamp(0);
		this.endTime = new Timestamp(0);
		this.productID = 0;
		this.location = "";
	}

	public PromotionLocation(int promotionID, int discount, Timestamp startTime, Timestamp endTime, int productID,
			String location) {
		this.promotionID = promotionID;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
		this.productID = productID;
		this.location = location;
	}

	public int getPromotionID() {
		return promotionID;
	}

	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

}
