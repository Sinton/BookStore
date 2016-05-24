package edu.zjut.model;

public class Admin {

	private int adminId;
	private String name;
	private String salt;
	private String password;

	public Admin() {
	}

	public Admin(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}