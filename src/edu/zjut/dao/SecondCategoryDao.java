package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.SecondCategory;

public interface SecondCategoryDao {
	boolean createSecondCategory(SecondCategory categorySecond) throws SQLException;
	boolean updateSecondCategory(SecondCategory categorySecond) throws SQLException;
	boolean deleteSecondCategory(int categorySecondId) throws SQLException;
	ArrayList<SecondCategory> getAllSecondCategories() throws SQLException;
	ArrayList<SecondCategory> getSecondCategoriesByCategoryId(int categoryId) throws SQLException;
	int getCategoryIdByName(String categoryName) throws SQLException;
	int getSecondCategoryIdByName(String categoryName) throws SQLException;
}