package edu.zjut.model;

public class User {

	private int uid;
	private String salt;
	private String password;
	private String registerDate;
	private String profileId;

	public User() {
	}

	public User(int uid, String salt, String password, String registerDate, String profileId) {
		setUid(uid);
		setSalt(salt);
		setPassword(password);
		setRegisterDate(registerDate);
		setProfileId(profileId);
	}

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

	private void setUid(int uid) {
		this.uid = uid;
	}

	private void setSalt(String salt) {
		this.salt = salt;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	private void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	private void setProfileId(String profileId) {
		this.profileId = profileId;
	}
}