package edu.zjut.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.zjut.model.User;

public interface UserDao {
	boolean createUser(User user) throws SQLException;
	boolean updateUser(User user) throws SQLException;
	boolean deleteUser(int uid) throws SQLException;
	User getUserByUid(int uid) throws SQLException;
	int getUid(String email) throws SQLException;
	ArrayList<User> getAllUsers() throws SQLException;
	boolean deleteAllUsers(ArrayList<Integer> uids) throws SQLException;
}