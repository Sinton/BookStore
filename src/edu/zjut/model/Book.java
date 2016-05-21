package edu.zjut.model;

public class Book {

	private int bookId;
	private String salt;
	private String password;
	private String registerDate;
	private String profileId;

	public Book() {
	}

	public Book(int uid, String salt, String password, String registerDate, String profileId) {
		setUid(uid);
		setSalt(salt);
		setPassword(password);
		setRegisterDate(registerDate);
		setProfileId(profileId);
	}

	public int getUid() {
		return bookId;
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
		this.bookId = uid;
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