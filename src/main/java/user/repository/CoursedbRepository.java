package user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.model.CourseBean;
import user.model.UserCourseBean;
import user.model.UserSelectCourse;



public class CoursedbRepository {
	
	public List<CourseBean> selectAllCourse(){
		
		List<CourseBean> courseLst = new ArrayList<CourseBean>();
		CourseBean course=null;
		Connection con=ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from course where status<>0");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				course = new CourseBean();
				course.setcId(rs.getInt("course_id"));
				course.setcName(rs.getString("name"));
				course.setcFees(rs.getDouble("fees"));
				course.setcDuration(rs.getDouble("duration"));
				courseLst.add(course);
			}
		}catch (SQLException e) {
			System.out.println("User Select : " + e.getMessage()); 
		}
		
		return courseLst;
	}
	
	
	public CourseBean selectOne(int courseId) {
		CourseBean bean=null;
		Connection con = ConnectionClass.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from course where course_id=?");
			
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bean = new CourseBean();
				bean.setcId(rs.getInt("course_id"));
				bean.setcName(rs.getString("name"));
				bean.setcFees(rs.getDouble("fees"));
				bean.setcDuration(rs.getDouble("duration"));
				bean.setStatus(rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("select one course : "+e.getMessage());
		}
	
	
	
	return bean;
}
	
	public int updateCourse(CourseBean bean) {
		int i=0;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update course set name=?,fees=?,duration=?,status=? where course_id=?");
			ps.setString(1, bean.getcName());
			ps.setDouble(2, bean.getcFees());
			ps.setDouble(3, bean.getcDuration());
			ps.setBoolean(4, bean.isStatus());
			ps.setInt(5, bean.getcId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("course update : " + e.getMessage());
		}
		return i;
	}
	
	public int deleteCourse(int courseId) {
		int result=0;
		Connection con=ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(" update course set status=0 where course_id=?");
			ps.setInt(1, courseId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("delete course : "+e.getMessage());

		}
		
		return result;
	}
	
	public int InsertCourse(CourseBean bean) {
		int result=0;
		Connection con = ConnectionClass.getConnection();
		//if(!checkName(bean.getcName())) {
			try {
				PreparedStatement ps = con.prepareStatement("insert into course (name,fees,duration) values (?,?,?)");
				ps.setString(1, bean.getcName());
				ps.setDouble(2, bean.getcFees());
				ps.setDouble(3, bean.getcDuration());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("course insert : "+ e.getMessage());
			}
		
		return result;
	}
	public int insertUserCourse(UserCourseBean bean) {
		int result=0;
		Connection con = ConnectionClass.getConnection();
		PreparedStatement ps=null;
		for(int i=0;i<bean.getUserCourseList().length;i++) {
			try {
				ps = con.prepareStatement("insert into user_course(user_id, course_id) values (?,?)");
				ps.setInt(1, bean.getUserId());
				ps.setInt(2, bean.getUserCourseList()[i]);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("user course error : " + e.getMessage());
			}		
		}
		return result;
	}
	
	public List <UserSelectCourse> selectUserCourse(int userId){
		UserSelectCourse bean=null;
		List<UserSelectCourse> lstUserCourse=new ArrayList<UserSelectCourse>();
		Connection con= ConnectionClass.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select distinct uc.user_id,uc.course_id,u.name as username,c.name as coursename from user_course uc join userdb u on u.user_id = uc.user_id join course c on c.course_id = uc.course_id where uc.user_id = ?");
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new UserSelectCourse();
				bean.setUseId(rs.getInt("user_id"));
				bean.setCourseId(rs.getInt("course_id"));
				bean.setUserName(rs.getString("username"));
				bean.setCourseName(rs.getString("coursename"));
				lstUserCourse.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("user course error : " + e.getMessage());
		}
		return lstUserCourse;
	}
	
}
