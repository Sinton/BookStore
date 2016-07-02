package edu.zjut.model;

import java.io.Serializable;

public class SecondCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int secondCategoryId;
	private String secondCategoryName;
	private int categoryId;
	
	public SecondCategory() {
	}
	
	public SecondCategory(int secondCategoryId, String secondCategoryName, int categoryId) {
		setSecondCategoryId(secondCategoryId);
		setSecondCategoryName(secondCategoryName);
		setCategoryId(categoryId);
	}

	public int getSecondCategoryId() {
		return secondCategoryId;
	}

	public void setSecondCategoryId(int secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}

	public String getSecondCategoryName() {
		return secondCategoryName;
	}

	public void setSecondCategoryName(String secondCategoryName) {
		this.secondCategoryName = secondCategoryName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}