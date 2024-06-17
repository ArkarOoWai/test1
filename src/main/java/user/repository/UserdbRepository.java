package user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.model.LoginBean;
import user.model.UserBean;
import user.model.UserCourseBean;

public class UserdbRepository {

	public int insertUser(UserBean bean) {
		Connection con = ConnectionClass.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into userdb(name,email,password) values(?,?,?)");
			ps.setString(1, bean.getUserName());
			ps.setString(2, bean.getUserEmail());
			ps.setString(3, bean.getPassword());

		} catch (SQLException e) {
			System.out.println("user insert : " + e.getMessage());
		}

		return result;

	}

	public boolean checkEmail(LoginBean bean) {
		boolean status = false;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select email from userdb where email=?;");
			ps.setString(1, bean.getUserEmail());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				status = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("checek email : " + e.getMessage());
		}

		return status;

	}

	public UserBean loginUser(LoginBean bean) {
		UserBean user = null;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from userdb where email=? and password=?");
			ps.setString(1, bean.getUserEmail());
			ps.setString(2, bean.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new UserBean();
				user.setUserName(rs.getString("name"));
				user.setUserEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("user_id"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return user;

	}
	
	

}
