package edu.zjut.dao;

import java.sql.SQLException;

import edu.zjut.model.Admin;

public interface AdminDao {
	public Admin getAdmin(String email, String password) throws SQLException;
}