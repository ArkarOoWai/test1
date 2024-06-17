package user.model;

import java.io.Serializable;

public class UserCourseBean implements Serializable{

	private int userId;
	private int[] userCourseList;
	
	public UserCourseBean() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int[] getUserCourseList() {
		return userCourseList;
	}

	public void setUserCourseList(int[] userCourseList) {
		this.userCourseList = userCourseList;
	}
}
