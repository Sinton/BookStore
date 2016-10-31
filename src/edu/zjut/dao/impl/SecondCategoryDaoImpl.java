package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.dao.SecondCategoryDao;
import edu.zjut.model.SecondCategory;
import edu.zjut.utils.DBHelp;

public class SecondCategoryDaoImpl implements SecondCategoryDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public SecondCategoryDaoImpl() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加二级分类
	 * @param categorySecond
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean createSecondCategory(SecondCategory categorySecond) throws SQLException {
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
	@Override
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
	@Override
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
	@Override
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
		return secondCategories;
	}
	
	/**
	 * 获取一级分类下的全部二级分类
	 * @param categoryId
	 * @return
	 * @throws SQLException 
	 */
	@Override
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
	
	/**
	 * 根据二级分类名获取二级分类ID
	 * @param categoryName
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int getCategoryIdByName(String categoryName) throws SQLException {
		String sql = "SELECT category_id FROM t_second_category WHERE second_category_name = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categoryName);
		rs = pstmt.executeQuery();
		int categoryId = 0;
		if (rs.next()) {
			categoryId = rs.getInt("category_id");
		}
		if (pstmt != null)
			pstmt.close();
		return categoryId;
	}
	
	/**
	 * 根据一级分类名获取二级分类ID
	 * @param categoryName
	 * @return
	 * @throws SQLException
	 */
	@Override
	public int getSecondCategoryIdByName(String categoryName) throws SQLException {
		String sql = "SELECT second_category_id FROM t_second_category WHERE second_category_name = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, categoryName);
		rs = pstmt.executeQuery();
		int secondCategoryId = 0;
		if (rs.next()) {
			secondCategoryId = rs.getInt("second_category_id");
		}
		if (pstmt != null)
			pstmt.close();
		return secondCategoryId;
	}
}