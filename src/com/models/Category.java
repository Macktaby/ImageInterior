package com.models;

public class Category {

	// 3 used

	private int categoryID;
	private String name;
	private String description;

	public Category() {
		this.categoryID = 0;
		this.name = "";
		this.description = "";
	}

	public Category(int categoryID, String name, String description) {
		this.categoryID = categoryID;
		this.name = name;
		this.description = description;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
