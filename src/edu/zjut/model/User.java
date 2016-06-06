package edu.zjut.model;

public class User {

	private int uid;
	private String email;
	private String password;
	private long registerDate;

	public User() {
	}
	
	public User(String email, String password, long registerDate) {
		setEmail(email);
		setPassword(password);
		setRegisterDate(registerDate);
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(long registerDate) {
		this.registerDate = registerDate;
	}
}