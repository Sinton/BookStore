package edu.zjut.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int categoryId;
	private String name;
	private String desc;
	private ArrayList<SecondCategory> secondCategories;

	public Category() {
	}
	
	public Category(int categoryId, String name, String desc, ArrayList<SecondCategory> secondCategories) {
		setCategoryId(categoryId);
		setName(name);
		setDesc(desc);
		setSecondCategories(secondCategories);
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

	public ArrayList<SecondCategory> getSecondCategories() {
		return secondCategories;
	}

	public void setSecondCategories(ArrayList<SecondCategory> secondCategories) {
		this.secondCategories = secondCategories;
	}
}