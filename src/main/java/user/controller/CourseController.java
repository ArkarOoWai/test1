package user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import user.model.CourseBean;
import user.model.LoginBean;
import user.model.UserBean;
import user.model.UserCourseBean;
import user.model.UserSelectCourse;
import user.repository.CoursedbRepository;
import user.repository.UserdbRepository;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

	@GetMapping(value = "/addCourse")
	public ModelAndView addCourse() {
		return new ModelAndView("addCourse", "course", new CourseBean());
	}
	
	
	@GetMapping(value = "/admin")
	public String showadmin() {
		return "adminview";
	}
	
	@GetMapping(value = "/user")
	public String showuser() {
		return "userview";
	}
	
	@GetMapping(value = "/createcourse")
	public ModelAndView createCourse() {
		return new ModelAndView("addCourse", "course", new CourseBean());
		
	}
	
	
	@PostMapping(value = "/create")
	public  String courseCreate(@ModelAttribute("course") CourseBean bean,Model m) {
		CoursedbRepository courserepo = new CoursedbRepository();
		int result = courserepo.InsertCourse(bean);
		if(result > 0) {
			m.addAttribute("success","Register Course Successful");
			return "redirect:showall";
		}else {
			m.addAttribute("error","Register course fail");
			return "redirect:addCourse";
		}
		
		
	}
	@GetMapping(value = "/showall")
	public String showAllCourse(Model m,HttpSession session) {
	CoursedbRepository courserepo= new CoursedbRepository();
		List<CourseBean> lstCourse=courserepo.selectAllCourse();
		m.addAttribute("nextCourse", lstCourse);
		UserBean user = (UserBean) session.getAttribute("user");
		if(user.getRole().equals("Admin")) {
			return "showCourse";
			
			} else {
				m.addAttribute("usercourse", new UserCourseBean());
		return "choosecourse";

	}
	}
		
		@PostMapping(value="/chooseCourse")
		public String chooseCourse(@ModelAttribute("usercourse")UserCourseBean bean,Model m) {
			CoursedbRepository courserepo= new CoursedbRepository();
			
			int result = courserepo.insertUserCourse(bean);
			if(result>0) {
				m.addAttribute("usercourse",bean);
				return "redirect:selectedcourse";
			}else {
				return "redirect:showall";
			}
			
		}
		
		
		@GetMapping(value = "/selectedcourse")
		public String showUserCourse(Model m,HttpSession session) {
			UserBean user= (UserBean) session.getAttribute("user");
			String name = user.getUserName();
			session.setAttribute("UserName", name);
			CoursedbRepository courserepo= new CoursedbRepository();
			List<UserSelectCourse> lstUserCourse = courserepo.selectUserCourse(user.getUserId());
			
			m.addAttribute("lstUserCourse", lstUserCourse);
			return "usercourse";
		}
		
		
		@GetMapping("/edit/{id}")
		public ModelAndView deitCourse(@PathVariable("id")int cid) {
			CoursedbRepository courserepo= new CoursedbRepository();
			CourseBean bean= courserepo.selectOne(cid);
			return new ModelAndView("courseedit","course",bean);
		}
		
		@PostMapping(value = "/update")
		public  String courseUpdate(@ModelAttribute("course") CourseBean bean,Model m) {
			CoursedbRepository courserepo = new CoursedbRepository();
			int result = courserepo.updateCourse(bean);
			if(result > 0) {
				m.addAttribute("success","Register Course Successful");
				return "redirect:showall";
			}else {
				m.addAttribute("error","Register course fail");
				return "redirect:addCourse";
			}

}	
}

