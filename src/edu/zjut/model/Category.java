package edu.zjut.model;

public class Category {

	private int categoryId;
	private String name;
	private String desc;

	public Category() {
	}
	
	public Category(int categoryId, String name, String desc) {
		setCategoryId(categoryId);
		setName(name);
		setDesc(desc);
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}