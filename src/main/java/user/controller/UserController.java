package user.controller;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import user.model.LoginBean;
import user.model.UserBean;
import user.repository.UserdbRepository;

@Controller
public class UserController {

	@GetMapping(value = "/")
	public ModelAndView showLogin() {
		return new ModelAndView("logindb", "loginbean", new LoginBean());
	}

	@PostMapping(value = "/checkUser")
	public String checkUser(@ModelAttribute("loginbean") LoginBean bean, Model m,HttpSession session) {
		UserdbRepository userRepo = new UserdbRepository();
		UserBean ubean = new UserBean();
		ubean = userRepo.loginUser(bean);
		session.setAttribute("user", ubean);
		if (ubean == null) {
			session.setAttribute("error", "Email and Password do not match");
			return "redirect:/";
		}else {
			if(ubean.getRole().equals("Admin")) {
				return "redirect:course/admin";
			}else {
				return "redirect:course/user";
			}
		}
	}
	
	/*
	 * @GetMapping(value = "/admin") public String showAdmin() { return "adminview";
	 * }
	 */
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	}
