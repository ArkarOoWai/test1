package user.model;

import java.io.Serializable;

public class LoginBean implements Serializable {

	private String userEmail;
	private String password;

	public LoginBean() {
		super();

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}