package edu.zjut.model;

public class User {

	private int uid;
	private String salt;
	private String password;
	private String registerDate;
	private String profileId;

	public int getUid() {
		return uid;
	}

	public String getSalt() {
		return salt;
	}

	public String getPassword() {
		return password;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
}