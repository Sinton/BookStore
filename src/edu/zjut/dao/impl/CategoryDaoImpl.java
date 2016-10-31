package edu.zjut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.dao.CategoryDao;
import edu.zjut.model.Category;
import edu.zjut.model.SecondCategory;
import edu.zjut.utils.DBHelp;

public class CategoryDaoImpl implements CategoryDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection connection = null;
	private DBHelp dbHelp = new DBHelp();
	
	public CategoryDaoImpl() {
		connection = dbHelp.getConn();
	}

	/**
	 * 添加一级分类
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean createCategory(Category category) throws SQLException {
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
	 * 修改一级分类
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean updateCategory(Category category) throws SQLException {
		String sql = "UPDATE FORM `t_category` SET `category_name` = ? WHERE category_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, category.getName());
		pstmt.setInt(2, category.getCategoryId());
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 删除指定一级分类
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	@Override
	public boolean deleteCategory(int categoryId) throws SQLException {
		String sql = "DELETE FORM `t_category` WHERE category_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, categoryId);
		int result = pstmt.executeUpdate();
		if (pstmt != null)
			pstmt.close();
		dbHelp.closeConn();
		return result > 0 ? true : false;
	}
	
	/**
	 * 获取全部一级分类
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ArrayList<Category> getAllCategories() throws SQLException {
		String sql = "SELECT * FROM t_category;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Category> categories = new ArrayList<Category>();
		SecondCategoryDaoImpl secondCategoryDao = new SecondCategoryDaoImpl();
		while (rs.next()) {
			Category category = new Category();
			ArrayList<SecondCategory> secondCategories = secondCategoryDao.getSecondCategoriesByCategoryId(rs.getInt("category_id"));
			category.setCategoryId(rs.getInt("category_id"));
			category.setName(rs.getString("category_name"));
			category.setDesc(rs.getString("category_desc"));
			category.setSecondCategories(secondCategories);
			categories.add(category);
		}
		return categories;
	}
	
	/**
	 * 根据一级分类Id获取该分类名称
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public String getCategoryNameByCategoryId(int categoryId) throws SQLException {
		String sql = "SELECT category_name FROM t_category WHERE category_id = ?";
		pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, categoryId);
		rs = pstmt.executeQuery();
		String categoryName = "";
		if (rs.next()) {
			categoryName = rs.getString("category_name");
		}
		return categoryName;
	}
}