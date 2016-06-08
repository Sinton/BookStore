package edu.zjut.model;

public class CategorySecond {
	
	private int categorySecondId;
	private String secondName;
	private int categoryId;
	
	public CategorySecond() {
	}
	
	public CategorySecond(int categorySecondId, String secondName, int categoryId) {
		setCategorySecondId(categorySecondId);
		setSecondName(secondName);
		setCategoryId(categoryId);
	}

	public int getCategorySecondId() {
		return categorySecondId;
	}

	public void setCategorySecondId(int categorySecondId) {
		this.categorySecondId = categorySecondId;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}