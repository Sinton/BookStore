package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Category;

public interface CategoryDao {
	boolean createCategory(Category category) throws SQLException;
	boolean updateCategory(Category category) throws SQLException;
	boolean deleteCategory(int categoryId) throws SQLException;
	ArrayList<Category> getAllCategories() throws SQLException;
	String getCategoryNameByCategoryId(int categoryId) throws SQLException;
}