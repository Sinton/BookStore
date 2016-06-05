package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Category;
import edu.zjut.model.CategorySecond;
import edu.zjut.utils.DBHelp;

public class CategoryDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public CategoryDao() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加一级分类
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public boolean addCategory(Category category) throws SQLException {
		String sql = "";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, category.getName());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 添加二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	public boolean addCategorySecond(CategorySecond categorySecond) throws SQLException {
		String sql = "";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorySecond.getSecondName());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	public ArrayList<CategorySecond> getAllCategorySecond(int categoryId) {
		return null;
	}
}