package edu.zjut.model;

public class CategorySecond {
	
	private int categorySecondId;
	private String secondName;
	
	public CategorySecond(String secondName) {
		setSecondName(secondName);
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
}