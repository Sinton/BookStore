package edu.zjut.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.Category;
import edu.zjut.model.SecondCategory;
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
	 * 修改一级分类
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCategory(Category category) throws SQLException {
		String sql = "update form `t_category` set `category_name` = ? where category_id = ?";
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
	public boolean delteCategory(int categoryId) throws SQLException {
		String sql = "delete form `t_category` where category_id = ?";
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
	public ArrayList<Category> getAllCategories() throws SQLException {
		String sql = "select * from t_category;";
		pstmt = connection.prepareStatement(sql);
		rs = pstmt.executeQuery();
		ArrayList<Category> categories = new ArrayList<Category>();
		SecondCategoryDao secondCategoryDao = new SecondCategoryDao();
		while (rs.next()) {
			Category category = new Category();
			ArrayList<SecondCategory> secondCategories = secondCategoryDao.getSecondCategoriesByCategoryId(rs.getInt("category_id"));
			category.setCategoryId(rs.getInt("category_id"));
			category.setName(rs.getString("category_name"));
			category.setDesc(rs.getString("category_desc"));
			category.setSecondCategories(secondCategories);
			categories.add(category);
		}
		dbHelp.closeConn();
		return categories;
	}
}