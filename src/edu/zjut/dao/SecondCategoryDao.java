package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.SecondCategory;
import edu.zjut.utils.DBHelp;

public class SecondCategoryDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public SecondCategoryDao() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	public boolean addSecondCategory(SecondCategory categorySecond) throws SQLException {
		String sql = "insert";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorySecond.getSecondCategoryName());
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
	public boolean updateSecondCategory(SecondCategory categorySecond) throws SQLException {
		String sql = "update";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categorySecond.getSecondCategoryName());
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
	public boolean deleteSecondCategory(int categorySecondId) throws SQLException {
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
	public ArrayList<SecondCategory> getAllSecondCategories() throws SQLException {
		String sql = "select * from t_second_category;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<SecondCategory> secondCategories = new ArrayList<SecondCategory>();
		while (rs.next()) {
			SecondCategory secondCategory = new SecondCategory();
			secondCategory.setSecondCategoryId(rs.getInt("second_category_id"));
			secondCategory.setSecondCategoryName(rs.getString("second_category_name"));
			secondCategory.setCategoryId(rs.getInt("category_id"));
			secondCategories.add(secondCategory);
		}
		dbHelp.closeConn();
		return secondCategories;
	}
	
	/**
	 * 获取一级分类下的全部二级分类
	 * @param categoryId
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<SecondCategory> getSecondCategoriesByCategoryId(int categoryId) throws SQLException {
		String sql = "select * from t_second_category where category_id = ?;";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, categoryId);
		rs = pstmt.executeQuery();
		ArrayList<SecondCategory> secondCategories = new ArrayList<SecondCategory>();
		while (rs.next()) {
			SecondCategory secondCategory = new SecondCategory();
			secondCategory.setSecondCategoryId(rs.getInt("second_category_id"));
			secondCategory.setSecondCategoryName(rs.getString("second_category_name"));
			secondCategory.setCategoryId(rs.getInt("category_id"));
			secondCategories.add(secondCategory);
		}
		return secondCategories;
	}
}