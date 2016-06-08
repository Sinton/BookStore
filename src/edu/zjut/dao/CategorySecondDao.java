package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.CategorySecond;
import edu.zjut.utils.DBHelp;

public class CategorySecondDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public CategorySecondDao() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	public boolean addCategorySecond(CategorySecond categorySecond) throws SQLException {
		String sql = "insert";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorySecond.getSecondName());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 修改二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCategorySecond(CategorySecond categorySecond) throws SQLException {
		String sql = "update";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorySecond.getSecondName());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除指定二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteCategorySecond(int categorySecondId) throws SQLException {
		String sql = "delete form t_category_second where category_second_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, categorySecondId);
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取全部二级分类
	 * @param categoryId
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<CategorySecond> getAllCategorySeconds() throws SQLException {
		String sql = "select * from t_category_second;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<CategorySecond> secondCategories = new ArrayList<CategorySecond>();
		while (rs.next()) {
			CategorySecond secondCategory = new CategorySecond();
			secondCategory.setCategorySecondId(rs.getInt("category_second_id"));
			secondCategory.setSecondName(rs.getString("second_name"));
			secondCategory.setCategoryId(rs.getInt("category_id"));
			secondCategories.add(secondCategory);
		}
		dbHelp.closeConn();
		return secondCategories;
	}
}